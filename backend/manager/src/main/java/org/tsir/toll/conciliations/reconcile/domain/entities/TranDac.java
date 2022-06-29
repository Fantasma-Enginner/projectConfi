package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRAN_DAC")
public class TranDac implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_TRAN_DAC")
	private Long idTranDac;

	@Column(name = "ID_CATE")
	private Long idCate;

	@Column(name = "EJES_TRAN_DAC")
	private Long ejesTranDac;

	@Column(name = "EJES_DOBLES_TRAN_DAC")
	private Long ejesDoblesTranDac;

	@Column(name = "SENTIDO_TRAN_DAC")
	private String sentidoTranDac;

	@Column(name = "FECHA_TRAN_DAC")
	private LocalDateTime fechaTranDac;

	@Column(name = "FECHA_RECAUDO_TRAN_DAC")
	private LocalDateTime fechaRecTranDac;

	@Column(name = "ID_CARR")
	private Long idCarr;

	@Column(name = "CODIGO_TURN")
	private String codigoTurn;
	
	@OneToOne()
	@JoinColumn(name = "ID_USRS")
	private Usrs idUsrs;

	@Column(name = "MANTENIMIENTO")
	private String mantenimiento;

	@Column(name = "VIOLACION")
	private String violacion;

	@Column(name = "SIMULACION")
	private String simulacion;

	@Column(name = "FECHA_REC")
	private LocalDate fechaRec;

	@Column(name = "CONSECUTIVE")
	private Long consecutive;

	@Column(name = "RECEIPT_DATA")
	private String receiptData;
	
	
	@OneToOne(mappedBy = "idTranDac", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Reconcile reconcilie;

	/**
	 * Id de tranDac
	 * 
	 * @return idTranDac
	 **/

	public TranDac getIdTranCons(Long idTranDac) {
		this.idTranDac = idTranDac;
		return this;
	}

	/**
	 * @return the idTranDac
	 */
	public Long getIdTranDac() {
		return idTranDac;
	}

	/**
	 * @param idTranDac the idTranDac to set
	 */
	public void setIdTranDac(Long idTranDac) {
		this.idTranDac = idTranDac;
	}

	/**
	 * @return the idCate
	 */
	public Long getIdCate() {
		return idCate;
	}

	/**
	 * @param idCate the idCate to set
	 */
	public void setIdCate(Long idCate) {
		this.idCate = idCate;
	}

	/**
	 * @return the ejesTranDac
	 */
	public Long getEjesTranDac() {
		return ejesTranDac;
	}

	/**
	 * @param ejesTranDac the ejesTranDac to set
	 */
	public void setEjesTranDac(Long ejesTranDac) {
		this.ejesTranDac = ejesTranDac;
	}

	/**
	 * @return the ejesDoblesTranDac
	 */
	public Long getEjesDoblesTranDac() {
		return ejesDoblesTranDac;
	}

	/**
	 * @param ejesDoblesTranDac the ejesDoblesTranDac to set
	 */
	public void setEjesDoblesTranDac(Long ejesDoblesTranDac) {
		this.ejesDoblesTranDac = ejesDoblesTranDac;
	}

	/**
	 * @return the sentidoTranDac
	 */
	public String getSentidoTranDac() {
		return sentidoTranDac;
	}

	/**
	 * @param sentidoTranDac the sentidoTranDac to set
	 */
	public void setSentidoTranDac(String sentidoTranDac) {
		this.sentidoTranDac = sentidoTranDac;
	}

	/**
	 * @return the fechaTranDac
	 */
	public LocalDateTime getFechaTranDac() {
		return fechaTranDac;
	}

	/**
	 * @param fechaTranDac the fechaTranDac to set
	 */
	public void setFechaTranDac(LocalDateTime fechaTranDac) {
		this.fechaTranDac = fechaTranDac;
	}

	/**
	 * @return the fechaRecTranDac
	 */
	public LocalDateTime getFechaRecTranDac() {
		return fechaRecTranDac;
	}

	/**
	 * @param fechaRecTranDac the fechaRecTranDac to set
	 */
	public void setFechaRecTranDac(LocalDateTime fechaRecTranDac) {
		this.fechaRecTranDac = fechaRecTranDac;
	}

	/**
	 * @return the idCarr
	 */
	public Long getIdCarr() {
		return idCarr;
	}

	/**
	 * @param idCarr the idCarr to set
	 */
	public void setIdCarr(Long idCarr) {
		this.idCarr = idCarr;
	}

	/**
	 * @return the codigoTurn
	 */
	public String getCodigoTurn() {
		return codigoTurn;
	}

	/**
	 * @param codigoTurn the codigoTurn to set
	 */
	public void setCodigoTurn(String codigoTurn) {
		this.codigoTurn = codigoTurn;
	}

	/**
	 * @return the idUsrs
	 */
	public Usrs getIdUsrs() {
		return idUsrs;
	}

	/**
	 * @param idUsrs the idUsrs to set
	 */
	public void setIdUsrs(Usrs idUsrs) {
		this.idUsrs = idUsrs;
	}

	/**
	 * @return the mantenimiento
	 */
	public String getMantenimiento() {
		return mantenimiento;
	}

	/**
	 * @param mantenimiento the mantenimiento to set
	 */
	public void setMantenimiento(String mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	/**
	 * @return the violacion
	 */
	public String getViolacion() {
		return violacion;
	}

	/**
	 * @param violacion the violacion to set
	 */
	public void setViolacion(String violacion) {
		this.violacion = violacion;
	}

	/**
	 * @return the simulacion
	 */
	public String getSimulacion() {
		return simulacion;
	}

	/**
	 * @param simulacion the simulacion to set
	 */
	public void setSimulacion(String simulacion) {
		this.simulacion = simulacion;
	}

	/**
	 * @return the fechaRec
	 */
	public LocalDate getFechaRec() {
		return fechaRec;
	}

	/**
	 * @param fechaRec the fechaRec to set
	 */
	public void setFechaRec(LocalDate fechaRec) {
		this.fechaRec = fechaRec;
	}

	/**
	 * @return the consecutive
	 */
	public Long getConsecutive() {
		return consecutive;
	}

	/**
	 * @param consecutive the consecutive to set
	 */
	public void setConsecutive(Long consecutive) {
		this.consecutive = consecutive;
	}

	/**
	 * @return the receiptData
	 */
	public String getReceiptData() {
		return receiptData;
	}

	/**
	 * @param receiptData the receiptData to set
	 */
	public void setReceiptData(String receiptData) {
		this.receiptData = receiptData;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	/**
	 * @return the reconcilie
	 */
	public Reconcile getReconcilie() {
		return reconcilie;
	}

	/**
	 * @param reconcilie the reconcilie to set
	 */
	public void setReconcilie(Reconcile reconcilie) {
		this.reconcilie = reconcilie;
	}
	
	

}
