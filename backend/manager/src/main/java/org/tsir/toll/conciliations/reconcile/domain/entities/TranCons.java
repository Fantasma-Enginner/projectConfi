package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.querydsl.core.annotations.QueryInit;

@Entity
@Table(name = "TRAN_CONS")
public class TranCons implements Serializable {

	@Id
	@Column(name = "ID_TRAN_CONS")
	private Long idTranCons;
	
	@Column(name = "ID_CATE")
	private Long idCate;
	
	@OneToOne()
	@JoinColumn(name = "ID_USRS_TURN")
	private UsrsTurn idUsrsTurn;

	@Column(name = "CODIGO_TRAN_CONS")
	private Long codigoTranCons;

	@Column(name = "SENTIDO_TRAN_CONS")
	private String sentidoTranCons;

	@Column(name = "FECHA_TRAN_CONS")
	private LocalDateTime fechaTranCons;

	@Column(name = "NOVEDAD_TRAN_CONS")
	private String novedadTranCons;

	@Column(name = "VALOR_CATE_TRAN_CONS")
	private Long valorCateTranCons;

	@Column(name = "TOTAL_TRAN_CONS")
	private Long totalTranCons;

	@Column(name = "CONSECUTIVO_TRAN_CONS")
	private Long consecutivoTranCons;

	@Column(name = "TOTAL_IVA")
	private Long totalIva;

	@Column(name = "TOTAL_EJES")
	private Long totalEjes;

	@Column(name = "TIQUETE_INVIAS")
	private String tiqueteInvias;

	@Column(name = "PLACA_DETECTADA")
	private String placaDetectada;

	@OneToOne()
	@JoinColumn(name = "ID_FORM_PAGO")
	private FormPago idFormPago;

	@ManyToOne
	@JoinColumn(name = "ID_PLAC")
	private Plac idPlac;

	@Column(name = "VALIDACION_DOCUMENTO")
	private Integer validacionDocumento;

	@Column(name = "RESULTADO_VALIDACION_DOC_ESPC")
	private Integer resultadoValidacionDocEspc;

	@Column(name = "SIGNATURE")
	private String signature;

	@OneToMany(mappedBy = "idTran")
	private Set<NoveTran> noveTranCollection;
	
//	@OneToMany(mappedBy = "idDetaPago")
//	private Set<DetaPago> detaPagoCollection;

	private static final long serialVersionUID = 1L;

	public TranCons() {
		super();
	}

	public long getIdTranCons() {
		return this.idTranCons;
	}
	
	
	public void setIdTranCons(long idTranCons) {
		this.idTranCons = idTranCons;
	}
	
	public Long getIdCate() {
		return this.idCate;
	}
	
	public void setIdCate(Long idCate) {
		this.idCate = idCate;
	}
	
	
	public UsrsTurn getIdUsrsTurn() {
		return idUsrsTurn;
	}

	public void setIdUsrsTurn(UsrsTurn idUsrsTurn) {
		this.idUsrsTurn = idUsrsTurn;
	}

	public Long getCodigoTranCons() {
		return this.codigoTranCons;
	}

	public void setCodigoTranCons(Long codigoTranCons) {
		this.codigoTranCons = codigoTranCons;
	}

	public String getSentidoTranCons() {
		return this.sentidoTranCons;
	}

	public void setSentidoTranCons(String sentidoTranCons) {
		this.sentidoTranCons = sentidoTranCons;
	}

	public LocalDateTime getFechaTranCons() {
		return this.fechaTranCons;
	}

	public void setFechaTranCons(LocalDateTime fechaTranCons) {
		this.fechaTranCons = fechaTranCons;
	}

	public String getNovedadTranCons() {
		return this.novedadTranCons;
	}

	public void setNovedadTranCons(String novedadTranCons) {
		this.novedadTranCons = novedadTranCons;
	}

	public Long getValorCateTranCons() {
		return this.valorCateTranCons;
	}

	public void setValorCateTranCons(Long valorCateTranCons) {
		this.valorCateTranCons = valorCateTranCons;
	}

	public Long getTotalTranCons() {
		return this.totalTranCons;
	}

	public void setTotalTranCons(Long totalTranCons) {
		this.totalTranCons = totalTranCons;
	}

	public Long getConsecutivoTranCons() {
		return this.consecutivoTranCons;
	}

	public void setConsecutivoTranCons(Long consecutivoTranCons) {
		this.consecutivoTranCons = consecutivoTranCons;
	}

	public Long getTotalIva() {
		return this.totalIva;
	}

	public void setTotalIva(Long totalIva) {
		this.totalIva = totalIva;
	}

	public Long getTotalEjes() {
		return this.totalEjes;
	}

	public void setTotalEjes(Long totalEjes) {
		this.totalEjes = totalEjes;
	}

	public String getTiqueteInvias() {
		return this.tiqueteInvias;
	}

	public void setTiqueteInvias(String tiqueteInvias) {
		this.tiqueteInvias = tiqueteInvias;
	}

	public String getPlacaDetectada() {
		return placaDetectada;
	}

	public void setPlacaDetectada(String placaDetectada) {
		this.placaDetectada = placaDetectada;
	}



	public FormPago getIdFormPago() {
		return idFormPago;
	}

	public void setIdFormPago(FormPago idFormPago) {
		this.idFormPago = idFormPago;
	}

	public Plac getIdPlac() {
		return this.idPlac;
	}

	public void setIdPlac(Plac idPlac) {
		this.idPlac = idPlac;
	}

	public Integer getValidacionDocumento() {
		return validacionDocumento;
	}

	public void setValidacionDocumento(Integer validacionDocumento) {
		this.validacionDocumento = validacionDocumento;
	}

	public Integer getResultadoValidacionDocEspc() {
		return resultadoValidacionDocEspc;
	}

	public void setResultadoValidacionDocEspc(Integer resultadoValidacionDocEspc) {
		this.resultadoValidacionDocEspc = resultadoValidacionDocEspc;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Set<NoveTran> getNoveTranCollection() {
		return this.noveTranCollection;
	}

	public void setNoveTranCollection(Set<NoveTran> noveTranCollection) {
		this.noveTranCollection = noveTranCollection;
	}

//	/**
//	 * @return the detaPagoCollection
//	 */
//	public Set<DetaPago> getDetaPagoCollection() {
//		return detaPagoCollection;
//	}
//
//	/**
//	 * @param detaPagoCollection the detaPagoCollection to set
//	 */
//	public void setDetaPagoCollection(Set<DetaPago> detaPagoCollection) {
//		this.detaPagoCollection = detaPagoCollection;
//	}
	
	
	

}
