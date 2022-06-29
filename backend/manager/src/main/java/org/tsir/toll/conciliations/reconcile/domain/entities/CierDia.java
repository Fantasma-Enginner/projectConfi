package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CIER_DIA")
public class CierDia implements Serializable {
	@Id
	@Column(name = "ID_CIER_DIA")
	private Long idCierDia;

	@Column(name = "FECHA_CIERRE")
	private LocalDate fechaCierre;

	@Column(name = "ID_USRS")
	private Long idUsrs;

	@Column(name = "ID_ESTA")
	private Long idEsta;

	@Column(name = "NUM_REVERSADO")
	private Long numReversado;

	@Column(name = "ESTADO")
	private Integer estado;

	@Column(name = "VLR_RECAUDO")
	private Long vlrRecaudo;

	@Column(name = "VLR_RECARGAS")
	private Long vlrRecargas;

	@Column(name = "VLR_OTROS")
	private Long vlrOtros;

	@Column(name = "VLR_TOTAL")
	private Long vlrTotal;

	@Column(name = "VLR_PICO")
	private Long vlrPico;

	@Column(name = "FECHA_CERRADO")
	private LocalDateTime fechaCerrado;

	@Column(name = "STATE_CLOSING_ID")
	private Long stateClosingId;

	private static final long serialVersionUID = 1L;

	public CierDia() {
		super();
	}

	public Long getIdCierDia() {
		return idCierDia;
	}

	public void setIdCierDia(Long idCierDia) {
		this.idCierDia = idCierDia;
	}


	public LocalDate getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Long getIdUsrs() {
		return idUsrs;
	}

	public void setIdUsrs(Long idUsrs) {
		this.idUsrs = idUsrs;
	}

	public Long getIdEsta() {
		return idEsta;
	}

	public void setIdEsta(Long idEsta) {
		this.idEsta = idEsta;
	}

	public Long getNumReversado() {
		return numReversado;
	}

	public void setNumReversado(Long numReversado) {
		this.numReversado = numReversado;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Long getVlrRecaudo() {
		return vlrRecaudo;
	}

	public void setVlrRecaudo(Long vlrRecaudo) {
		this.vlrRecaudo = vlrRecaudo;
	}

	public Long getVlrRecargas() {
		return vlrRecargas;
	}

	public void setVlrRecargas(Long vlrRecargas) {
		this.vlrRecargas = vlrRecargas;
	}

	public Long getVlrOtros() {
		return vlrOtros;
	}

	public void setVlrOtros(Long vlrOtros) {
		this.vlrOtros = vlrOtros;
	}

	public Long getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(Long vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public Long getVlrPico() {
		return vlrPico;
	}

	public void setVlrPico(Long vlrPico) {
		this.vlrPico = vlrPico;
	}

	public LocalDateTime getFechaCerrado() {
		return fechaCerrado;
	}

	public void setFechaCerrado(LocalDateTime fechaCerrado) {
		this.fechaCerrado = fechaCerrado;
	}

	public Long getStateClosingId() {
		return stateClosingId;
	}

	public void setStateClosingId(Long stateClosingId) {
		this.stateClosingId = stateClosingId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
