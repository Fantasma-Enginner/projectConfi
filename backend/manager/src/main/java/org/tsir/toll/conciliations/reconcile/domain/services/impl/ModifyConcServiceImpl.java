package org.tsir.toll.conciliations.reconcile.domain.services.impl;

import java.awt.color.ProfileDataException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.UnavailableException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsir.common.services.CommunicationsService;
import org.tsir.toll.conciliations.reconcile.application.MappingFactory;
import org.tsir.toll.conciliations.reconcile.application.utils.CreateLog;
import org.tsir.toll.conciliations.reconcile.application.utils.WebClientServices;
import org.tsir.toll.conciliations.reconcile.domain.dto.LaneDTO;
import org.tsir.toll.conciliations.reconcile.domain.dto.PlacDTO;
import org.tsir.toll.conciliations.reconcile.domain.dto.ReconcileDTO;
import org.tsir.toll.conciliations.reconcile.domain.dto.TranConsDTO;
import org.tsir.toll.conciliations.reconcile.domain.entities.CierDia;
import org.tsir.toll.conciliations.reconcile.domain.entities.Reconcile;
import org.tsir.toll.conciliations.reconcile.domain.entities.TranCons;
import org.tsir.toll.conciliations.reconcile.domain.services.ModifyConcservice;
import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.CierDiaRepository;
import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.ModifiConcUpdateRepository;
import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.ReconcileRepository;

@Service
public class ModifyConcServiceImpl implements  ModifyConcservice {
	MappingFactory mapper = new MappingFactory();

	@Autowired
	private ModifiConcUpdateRepository modifiConcUpdateRepository;
	
	@Autowired
	private CierDiaRepository cierDiaRepository;
	
	@Autowired
	private CommunicationsService communicationService;
	
	@Autowired
	private CreateLog createLog;
	
	@Autowired
	private WebClientServices webClient;
	
	Logger log = LoggerFactory.getLogger(ModifyConcServiceImpl.class);
	@Override
	public HashMap<String, String> putConc(Long code, ReconcileDTO body, Long idUsuario, String token) {
		
		Optional<Reconcile> updateConcDB = modifiConcUpdateRepository.findById(code);
		HashMap<String, String> respuesta = new HashMap<>();
		Reconcile concUpdate = updateConcDB.get();
		
		
		
		String vonverter = body.getDateCollection();
	      // parsing the string to convert it into date
	    LocalDate local_date = LocalDate.parse(vonverter);
		CierDia cierdia = cierDiaRepository.cierreporfecha(local_date);
		//valaida ci el dia esta avierto o cerrado 0 1	
		
		Integer estacion = null;
		List<LaneDTO> lanes = null;
	    lanes = webClient.getCodStationForLane(concUpdate.getLaneId(), token);
		if (lanes != null) {
			lanes.get(0).getToll();
			estacion = lanes.get(0).getToll();
			log.info("Esta es mi estacion:"+estacion);
		}
		if (cierdia != null && cierdia.getEstado() == 1) {
			respuesta.put("errorDia", "No se puede crear la discrepancia.");
			return respuesta;
		}else {
			
			concUpdate.setReconcileCategory(body.getConsoleCategory().longValue());
			concUpdate.setReconcileStatus("S");
			modifiConcUpdateRepository.save(concUpdate);
			communicationService.createTask("CONC-U", concUpdate.getReconcileId());
			createLog.insertLog("Se creo la discrepnacia con el id:"
			+concUpdate.getReconcileId()
			+"La estacion id:"
			+estacion
			+"fecha transacción:"+new Timestamp(System.currentTimeMillis()), "Crear discrepancia", estacion.longValue(), token);

		}
		           
		
		return respuesta;
	
			
	
	}

 
}
