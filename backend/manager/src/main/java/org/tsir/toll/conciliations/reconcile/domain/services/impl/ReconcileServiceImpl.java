package org.tsir.toll.conciliations.reconcile.domain.services.impl;

import static org.tsir.common.api.security.Constants.SUPER_SECRET_KEY;
import static org.tsir.common.api.security.Constants.TOKEN_BEARER_PREFIX;

import java.awt.color.ProfileDataException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.FormatterClosedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.collections4.IterableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Service;
import org.tsir.common.api.exceptions.NotFoundException;
import org.tsir.common.api.exceptions.NotSupportCriteriaException;
import org.tsir.common.services.CommunicationsService;
import org.tsir.common.services.parameter.dto.ParameterDTO;
import org.tsir.common.utils.PagingUtils;
import org.tsir.common.utils.SortingKey;
import org.tsir.toll.conciliations.reconcile.domain.dto.LaneDTO;


import org.tsir.toll.conciliations.reconcile.domain.dto.UserDTO;
import org.tsir.toll.conciliations.reconcile.domain.dto.PlacDTO;
import org.tsir.toll.conciliations.reconcile.domain.entities.QReconcile;
import org.tsir.toll.conciliations.reconcile.domain.entities.QTranCons;
import org.tsir.toll.conciliations.reconcile.domain.entities.Reconcile;

import org.tsir.toll.conciliations.reconcile.domain.entities.TranCons;
import org.tsir.toll.conciliations.reconcile.domain.entities.NoveConc;
import org.tsir.toll.conciliations.reconcile.domain.entities.NoveTran;
import org.tsir.toll.conciliations.reconcile.domain.entities.DetaPago;
import org.tsir.toll.conciliations.reconcile.domain.entities.CierDia;
import org.tsir.toll.conciliations.reconcile.domain.services.ReconcileService;
import org.tsir.toll.conciliations.reconcile.domain.values.ConcCriteria;
import org.tsir.toll.conciliations.reconcile.domain.values.ReconcileStatusEnum;
import org.tsir.toll.conciliations.reconcile.domain.values.Responsable;
import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.NoveConcRepository;
import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.NoveTranRepository;
import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.ReconcileRepository;

import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.TranConsRepository;


import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.CierDiaRepository;
import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.DetaPagoRepository;
import org.tsir.toll.conciliations.reconcile.application.utils.WebClientServices;

import org.tsir.toll.conciliations.reconcile.application.utils.CreateLog;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.persistence.NoResultException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.UnavailableException;

@Service
public class ReconcileServiceImpl implements ReconcileService {



	@Autowired
	private ReconcileRepository reconcileDAO;


	Logger log = LoggerFactory.getLogger(ReconcileServiceImpl.class);

	
	private Predicate getPredicate(QReconcile q, String criteria, String value) {
		switch (criteria) {

		case "RECONCILEID":

			return q.reconcileId.stringValue().equalsIgnoreCase(value);

		case "DATECOLLECTION":
			return q.dateCollection.stringValue().equalsIgnoreCase(value);
		/*
		 * case "STATIONAME": return q..contains(value);
		 */
		case "LANEID":
			return q.laneId.stringValue().equalsIgnoreCase(value);

		case "STATUSCONC":
			return q.reconcileStatus.stringValue().equalsIgnoreCase(value);

		case "TURNCODE":
			return q.turnId.stringValue().equalsIgnoreCase(value);

	//	case "PAYMENTID":

			//return q.idTranCons.idFormPago.stringValue().equalsIgnoreCase(value);

		case "CATEGORYID":

			return q.reconcileCategory.stringValue().equalsIgnoreCase(value);
		
		case "TIKETENUM":
			return q.idTranCons.tiqueteInvias.stringValue().equalsIgnoreCase(value);

		case "IDTRANCONS": // Esta validación viene desde el front de conciliacion masiva
			if (value.equals("null"))
				return q.idTranCons.idTranCons.isNull();
			return q.idTranCons.idTranCons.stringValue().equalsIgnoreCase(value);

		case "IDTRANDAC":
			if (value.equals("!")) // Esta validación viene desde el front de conciliacion masiva
				return q.idTranDac.idTranDac.isNotNull();
			return q.idTranDac.idTranDac.stringValue().equalsIgnoreCase(value);

		/*
		 * case "TICKETNUMBER":
		 * 
		 * return null;
		 */

		default:
			throw new NotSupportCriteriaException("Conciliacion", criteria);
		}
	}

	@Override
	public List<Reconcile> getReconcile(Map<String, String> filter,Map<String, Integer> paging) {
		List<Reconcile> lista = new ArrayList<>();
		Map<String, String> sortingProperties = new HashMap<>();
		BooleanBuilder builder = new BooleanBuilder();
		QReconcile qReconcile = QReconcile.reconcile;
		log.info(qReconcile.reconcileId.asc().toString());
		Sort sort = new QSort(qReconcile.reconcileId.asc());
		if (filter != null && !filter.isEmpty()) {
			ComparableExpressionBase<?> expression = getField(sortingProperties.getOrDefault(SortingKey.FIELD.toString(), ConcCriteria.CODE_KEY.getKey()),qReconcile);
			sort = PagingUtils.getSortEspecification(sortingProperties, expression);
			Pageable pageable = PagingUtils.getPageable(paging, sort);
			
			
			filter.forEach((k, v) -> builder.and(getPredicate(qReconcile, k, v)));
			lista = IterableUtils.toList(reconcileDAO.findAll(builder, pageable));
		} else {
			lista = reconcileDAO.findAll(sort);
		}

		for (Reconcile obj : lista) {
			Long idUsrsTurnConsola = null;
			String idUsrsTurnConsolaname = null;
			String numPlaca = null;
			Long idUsrsDac = null;
			String idUsrsDacname = null;
			if (obj.getIdTranCons() != null) {// Si la transaccion trae consola el recolector es el de tran_cons
				idUsrsTurnConsola = obj.getIdTranCons().getIdUsrsTurn().getUsrs().getCodigoUsrs();
				idUsrsTurnConsolaname = obj.getIdTranCons().getIdUsrsTurn().getUsrs().getNombreUsrs();
				numPlaca = obj.getIdTranCons().getPlacaDetectada();
				// log.info("USUARIO TRAN_CONS : "+idUsrsTurnConsola);
				obj.setCodUsrsConc(idUsrsTurnConsola);
				obj.setCodUsrs(idUsrsTurnConsolaname);
				// No se hace consumo a la API USRS porque no se ha creado la consulta
			} else if (obj.getTranDac() != null) {// Si la transaccion tiene DAC el recolector es el de tran_dac
				idUsrsDac = obj.getTranDac().getIdUsrs().getCodigoUsrs();
				idUsrsDacname = obj.getTranDac().getIdUsrs().getNombreUsrs();
				obj.setCodUsrsConc(idUsrsDac);
				obj.setCodUsrs(idUsrsDacname);
			}

		}
		lista.sort((d1, d2) -> d1.getFechaTran().compareTo(d2.getFechaTran()));// Se ordena la lista por la fecha_tran

		return lista;
	}
	
	private ComparableExpressionBase<?> getField(String field, QTranCons q) {
		ConcCriteria pc = ConcCriteria.fromKey(field);
		if (Objects.isNull(pc)) {
			return q.idTranCons;
		}
		switch (pc) {
		case CODE_KEY:
			return q.idTranCons;
		default:
			return q.idTranCons;
		}
	}
	
	private ComparableExpressionBase<?> getField(String field, QReconcile q) {
		ConcCriteria pc = ConcCriteria.fromKey(field);
		if (Objects.isNull(pc)) {
			return q.reconcileId;
		}
		switch (pc) {
		case CODE_KEY:
			return q.reconcileId;
		default:
			return q.reconcileId;
		}
		
	}

}
