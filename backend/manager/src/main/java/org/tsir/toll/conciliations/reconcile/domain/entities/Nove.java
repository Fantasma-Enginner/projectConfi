package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "NOVE")
public class Nove implements Serializable {
	@Id
	@Column(name = "ID_NOVE")
	private Long idNove;

	@Column(name = "VALOR_NOVE")
	private Long valorNove;

	@Column(name = "IMAGEN_NOVE")
	@Lob
	private byte[] imagenNove;

	@Column(name = "NOMBRE_NOVE")
	private String nombreNove;

	@Column(name = "CODIGO_NOVE")
	private Long codigoNove;

	@Column(name = "REFERENCIA")
	private String referencia;

	@Column(name = "NOMBRE_IMPRESION")
	private String nombreImpresion;

	@Column(name = "ID_TIPO_NOVE")
	private Long idTipoNove;

	private static final long serialVersionUID = 1L;

	public Nove() {
		super();
	}

	public Nove(long idNove) {
		super();
		this.idNove = idNove;
	}

	public long getIdNove() {
		return this.idNove;
	}

	public void setIdNove(long idNove) {
		this.idNove = idNove;
	}

	public Long getValorNove() {
		return this.valorNove;
	}

	public void setValorNove(Long valorNove) {
		this.valorNove = valorNove;
	}

	public String getNombreNove() {
		return this.nombreNove;
	}

	public void setNombreNove(String nombreNove) {
		this.nombreNove = nombreNove;
	}

	public Long getCodigoNove() {
		return this.codigoNove;
	}

	public void setCodigoNove(Long codigoNove) {
		this.codigoNove = codigoNove;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Long getIdTipoNove() {
		return this.idTipoNove;
	}

	public void setIdTipoNove(Long idTipoNove) {
		this.idTipoNove = idTipoNove;
	}

	public String getNombreImpresion() {
		return nombreImpresion;
	}

	public void setNombreImpresion(String nombreImpresion) {
		this.nombreImpresion = nombreImpresion;
	}

}

