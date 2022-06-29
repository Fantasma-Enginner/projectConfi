package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.querydsl.core.annotations.QueryInit;

@Entity
@Table(name = "NOVE_TRAN")
public class NoveTran implements Serializable {
	

	@Id
	@GenericGenerator(name= "ID_NOVE_TRAN_GENERATOR", strategy = "org.tsir.common.domain.TimeBasedGenerator")
	@GeneratedValue(generator = "ID_NOVE_TRAN_GENERATOR")
	@Column(name = "ID_NOVE_TRAN")
	private Long idNoveTran;

	@Column(name = "NUMERO_EJES_NOVE_TRAN")
	private Long numeroEjesNoveTran;

	@Column(name = "VALOR_NOVE")
	private Long valorNove;

	@Column(name = "ID_FORM_PAGO")
	private Long idFormPago;

	@ManyToOne
	@JoinColumn(name = "ID_NOVE")
	private Nove idNove;

	
	@Column(name = "ID_TRAN")
	private Long idTran;

	@Column(name = "ID_TRAN_ESPC")
	private Long idTranEspc;

	@Column(name = "NO_RPH")
	private String noRph;

	private static final long serialVersionUID = 1L;

	public NoveTran() {
		super();
	}

	
	

	public Long getIdNoveTran() {
		return idNoveTran;
	}




	public void setIdNoveTran(Long idNoveTran) {
		this.idNoveTran = idNoveTran;
	}




	public Long getNumeroEjesNoveTran() {
		return this.numeroEjesNoveTran;
	}

	public void setNumeroEjesNoveTran(Long numeroEjesNoveTran) {
		this.numeroEjesNoveTran = numeroEjesNoveTran;
	}

	public Long getValorNove() {
		return this.valorNove;
	}

	public void setValorNove(Long valorNove) {
		this.valorNove = valorNove;
	}

	public Long getIdFormPago() {
		return this.idFormPago;
	}

	public void setIdFormPago(Long idFormPago) {
		this.idFormPago = idFormPago;
	}

	public Nove getIdNove() {
		return this.idNove;
	}

	public void setIdNove(Nove idNove) {
		this.idNove = idNove;
	}

	public Long getIdTran() {
		return this.idTran;
	}

	public void setIdTran(Long idTran) {
		this.idTran = idTran;
	}

	public Long getIdTranEspc() {
		return this.idTranEspc;
	}

	public void setIdTranEspc(Long idTranEspc) {
		this.idTranEspc = idTranEspc;
	}

	public String getNoRph() {
		return noRph;
	}

	public void setNoRph(String noRph) {
		this.noRph = noRph;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	

}
