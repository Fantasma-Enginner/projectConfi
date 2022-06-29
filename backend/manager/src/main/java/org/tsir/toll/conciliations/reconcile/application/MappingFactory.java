package org.tsir.toll.conciliations.reconcile.application;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.tsir.toll.conciliations.reconcile.domain.dto.ReconcileDTO;

import org.tsir.toll.conciliations.reconcile.domain.dto.TranConsDTO;
import org.tsir.toll.conciliations.reconcile.domain.dto.TranDACDTO;
import org.tsir.toll.conciliations.reconcile.domain.entities.NoveConc;
import org.tsir.toll.conciliations.reconcile.domain.entities.Reconcile;
import org.tsir.toll.conciliations.reconcile.domain.entities.TranCons;
import org.tsir.toll.conciliations.reconcile.domain.entities.TranDac;
import org.tsir.toll.conciliations.reconcile.domain.entities.Usrs;
import org.tsir.toll.conciliations.reconcile.domain.entities.UsrsTurn;
import org.tsir.toll.conciliations.reconcile.domain.values.Manten;
import org.tsir.toll.conciliations.reconcile.domain.values.Sent;
import org.tsir.toll.conciliations.reconcile.domain.values.Simulation;
import org.tsir.toll.conciliations.reconcile.domain.values.Violation;
import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.NoveTranRepository;
import org.tsir.toll.conciliations.reconcile.domain.entities.NoveTran;
import org.tsir.toll.conciliations.reconcile.domain.entities.Plac;
import org.tsir.toll.conciliations.reconcile.application.utils.WebClientServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MappingFactory {

	@Autowired
	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private WebClientServices webClient;

	@Autowired
	private NoveTranRepository NoveTranDAO;
	
	Logger log = LoggerFactory.getLogger(MappingFactory.class);

	public void loadReconcileMapping() {

		setMappingReconcile();
	}
	
	public void loadTransactionsMapping() {

		modelMapper.addConverter(this::getTimestamp, LocalDateTime.class, Timestamp.class);
		modelMapper.addConverter(this::getTimestampString, Timestamp.class, LocalDateTime.class);
		
		modelMapper.addConverter(this::getUsrs, Long.class, Usrs.class);
		modelMapper.addConverter(this::getLongUsrs, Usrs.class, Long.class);
		
		modelMapper.addConverter(this::getSentEnum, String.class, Sent.class);
		modelMapper.addConverter(this::getSentCode, Sent.class, String.class);
		
		modelMapper.addConverter(this::getMantenEnum, String.class, Manten.class);
		modelMapper.addConverter(this::getMantenCode, Manten.class, String.class);
		
		modelMapper.addConverter(this::getViolationEnum, String.class, Violation.class);
		modelMapper.addConverter(this::getViolationCode, Violation.class, String.class);
		
		modelMapper.addConverter(this::getSimulationEnum, String.class, Simulation.class);
		modelMapper.addConverter(this::getSimulationCode, Simulation.class, String.class);
		
		modelMapper.addConverter(this::getUsrsTurnEntity, Long.class, UsrsTurn.class); 
		modelMapper.addConverter(this::getUsrsTurnDTO, UsrsTurn.class, Long.class);
		
		modelMapper.addConverter(this::getPlacEntity, String.class, Plac.class); 
		modelMapper.addConverter(this::getPlacIdString, Plac.class, String.class);
		
		setMappingTranCons();
		setMappingTranDac();
		
	}

	private void setMappingTranDac() {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		modelMapper.typeMap(TranDACDTO.class, TranDac.class).addMappings(mapper -> {
			mapper.map(TranDACDTO::getTranDACId, TranDac::setIdTranDac);
			mapper.map(TranDACDTO::getAxisDoublesDetect, TranDac::setEjesDoblesTranDac);
			mapper.map(TranDACDTO::getAxisTranDac, TranDac::setEjesTranDac);
			mapper.map(TranDACDTO::getCarrId, TranDac::setIdCarr);
			mapper.map(TranDACDTO::getCateId, TranDac::setIdCate);
			mapper.map(TranDACDTO::getConsecutive, TranDac::setConsecutive);
			mapper.map(TranDACDTO::getDateRec, TranDac::setFechaRec);
			mapper.map(TranDACDTO::getDateRecTranDac, TranDac::setFechaRecTranDac);
			mapper.map(TranDACDTO::getDateTranDac, TranDac::setFechaTranDac);
			mapper.map(TranDACDTO::getManteni, TranDac::setMantenimiento);
			mapper.map(TranDACDTO::getReceiptData, TranDac::setReceiptData);
			mapper.map(TranDACDTO::getSentidoDac, TranDac::setSentidoTranDac);
			mapper.map(TranDACDTO::getSimulation, TranDac::setSimulacion);
			mapper.map(TranDACDTO::getTurnCode, TranDac::setCodigoTurn);
			mapper.map(TranDACDTO::getUsrsId, TranDac::setIdUsrs);
			mapper.map(TranDACDTO::getViolation, TranDac::setViolacion);
		});

		modelMapper.typeMap(TranDac.class, TranDACDTO.class).addMappings(mapper -> {
			mapper.map(TranDac::getIdTranDac, TranDACDTO::setTranDACId);
			mapper.map(TranDac::getEjesDoblesTranDac, TranDACDTO::setAxisDoublesDetect);
			mapper.map(TranDac::getEjesTranDac, TranDACDTO::setAxisTranDac);
			mapper.map(TranDac::getIdCarr, TranDACDTO::setCarrId);
			mapper.map(TranDac::getIdCate, TranDACDTO::setCateId);
			mapper.map(TranDac::getConsecutive, TranDACDTO::setConsecutive);
			mapper.map(TranDac::getFechaRec, TranDACDTO::setDateRec);
			mapper.map(TranDac::getFechaRecTranDac, TranDACDTO::setDateRecTranDac);
			mapper.map(TranDac::getFechaTranDac, TranDACDTO::setDateTranDac);
			mapper.map(TranDac::getMantenimiento, TranDACDTO::setManteni);
			mapper.map(TranDac::getReceiptData, TranDACDTO::setReceiptData);
			mapper.map(TranDac::getSentidoTranDac, TranDACDTO::setSentidoDac);
			mapper.map(TranDac::getSimulacion, TranDACDTO::setSimulation);
			mapper.map(TranDac::getCodigoTurn, TranDACDTO::setTurnCode);
			mapper.map(TranDac::getIdUsrs, TranDACDTO::setUsrsId);
			mapper.map(TranDac::getViolacion, TranDACDTO::setViolation);


		});
		
	}
	
	private void setMappingTranCons() {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		modelMapper.typeMap(TranConsDTO.class, TranCons.class).addMappings(mapper -> {
			mapper.map(TranConsDTO::getTranConsId, TranCons::setIdTranCons);
			mapper.map(TranConsDTO::getCateId, TranCons::setIdCate);
			//mapper.map(TranConsDTO::getIdUsrsTurn, TranCons::setIdUsrsTurn);
			mapper.map(TranConsDTO::getCodigoTranCons, TranCons::setCodigoTranCons);
			mapper.map(TranConsDTO::getSentidoTranCons, TranCons::setSentidoTranCons);
			mapper.map(TranConsDTO::getDateTranCons, TranCons::setFechaTranCons);
			mapper.map(TranConsDTO::getNovedadTranCons, TranCons::setNovedadTranCons);
			mapper.map(TranConsDTO::getValorCateTranCons, TranCons::setValorCateTranCons);
			mapper.map(TranConsDTO::getTotalTranCons, TranCons::setTotalTranCons);
			mapper.map(TranConsDTO::getIdPlac, TranCons::setIdPlac);
			mapper.map(TranConsDTO::getConsecutivoTranCons, TranCons::setConsecutivoTranCons);
			mapper.map(TranConsDTO::getIdFormaPago, TranCons::setIdFormPago);
			mapper.map(TranConsDTO::getTotalIva, TranCons::setTotalIva);
			mapper.map(TranConsDTO::getTotalEjes, TranCons::setTotalEjes);
			mapper.map(TranConsDTO::getTiqueteInvias, TranCons::setTiqueteInvias);
			mapper.map(TranConsDTO::getPlacaDetectada, TranCons::setPlacaDetectada);
			//mapper.map(TranConsDTO::getChequeoTranCons, TranCons::);
			//mapper.map(TranConsDTO::getChequeoTranTag, TranCons::);
			mapper.map(TranConsDTO::getValidacion, TranCons::setValidacionDocumento);
			mapper.map(TranConsDTO::getResultadoValidacion, TranCons::setResultadoValidacionDocEspc);
			mapper.map(TranConsDTO::getSignature, TranCons::setSignature);
		});

		modelMapper.typeMap(TranCons.class, TranConsDTO.class).addMappings(mapper -> {
			mapper.map(TranCons::getIdTranCons, TranConsDTO::setTranConsId);
			mapper.map(TranCons::getIdCate, TranConsDTO::setCateId);
			//mapper.map(TranCons::getIdUsrsTurn, TranConsDTO::setIdUsrsTurn);
			mapper.map(TranCons::getCodigoTranCons, TranConsDTO::setCodigoTranCons);
			mapper.map(TranCons::getSentidoTranCons, TranConsDTO::setSentidoTranCons);
			mapper.map(TranCons::getFechaTranCons, TranConsDTO::setDateTranCons);
			mapper.map(TranCons::getNovedadTranCons, TranConsDTO::setNovedadTranCons);
			mapper.map(TranCons::getValorCateTranCons, TranConsDTO::setValorCateTranCons);
			mapper.map(TranCons::getTotalTranCons, TranConsDTO::setTotalTranCons);
			mapper.map(TranCons::getIdPlac, TranConsDTO::setIdPlac);
			mapper.map(TranCons::getConsecutivoTranCons, TranConsDTO::setConsecutivoTranCons);
			mapper.map(TranCons::getIdFormPago, TranConsDTO::setIdFormaPago);
			mapper.map(TranCons::getTotalIva, TranConsDTO::setTotalIva);
			mapper.map(TranCons::getTotalEjes, TranConsDTO::setTotalEjes);
			mapper.map(TranCons::getTiqueteInvias, TranConsDTO::setTiqueteInvias);
			mapper.map(TranCons::getPlacaDetectada, TranConsDTO::setPlacaDetectada);
			//mapper.map(TranCons::getChequeoTranCons, TranConsDTO::);
			//mapper.map(TranCons::getChequeoTranTag, TranConsDTO::);
			mapper.map(TranCons::getValidacionDocumento, TranConsDTO::setValidacion);
			mapper.map(TranCons::getResultadoValidacionDocEspc, TranConsDTO::setResultadoValidacion);
			mapper.map(TranCons::getSignature, TranConsDTO::setSignature);


		});
		
	}

	private void setMappingReconcile() {	
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		modelMapper.typeMap(ReconcileDTO.class, Reconcile.class).addMappings(mapper -> {
			mapper.map(ReconcileDTO::getIdConc, Reconcile::setReconcileId);
			mapper.map(ReconcileDTO::getDateCollection, Reconcile::setDateCollection);
			mapper.map(ReconcileDTO::getDateTransaction, Reconcile::setFechaTran);
			mapper.map(ReconcileDTO::getLaneId, Reconcile::setLaneId);
			mapper.map(ReconcileDTO::getTurnCode, Reconcile::setTurnId);
			mapper.map(ReconcileDTO::getSentConc, Reconcile::setSentidoConc);
			mapper.map(ReconcileDTO::getUsercode, Reconcile::setCodUsrsConc);
			mapper.map(ReconcileDTO::getUsercodename, Reconcile::setCodUsrs);
			mapper.map(ReconcileDTO::getReconcileValue, Reconcile::setReconcileValue);
			mapper.map(ReconcileDTO::getConsoleCategory, Reconcile::setReconcileCategory);
			mapper.map(ReconcileDTO::getValueCollection, Reconcile::setCollectValue);
			mapper.map(ReconcileDTO::getDacCategory, (dest, v) -> this.setCategoryTranDac(dest, (Long) v));
			//mapper.map(ReconcileDTO::getConsoleCategory, (dest, v) -> this.setCategoryTranCons(dest, (Long) v));
			mapper.map(ReconcileDTO::getConciliationRuleName, (dest, v) -> this.setNoveConc(dest, (Long) v));
			mapper.map(ReconcileDTO::getIdTranDac, (dest, v) -> this.setIdTranDac(dest, (Long) v));
			//mapper.map(ReconcileDTO::getIdFormPago, Reconcile::setIdTranCons::);

		});

		modelMapper.typeMap(Reconcile.class, ReconcileDTO.class).addMappings(mapper -> {
			mapper.map(Reconcile::getDateCollection, ReconcileDTO::setDateCollection);
			mapper.map(Reconcile::getReconcileId, ReconcileDTO::setIdConc);
			mapper.map(Reconcile::getLaneId, ReconcileDTO::setLaneId);
			mapper.map(Reconcile::getFechaTran, ReconcileDTO::setDateTransaction);
			mapper.map(Reconcile::getTurnId, ReconcileDTO::setTurnCode);
			mapper.map(Reconcile::getSentidoConc, ReconcileDTO::setSentConc);
			mapper.map(Reconcile::getCodUsrsConc, ReconcileDTO::setUsercode);
			mapper.map(Reconcile::getCodUsrs, ReconcileDTO::setUsercodename);
			mapper.map(Reconcile::getReconcileValue, ReconcileDTO::setReconcileValue);
			mapper.map(Reconcile::getCollectValue, ReconcileDTO::setValueCollection);
			mapper.map(Reconcile::getReconcileCategory, ReconcileDTO::setConsoleCategory);
			mapper.map(src -> src.getTranDac().getIdCate(), ReconcileDTO::setDacCategory);
			//mapper.map(src -> src.getIdTranCons().getIdCate(), ReconcileDTO::setConsoleCategory);
			mapper.map(src -> src.getNoveconc().getIdNove(), ReconcileDTO::setConciliationRuleName);
			mapper.map(src -> src.getTranDac().getIdTranDac(), ReconcileDTO::setIdTranDac);
			mapper.map(src -> src.getIdTranCons().getIdFormPago().getIdFormPago(), ReconcileDTO::setIdFormPago);
			mapper.map(src -> src.getIdTranCons().getIdFormPago().getNombreFormPago(), ReconcileDTO::setIdFormPagoname);
			mapper.map(src -> src.getIdTranCons().getPlacaDetectada(), ReconcileDTO::setNumPlaca);
			
		});
		
	}
	
	
	private void setCategoryTranDac(Reconcile reconcile, Long content) {
		TranDac td = reconcile.getTranDac();
		if (td == null) {
			td = new TranDac();
		}
		td.setIdCate(content);
	}

	private void setIdTranDac(Reconcile reconcile, Long content) {
		TranDac td = reconcile.getTranDac();
		if (td == null) {
			td = new TranDac();
		}
		td.setIdTranDac(content);
	}

	private void setCategoryTranCons(Reconcile reconcile, Long content) {
		TranCons tc = reconcile.getIdTranCons();
		if (tc == null) {
			tc = new TranCons();
		}
		tc.setIdCate(content);
	}

	private void setNoveConc(Reconcile reconcile, Long content) {
		NoveConc nc = reconcile.getNoveconc();
		if (nc == null) {
			nc = new NoveConc();
		}
		nc.setIdNove(content);
	}

	public ReconcileDTO mapReconcileDTO(Reconcile conciliation) {
		ReconcileDTO obj = modelMapper.map(conciliation, ReconcileDTO.class);

		if (conciliation.getIdTranCons() != null) {
			List<NoveTran> nt = new ArrayList<NoveTran>();
			String novedades = "";
			
			nt = NoveTranDAO.findByIdTran(conciliation.getIdTranCons().getIdTranCons());
			if (nt != null) {
				for (int i=0;i<nt.size();i++) {
					novedades = novedades + nt.get(i).getIdNove().getNombreNove();
					//novedades = nt.get(i).getIdNove().getNombreNove();
					if(i< nt.size()-1) {
						novedades = novedades + " - ";
					}
				}
				
			}
			obj.setNoveltyName(novedades);

		}

		return obj;
	}
	public UsrsTurn getUsrsTurnEntity(MappingContext<Long, UsrsTurn> ctx) {
		if (ctx.getSource() != null) {
			UsrsTurn ut = new UsrsTurn();
			ut.setIdUsrsTurn(ctx.getSource());
			return ut;
		} else {
			return null;
		}
	}

	public Long getUsrsTurnDTO(MappingContext<UsrsTurn, Long> ctx) {
		return ctx.getSource() != null ? ctx.getSource().getIdUsrsTurn() : null;
	}
	

	public Reconcile mapReconcile(ReconcileDTO conciliation) {
		return modelMapper.map(conciliation, Reconcile.class);
	}
	
	public TranDac mapToTranDac(TranDACDTO tranDacDTO) {
		return modelMapper.map(tranDacDTO, TranDac.class);
	}
	
	public TranDACDTO mapToTranDacDTO(TranDac tranDac) {
		return modelMapper.map(tranDac, TranDACDTO.class);
	}
	
	public TranCons mapToTranCons(TranConsDTO tranConsDTO) {
		return modelMapper.map(tranConsDTO, TranCons.class);
	}
	
	public TranConsDTO mapToTranConsDTO(TranCons tranCons) {
		return modelMapper.map(tranCons, TranConsDTO.class);
	}
	

	
	public Timestamp getTimestamp(MappingContext<LocalDateTime, Timestamp> ctx) {
		return Timestamp.valueOf(LocalDateTime.parse(ctx.getSource().toString())) ;
	}
	public LocalDateTime getTimestampString(MappingContext<Timestamp, LocalDateTime> ctx) {
		return LocalDateTime.parse(ctx.getSource().toString());
	}
	
	public Usrs getUsrs(MappingContext<Long, Usrs> ctx) {
		return ctx.getDestination().getUsrs(ctx.getSource());
	}
	public Long getLongUsrs(MappingContext<Usrs, Long> ctx) {
		return ctx.getSource().getIdUsrs();
	}
	
	public Sent getSentEnum(MappingContext<String, Sent> ctx) {
		return Sent.fromValue(ctx.getSource().toString());
	}
	public String getSentCode(MappingContext<Sent, String> ctx) {
		return String.valueOf(ctx.getSource().toString());	
	}
	
	public Manten getMantenEnum(MappingContext<String, Manten> ctx) {
		return Manten.fromValue(ctx.getSource().toString());
	}
	public String getMantenCode(MappingContext<Manten, String> ctx) {
		return String.valueOf(ctx.getSource().toString());	
	}
	
	public Violation getViolationEnum(MappingContext<String, Violation> ctx) {
		return Violation.fromValue(ctx.getSource().toString());
	}
	public String getViolationCode(MappingContext<Violation, String> ctx) {
		return String.valueOf(ctx.getSource().toString());	
	}
	
	public Simulation getSimulationEnum(MappingContext<String, Simulation> ctx) {
		return Simulation.fromValue(ctx.getSource());
	}
	public String getSimulationCode(MappingContext<Simulation, String> ctx) {
		return String.valueOf(ctx.getSource());	
	}
	
	
	
	public Plac getPlacEntity(MappingContext<String, Plac> ctx) {
		return ctx.getDestination().placById(ctx.getSource());
	}
	public String getPlacIdString(MappingContext<Plac, String> ctx) {
		return ctx.getSource().getIdPlac();	
	}
	

}
