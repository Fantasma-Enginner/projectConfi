package org.tsir.toll.conciliations.reconcile.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USRS_TURN")
public class UsrsTurn implements Serializable {
	@Id
	@Column(name = "ID_USRS_TURN")
	private long idUsrsTurn;

	@Column(name = "INICIO_TURN")
	private LocalDateTime inicioTurn;

	@Column(name = "FIN_TURN")
	private LocalDateTime finTurn;

	@Column(name = "FECHA_INGRESO_USRS")
	private LocalDateTime fechaIngresoUsrs;

	@Column(name = "FECHA_SALIDA_USRS")
	private LocalDateTime fechaSalidaUsrs;

	@Column(name = "CODIGO_TURNO_USRS")
	private Long codigoTurnoUsrs;

	@Column(name = "ID_TRAN_INICIO")
	private Long idTranInicio;

	@Column(name = "ID_TRAN_FINAL")
	private Long idTranFinal;

	@Column(name = "BASE_USRS_TURN")
	private Long baseUsrsTurn;

	private String mantenimiento;

	@Column(name = "NODE")
	private Long node;

	@Column(name = "FECHA_REC")
	private LocalDate fechaRec;


	@ManyToOne
	@JoinColumn(name = "ID_USRS")
	private Usrs usrs;

	private static final long serialVersionUID = 1L;

	public UsrsTurn() {
		super();
	}

	public long getIdUsrsTurn() {
		return this.idUsrsTurn;
	}

	public void setIdUsrsTurn(long idUsrsTurn) {
		this.idUsrsTurn = idUsrsTurn;
	}

	public LocalDateTime getInicioTurn() {
		return this.inicioTurn;
	}

	public void setInicioTurn(LocalDateTime inicioTurn) {
		this.inicioTurn = inicioTurn;
	}

	public LocalDateTime getFinTurn() {
		return this.finTurn;
	}

	public void setFinTurn(LocalDateTime finTurn) {
		this.finTurn = finTurn;
	}

	public LocalDateTime getFechaIngresoUsrs() {
		return this.fechaIngresoUsrs;
	}

	public void setFechaIngresoUsrs(LocalDateTime fechaIngresoUsrs) {
		this.fechaIngresoUsrs = fechaIngresoUsrs;
	}

	public LocalDateTime getFechaSalidaUsrs() {
		return this.fechaSalidaUsrs;
	}

	public void setFechaSalidaUsrs(LocalDateTime fechaSalidaUsrs) {
		this.fechaSalidaUsrs = fechaSalidaUsrs;
	}

	public Long getCodigoTurnoUsrs() {
		return this.codigoTurnoUsrs;
	}

	public void setCodigoTurnoUsrs(Long codigoTurnoUsrs) {
		this.codigoTurnoUsrs = codigoTurnoUsrs;
	}

	public Long getIdTranInicio() {
		return this.idTranInicio;
	}

	public void setIdTranInicio(Long idTranInicio) {
		this.idTranInicio = idTranInicio;
	}

	public Long getIdTranFinal() {
		return this.idTranFinal;
	}

	public void setIdTranFinal(Long idTranFinal) {
		this.idTranFinal = idTranFinal;
	}

	public Long getBaseUsrsTurn() {
		return this.baseUsrsTurn;
	}

	public void setBaseUsrsTurn(Long baseUsrsTurn) {
		this.baseUsrsTurn = baseUsrsTurn;
	}

	public String getMantenimiento() {
		return this.mantenimiento;
	}

	public void setMantenimiento(String mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public Long getNode() {
		return node;
	}

	public void setNode(Long node) {
		this.node = node;
	}

	public LocalDate getFechaRec() {
		return fechaRec;
	}

	public void setFechaRec(LocalDate fechaRec) {
		this.fechaRec = fechaRec;
	}

	

	public Usrs getUsrs() {
		return this.usrs;
	}

	public void setUsrs(Usrs idUsrs) {
		this.usrs = idUsrs;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("");
		builder.append(idUsrsTurn);
		builder.append(",");
		builder.append(codigoTurnoUsrs.longValue());
		builder.append(",");
		builder.append(",");
		builder.append(getUsrs().getCodigoUsrs().longValue());
		return builder.toString();
	}

}
