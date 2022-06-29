package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "NOVE_CONC")
public class NoveConc implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name= "ID_NOVE_CONC_GENERATOR", strategy = "org.tsir.common.domain.TimeBasedGenerator")
	@GeneratedValue(generator = "ID_NOVE_CONC_GENERATOR")
	@Column(name = "ID_NOVE_CONC")
	private Long idNoveConc;
	
	@OneToOne()
	@JoinColumn(name = "ID_CONC")
	private Reconcile reconcileId;

	@Column(name = "ID_NOVE")
	private Long idNove;

	@Column(name = "FECHA")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "ID_CONC_CRUZ")
	private Long idConcCruz;

	/**
	 * Id de NoveConc
	 * 
	 * @return idNoveConc
	 **/

	public NoveConc getIdNoveConc(Long idNoveConc) {
		this.idNoveConc = idNoveConc;
		return this;
	}

	

	/**
	 * @return the reconcileId
	 */
	public Reconcile getReconcileId() {
		return reconcileId;
	}



	/**
	 * @param reconcileId the reconcileId to set
	 */
	public void setReconcileId(Reconcile reconcileId) {
		this.reconcileId = reconcileId;
	}



	/**
	 * @return the idNove
	 */
	public Long getIdNove() {
		return idNove;
	}

	/**
	 * @param idNove the idNove to set
	 */
	public void setIdNove(Long idNove) {
		this.idNove = idNove;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the idNoveConc
	 */
	public Long getIdNoveConc() {
		return idNoveConc;
	}

	/**
	 * @param idNoveConc the idNoveConc to set
	 */
	public void setIdNoveConc(Long idNoveConc) {
		this.idNoveConc = idNoveConc;
	}

	/**
	 * @return the idConcCruz
	 */
	public Long getIdConcCruz() {
		return idConcCruz;
	}

	/**
	 * @param idConcCruz the idConcCruz to set
	 */
	public void setIdConcCruz(Long idConcCruz) {
		this.idConcCruz = idConcCruz;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
