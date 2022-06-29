package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "plac")
public class Plac {

	@Id
	//@GenericGenerator(name = "id_plac", strategy = "org.tsir.common.domain.TimeBasedGenerator")
	//@GeneratedValue(generator = "id_plac")
	@Column(name = "id_plac")
	private String idPlac;

	@Column(name = "fecha_actualizacion_plac")
	private Timestamp fechaActualizacionPlac;

	@Column(name = "id_cate")
	private Long idCate;

	@Column(name = "chequeo_cate_plac")
	private Long chequeoCatePlac;

	@Column(name = "color")
	private String color;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private Long modelo;
	
	@Column(name = "reg_cat_plac")
	private Integer regCatPlac;
	
	
	

	public String getIdPlac() {
		return idPlac;
	}

	public void setIdPlac(String idPlac) {
		this.idPlac = idPlac;
	}

	public Timestamp getFechaActualizacionPlac() {
		return fechaActualizacionPlac;
	}

	public void setFechaActualizacionPlac(Timestamp fechaActualizacionPlac) {
		this.fechaActualizacionPlac = fechaActualizacionPlac;
	}

	public Long getIdCate() {
		return idCate;
	}

	public void setIdCate(Long idCate) {
		this.idCate = idCate;
	}

	public Long getChequeoCatePlac() {
		return chequeoCatePlac;
	}

	public void setChequeoCatePlac(Long chequeoCatePlac) {
		this.chequeoCatePlac = chequeoCatePlac;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getModelo() {
		return modelo;
	}

	public void setModelo(Long modelo) {
		this.modelo = modelo;
	}

	public Integer getRegCatPlac() {
		return regCatPlac;
	}

	public void setRegCatPlac(Integer regCatPlac) {
		this.regCatPlac = regCatPlac;
	}
	
	
	public Plac placById(String idPlac) {
		if(this.idPlac.equals(idPlac))
			return this;
		return null;
	}
	

}