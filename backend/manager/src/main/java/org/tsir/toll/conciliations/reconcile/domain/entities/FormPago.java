package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FORM_PAGO")
public class FormPago implements Serializable {
	


	@Id
	@Column(name = "ID_FORM_PAGO")
	private Long idFormPago;
	
	@Column(name = "NOMBRE_FORM_PAGO")
	private String nombreFormPago;

	
	public FormPago() {
		super();
	}

	public Long getIdFormPago() {
		return idFormPago;
	}

	public void setIdFormPago(Long idFormPago) {
		this.idFormPago = idFormPago;
	}

	public String getNombreFormPago() {
		return nombreFormPago;
	}

	public void setNombreFormPago(String nombreFormPago) {
		this.nombreFormPago = nombreFormPago;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
