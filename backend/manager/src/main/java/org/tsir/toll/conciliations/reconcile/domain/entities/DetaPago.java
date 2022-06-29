package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DETA_PAGO")
public class DetaPago implements Serializable {
	@Id
	@Column(name = "ID_DETA_PAGO")
	private long idDetaPago;

	@Column(name = "VALOR_DETA_PAGO")
	private BigDecimal valorDetaPago;

	@Column(name = "NUMERO_DETA_PAGO")
	private BigDecimal numeroDetaPago;

	
	@Column(name = "ID_FORM_PAGO")
	private Long idFormPago;

	
	@Column(name = "ID_TIQU")
	private Long idTiqu;

	@Column(name = "ID_TRAN")
	private Long idTran;

	
	@Column(name = "ID_TRAN_ESPC")
	private Long idTranEspc;

	
	@Column(name = "ID_TRAN_TISC")
	private Long idTranTisc;


	@Column(name = "ID_TRAN_EPAY")
	private Long idTranEpay;

	private static final long serialVersionUID = 1L;

	public DetaPago() {
		super();
	}

	public long getIdDetaPago() {
		return this.idDetaPago;
	}

	public void setIdDetaPago(long idDetaPago) {
		this.idDetaPago = idDetaPago;
	}

	public BigDecimal getValorDetaPago() {
		return this.valorDetaPago;
	}

	public void setValorDetaPago(BigDecimal valorDetaPago) {
		this.valorDetaPago = valorDetaPago;
	}

	public BigDecimal getNumeroDetaPago() {
		return this.numeroDetaPago;
	}

	public void setNumeroDetaPago(BigDecimal numeroDetaPago) {
		this.numeroDetaPago = numeroDetaPago;
	}

	public Long getIdFormPago() {
		return this.idFormPago;
	}

	public void setIdFormPago(Long idFormPago) {
		this.idFormPago = idFormPago;
	}

	public Long getIdTiqu() {
		return this.idTiqu;
	}

	public void setIdTiqu(Long idTiqu) {
		this.idTiqu = idTiqu;
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

	public Long getIdTranTisc() {
		return this.idTranTisc;
	}

	public void setIdTranTisc(Long idTranTisc) {
		this.idTranTisc = idTranTisc;
	}

	public Long getIdTranEpay() {
		return idTranEpay;
	}

	public void setIdTranEpay(Long idTranEpay) {
		this.idTranEpay = idTranEpay;
	}
	
	

}
