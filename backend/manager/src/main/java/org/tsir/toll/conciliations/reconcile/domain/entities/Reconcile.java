package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONC")
public class Reconcile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CONC")
	private Long reconcileId = null;

	@OneToOne()
	@JoinColumn(name = "ID_TRAN_DAC")
	private TranDac idTranDac;

	@OneToOne()
	@JoinColumn(name = "ID_TRAN_CONS")
	private TranCons idTranCons;

	@Column(name = "DISCREPANCIA_CONC")
	private String reconcileStatus;

	@Column(name = "FECHA_CONC")
	private Timestamp reconcileDateTime;

	@Column(name = "ID_CATE")
	private Long reconcileCategory;

	@Column(name = "VALOR_REAL_CONC")
	private Long reconcileValue;

	@Column(name = "DIFERENCIA_CONC")
	private Double adjustValue;

	@Column(name = "ID_USRS_RESPONSABLE")
	private String idUsrsResponsable;

	@Column(name = "VALOR_RECAUDADO_CONC")
	private Double collectValue;

	@Column(name = "FECHA_REC")
	private Date dateCollection;

	@Column(name = "ID_PLAC")
	private String idPlac;

	@Column(name = "ID_CARR")
	private Long laneId;

	@Column(name = "CODE_TURN")
	private Long turnId;

	@Column(name = "SENTIDO_CONC")
	private String sentidoConc;

	@Column(name = "COD_USRS")
	private String codUsrs;

	@Column(name = "ID_USRS_CONCILIADOR")
	private Long codUsrsConc;

	@Column(name = "FECHA_TRAN")
	private Timestamp fechaTran;

	@OneToOne(mappedBy = "reconcileId", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private NoveConc noveconc;

	/*
	 * @Column(name = "") private Long PaymentMethodId = null;
	 */

	public Reconcile reconcileId(Long reconcileId) {
		this.reconcileId = reconcileId;
		return this;
	}

	/**
	 * Id de la conciliación
	 * 
	 * @return reconcileId
	 **/

	public Long getReconcileId() {
		return reconcileId;
	}

	public void setReconcileId(Long reconcileId) {
		this.reconcileId = reconcileId;
	}

	public Reconcile reconcileStatus(String reconcileStatus) {
		this.reconcileStatus = reconcileStatus;
		return this;
	}

	/**
	 * Estado de la conciliación
	 * 
	 * @return reconcileStatus
	 **/

	public String getReconcileStatus() {
		return reconcileStatus;
	}

	public void setReconcileStatus(String reconcileStatus) {
		this.reconcileStatus = reconcileStatus;
	}

	public Reconcile reconcileDateTime(Timestamp reconcileDateTime) {
		this.reconcileDateTime = reconcileDateTime;
		return this;
	}

	/**
	 * Fecha y hora de conciliación
	 * 
	 * @return reconcileDateTime
	 **/

	public Timestamp getReconcileDateTime() {
		return reconcileDateTime;
	}

	public void setReconcileDateTime(Timestamp reconcileDateTime) {
		this.reconcileDateTime = reconcileDateTime;
	}

	public Reconcile reconcileCategory(Long reconcileCategory) {
		this.reconcileCategory = reconcileCategory;
		return this;
	}

	/**
	 * Categoria de la conciliación
	 * 
	 * @return reconcileCategory
	 **/

	public Long getReconcileCategory() {
		return reconcileCategory;
	}

	public void setReconcileCategory(Long reconcileCategory) {
		this.reconcileCategory = reconcileCategory;
	}

	public Reconcile reconcileValue(Long reconcileValue) {
		this.reconcileValue = reconcileValue;
		return this;
	}

	/**
	 * Valor de la conciliación
	 * 
	 * @return reconcileValue
	 **/

	public Long getReconcileValue() {
		return reconcileValue;
	}

	public void setReconcileValue(Long reconcileValue) {
		this.reconcileValue = reconcileValue;
	}

	public Reconcile adjustValue(Double adjustValue) {
		this.adjustValue = adjustValue;
		return this;
	}

	/**
	 * Valor ajustado después de la conciliación
	 * 
	 * @return adjustValue
	 **/

	public Double getAdjustValue() {
		return adjustValue;
	}

	public void setAdjustValue(Double adjustValue) {
		this.adjustValue = adjustValue;
	}

	/**
	 * @return the idUsrsResponsable
	 */
	public String getIdUsrsResponsable() {
		return idUsrsResponsable;
	}

	/**
	 * @param idUsrsResponsable the idUsrsResponsable to set
	 */
	public void setIdUsrsResponsable(String idUsrsResponsable) {
		this.idUsrsResponsable = idUsrsResponsable;
	}

	public Reconcile collectValue(Double collectValue) {
		this.collectValue = collectValue;
		return this;
	}

	/**
	 * Valor recaudado
	 * 
	 * @return collectValue
	 **/

	public Double getCollectValue() {
		return collectValue;
	}

	public void setCollectValue(Double collectValue) {
		this.collectValue = collectValue;
	}

	public Reconcile dateCollection(Date dateCollection) {
		this.dateCollection = dateCollection;
		return this;
	}

	/**
	 * Fecha del recaudo
	 * 
	 * @return dateCollection
	 **/

	public Date getDateCollection() {
		return dateCollection;
	}

	public void setDateCollection(Date dateCollection) {
		this.dateCollection = dateCollection;
	}

	/**
	 * @return the idPlac
	 */
	public String getIdPlac() {
		return idPlac;
	}

	/**
	 * @param idPlac the idPlac to set
	 */
	public void setIdPlac(String idPlac) {
		this.idPlac = idPlac;
	}

	public Reconcile laneId(Long laneId) {
		this.laneId = laneId;
		return this;
	}

	public Long getLaneId() {
		return laneId;
	}

	public void setLaneId(Long laneId) {
		this.laneId = laneId;
	}

	public Reconcile turnId(Long turnId) {
		this.turnId = turnId;
		return this;
	}

	public Long getTurnId() {
		return turnId;
	}

	public void setTurnId(Long turnId) {
		this.turnId = turnId;
	}

	/**
	 * @return the tranDac
	 */
	public TranDac getTranDac() {
		return idTranDac;
	}

	/**
	 * @param tranDac the tranDac to set
	 */
	public void setTranDac(TranDac tranDac) {
		this.idTranDac = tranDac;
	}

	/**
	 * @return the idTranCons
	 */
	public TranCons getIdTranCons() {
		return idTranCons;
	}

	/**
	 * @param idTranCons the idTranCons to set
	 */
	public void setIdTranCons(TranCons idTranCons) {
		this.idTranCons = idTranCons;
	}

	/**
	 * @return the noveconc
	 */
	public NoveConc getNoveconc() {
		return noveconc;
	}

	/**
	 * @param noveconc the noveconc to set
	 */
	public void setNoveconc(NoveConc noveconc) {
		this.noveconc = noveconc;
	}

	/**
	 * @return the sentidoConc
	 */
	public String getSentidoConc() {
		return sentidoConc;
	}

	/**
	 * @param sentidoConc the sentidoConc to set
	 */
	public void setSentidoConc(String sentidoConc) {
		this.sentidoConc = sentidoConc;
	}

	/**
	 * @return the codUsrs
	 */
	public String getCodUsrs() {
		return codUsrs;
	}

	/**
	 * @param codUsrs the codUsrs to set
	 */
	public void setCodUsrs(String codUsrs) {
		this.codUsrs = codUsrs;
	}

	/**
	 * @return the codUsrsConc
	 */
	public Long getCodUsrsConc() {
		return codUsrsConc;
	}

	/**
	 * @param codUsrsConc the codUsrsConc to set
	 */
	public void setCodUsrsConc(Long codUsrsConc) {
		this.codUsrsConc = codUsrsConc;
	}

	/**
	 * @return the fechaTran
	 */
	public Timestamp getFechaTran() {
		return fechaTran;
	}

	/**
	 * @param fechaTran the fechaTran to set
	 */
	public void setFechaTran(Timestamp fechaTran) {
		this.fechaTran = fechaTran;
	}

}
