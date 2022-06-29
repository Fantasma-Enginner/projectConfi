package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Usrs implements Serializable {
	@Id
	@Column(name = "ID_USRS")
	private long idUsrs;

	@Column(name = "CODIGO_USRS")
	private Long codigoUsrs;

	@Column(name = "NOMBRE_USRS")
	private String nombreUsrs;

	@Column(name = "APELLIDO_USRS")
	private String apellidoUsrs;

	@Column(name = "ESTADO_USRS")
	private String estadoUsrs;

	@Column(name = "CLAVE_USRS")
	private String claveUsrs;

	@Column(name = "PWD_FECHA")
	private Timestamp pwdFecha;

	@Column(name = "ID_ESTA")
	private Long idEsta;

	@Column(name = "ID_GRUP_USRS")
	private Long idGrupUsrs;


	@Column(name = "ID_TISC")
	private String idTisc;

	private static final long serialVersionUID = 1L;
	
	
//	@OneToOne(mappedBy = "idUsrs", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	private TranDac tranDac;

	public Usrs() {
		super();
	}

	public Usrs(long idUsrs) {
		super();
		this.idUsrs = idUsrs;
	}
	
	public Usrs getUsrs(Long id) {
		if(this.idUsrs == id)
		return this;
		return null;
	}

	public long getIdUsrs() {
		return this.idUsrs;
	}

	public void setIdUsrs(long idUsrs) {
		this.idUsrs = idUsrs;
	}

	public Long getCodigoUsrs() {
		return this.codigoUsrs;
	}

	public void setCodigoUsrs(Long codigoUsrs) {
		this.codigoUsrs = codigoUsrs;
	}

	public String getNombreUsrs() {
		return this.nombreUsrs;
	}

	public void setNombreUsrs(String nombreUsrs) {
		this.nombreUsrs = nombreUsrs;
	}

	public String getApellidoUsrs() {
		return this.apellidoUsrs;
	}

	public void setApellidoUsrs(String apellidoUsrs) {
		this.apellidoUsrs = apellidoUsrs;
	}

	public String getEstadoUsrs() {
		return this.estadoUsrs;
	}

	public void setEstadoUsrs(String estadoUsrs) {
		this.estadoUsrs = estadoUsrs;
	}

	public String getClaveUsrs() {
		return this.claveUsrs;
	}

	public void setClaveUsrs(String claveUsrs) {
		this.claveUsrs = claveUsrs;
	}

	public Timestamp getPwdFecha() {
		return this.pwdFecha;
	}

	public void setPwdFecha(Timestamp pwdFecha) {
		this.pwdFecha = pwdFecha;
	}

	public Long getIdEsta() {
		return this.idEsta;
	}

	public void setIdEsta(Long idEsta) {
		this.idEsta = idEsta;
	}
	
	

	

}
