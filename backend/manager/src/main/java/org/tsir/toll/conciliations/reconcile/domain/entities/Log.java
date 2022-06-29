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
@Table(name = "LOG")
public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GenericGenerator(name= "ID_LOG_GENERATOR", strategy = "org.tsir.common.domain.TimeBasedGenerator")
	@GeneratedValue(generator = "ID_LOG_GENERATOR")
	@Column(name = "ID_LOG")
	private Long idLog;
	

	@Column(name = "USRS")
	private Long usrs;

	@Column(name = "LOG_MENSAJE")
	private String logMensaje;

	@Column(name = "LOG_NIVEL")
	private String logNivel;

	@Column(name = "LOG_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date logDate;

	@Column(name = "LOG_TIPO")
	private String logTipo;

	@Column(name = "LOCATION_LOG")
	private String locationLog;

	@Column(name = "IP")
	private String ip;

	@Column(name = "ID_ESTA")
	private Long idEsta;

	public Long getIdLog() {
		return idLog;
	}

	public void setIdLog(Long idLog) {
		this.idLog = idLog;
	}

	public Long getUsrs() {
		return usrs;
	}

	public void setUsrs(Long usrs) {
		this.usrs = usrs;
	}

	public String getLogMensaje() {
		return logMensaje;
	}

	public void setLogMensaje(String logMensaje) {
		this.logMensaje = logMensaje;
	}

	public String getLogNivel() {
		return logNivel;
	}

	public void setLogNivel(String logNivel) {
		this.logNivel = logNivel;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getLogTipo() {
		return logTipo;
	}

	public void setLogTipo(String logTipo) {
		this.logTipo = logTipo;
	}

	public String getLocationLog() {
		return locationLog;
	}

	public void setLocationLog(String locationLog) {
		this.locationLog = locationLog;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getIdEsta() {
		return idEsta;
	}

	public void setIdEsta(Long idEsta) {
		this.idEsta = idEsta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
