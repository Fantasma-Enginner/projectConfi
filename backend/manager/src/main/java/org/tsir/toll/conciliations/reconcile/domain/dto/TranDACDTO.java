package org.tsir.toll.conciliations.reconcile.domain.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.tsir.toll.conciliations.reconcile.domain.values.Manten;
import org.tsir.toll.conciliations.reconcile.domain.values.Sent;
import org.tsir.toll.conciliations.reconcile.domain.values.Simulation;
import org.tsir.toll.conciliations.reconcile.domain.values.Violation;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TranDACDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T20:45:02.436Z[GMT]")


public class TranDACDTO   {
  @JsonProperty("tranDACId")
  private Long tranDACId = null;

  @JsonProperty("cateId")
  private Long cateId = null;

  @JsonProperty("axisTranDac")
  private Long axisTranDac = null;

  @JsonProperty("axisDoublesDetect")
  private Long axisDoublesDetect = null;

  @JsonProperty("sentidoDac")
  private Sent sentidoDac = null;

  @JsonProperty("dateTranDac")
  private Timestamp dateTranDac = null;

  @JsonProperty("dateRecTranDac")
  private Timestamp dateRecTranDac = null;

  @JsonProperty("carrId")
  private Long carrId = null;

  @JsonProperty("turnCode")
  private String turnCode = null;

  @JsonProperty("usrsId")
  private Long usrsId = null;

  @JsonProperty("manteni")
  private Manten manteni = null;

  @JsonProperty("violation")
  private Violation violation = null;

  @JsonProperty("simulation")
  private Simulation simulation = null;

  @JsonProperty("dateRec")
  private LocalDate dateRec = null;

  @JsonProperty("consecutive")
  private Long consecutive = null;

  @JsonProperty("receiptData")
  private String receiptData = null;

  public TranDACDTO tranDACId(Long tranDACId) {
    this.tranDACId = tranDACId;
    return this;
  }

  /**
   * Identificador de la transacción de DAC
   * @return tranDACId
   **/
  @Schema(example = "280115931065754300", description = "Identificador de la transacción de DAC")
  
    public Long getTranDACId() {
    return tranDACId;
  }

  public void setTranDACId(Long tranDACId) {
    this.tranDACId = tranDACId;
  }

  public TranDACDTO cateId(Long cateId) {
    this.cateId = cateId;
    return this;
  }

  /**
   * Id de categoría del vehículo detectada
   * @return cateId
   **/
  @Schema(example = "2", description = "Id de categoría del vehículo detectada")
  
    public Long getCateId() {
    return cateId;
  }

  public void setCateId(Long cateId) {
    this.cateId = cateId;
  }

  public TranDACDTO axisTranDac(Long axisTranDac) {
    this.axisTranDac = axisTranDac;
    return this;
  }

  /**
   * Cantidad de ejes detectada
   * @return axisTranDac
   **/
  @Schema(example = "2", description = "Cantidad de ejes detectada")
  
    public Long getAxisTranDac() {
    return axisTranDac;
  }

  public void setAxisTranDac(Long axisTranDac) {
    this.axisTranDac = axisTranDac;
  }

  public TranDACDTO axisDoublesDetect(Long axisDoublesDetect) {
    this.axisDoublesDetect = axisDoublesDetect;
    return this;
  }

  /**
   * Cantidad de ejes dobles detectada
   * @return axisDoublesDetect
   **/
  @Schema(example = "1", description = "Cantidad de ejes dobles detectada")
  
    public Long getAxisDoublesDetect() {
    return axisDoublesDetect;
  }

  public void setAxisDoublesDetect(Long axisDoublesDetect) {
    this.axisDoublesDetect = axisDoublesDetect;
  }

  public TranDACDTO sentidoDac(Sent sentidoDac) {
    this.sentidoDac = sentidoDac;
    return this;
  }

  /**
   * Get sentidoDac
   * @return sentidoDac
   **/
  @Schema(description = "")
  
    @Valid
    public Sent getSentidoDac() {
    return sentidoDac;
  }

  public void setSentidoDac(Sent sentidoDac) {
    this.sentidoDac = sentidoDac;
  }

  public TranDACDTO dateTranDac(Timestamp dateTranDac) {
    this.dateTranDac = dateTranDac;
    return this;
  }

  /**
   * Fecha y hora de registro de la detección
   * @return dateTranDac
   **/
  @Schema(example = "25/06/20 12:36:15,449000000 PM", description = "Fecha y hora de registro de la detección")
  
    public Timestamp getDateTranDac() {
    return dateTranDac;
  }

  public void setDateTranDac(Timestamp dateTranDac) {
    this.dateTranDac = dateTranDac;
  }

  public TranDACDTO dateRecTranDac(Timestamp dateRecTranDac) {
    this.dateRecTranDac = dateRecTranDac;
    return this;
  }

  /**
   * Fecha y hora de registro del recaudo
   * @return dateRecTranDac
   **/
  @Schema(description = "Fecha y hora de registro del recaudo")
  
    public Timestamp getDateRecTranDac() {
    return dateRecTranDac;
  }

  public void setDateRecTranDac(Timestamp dateRecTranDac) {
    this.dateRecTranDac = dateRecTranDac;
  }

  public TranDACDTO carrId(Long carrId) {
    this.carrId = carrId;
    return this;
  }

  /**
   * Carril de detección de categoría
   * @return carrId
   **/
  @Schema(example = "2801", description = "Carril de detección de categoría")
  
    public Long getCarrId() {
    return carrId;
  }

  public void setCarrId(Long carrId) {
    this.carrId = carrId;
  }

  public TranDACDTO turnCode(String turnCode) {
    this.turnCode = turnCode;
    return this;
  }

  /**
   * Código del turno donde ocurre la detección
   * @return turnCode
   **/
  @Schema(example = "1", description = "Código del turno donde ocurre la detección")
  
    public String getTurnCode() {
    return turnCode;
  }

  public void setTurnCode(String turnCode) {
    this.turnCode = turnCode;
  }

  public TranDACDTO usrsId(Long usrsId) {
    this.usrsId = usrsId;
    return this;
  }

  /**
   * Id del usuario en el cual s eregistra la detección
   * @return usrsId
   **/
  @Schema(example = "2000000000000200", description = "Id del usuario en el cual s eregistra la detección")
  
    public Long getUsrsId() {
    return usrsId;
  }

  public void setUsrsId(Long usrsId) {
    this.usrsId = usrsId;
  }

  public TranDACDTO manteni(Manten manteni) {
    this.manteni = manteni;
    return this;
  }

  /**
   * Get manteni
   * @return manteni
   **/
  @Schema(description = "")
  
    @Valid
    public Manten getManteni() {
    return manteni;
  }

  public void setManteni(Manten manteni) {
    this.manteni = manteni;
  }

  public TranDACDTO violation(Violation violation) {
    this.violation = violation;
    return this;
  }

  /**
   * Get violation
   * @return violation
   **/
  @Schema(description = "")
  
    @Valid
    public Violation getViolation() {
    return violation;
  }

  public void setViolation(Violation violation) {
    this.violation = violation;
  }

  public TranDACDTO simulation(Simulation simulation) {
    this.simulation = simulation;
    return this;
  }

  /**
   * Get simulation
   * @return simulation
   **/
  @Schema(description = "")
  
    @Valid
    public Simulation getSimulation() {
    return simulation;
  }

  public void setSimulation(Simulation simulation) {
    this.simulation = simulation;
  }

  public TranDACDTO dateRec(LocalDate dateRec) {
    this.dateRec = dateRec;
    return this;
  }

  /**
   * Fecha de recaudo
   * @return dateRec
   **/
  @Schema(example = "25/06/20", description = "Fecha de recaudo")
  
    public LocalDate getDateRec() {
    return dateRec;
  }

  public void setDateRec(LocalDate dateRec) {
    this.dateRec = dateRec;
  }

  public TranDACDTO consecutive(Long consecutive) {
    this.consecutive = consecutive;
    return this;
  }

  /**
   * Consecutivo
   * @return consecutive
   **/
  @Schema(example = "1", description = "Consecutivo")
  
    public Long getConsecutive() {
    return consecutive;
  }

  public void setConsecutive(Long consecutive) {
    this.consecutive = consecutive;
  }

  public TranDACDTO receiptData(String receiptData) {
    this.receiptData = receiptData;
    return this;
  }

  /**
   * Recepción de datos
   * @return receiptData
   **/
  @Schema(example = "200000200000101", description = "Recepción de datos")
  
    public String getReceiptData() {
    return receiptData;
  }

  public void setReceiptData(String receiptData) {
    this.receiptData = receiptData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TranDACDTO tranDACDTO = (TranDACDTO) o;
    return Objects.equals(this.tranDACId, tranDACDTO.tranDACId) &&
        Objects.equals(this.cateId, tranDACDTO.cateId) &&
        Objects.equals(this.axisTranDac, tranDACDTO.axisTranDac) &&
        Objects.equals(this.axisDoublesDetect, tranDACDTO.axisDoublesDetect) &&
        Objects.equals(this.sentidoDac, tranDACDTO.sentidoDac) &&
        Objects.equals(this.dateTranDac, tranDACDTO.dateTranDac) &&
        Objects.equals(this.dateRecTranDac, tranDACDTO.dateRecTranDac) &&
        Objects.equals(this.carrId, tranDACDTO.carrId) &&
        Objects.equals(this.turnCode, tranDACDTO.turnCode) &&
        Objects.equals(this.usrsId, tranDACDTO.usrsId) &&
        Objects.equals(this.manteni, tranDACDTO.manteni) &&
        Objects.equals(this.violation, tranDACDTO.violation) &&
        Objects.equals(this.simulation, tranDACDTO.simulation) &&
        Objects.equals(this.dateRec, tranDACDTO.dateRec) &&
        Objects.equals(this.consecutive, tranDACDTO.consecutive) &&
        Objects.equals(this.receiptData, tranDACDTO.receiptData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tranDACId, cateId, axisTranDac, axisDoublesDetect, sentidoDac, dateTranDac, dateRecTranDac, carrId, turnCode, usrsId, manteni, violation, simulation, dateRec, consecutive, receiptData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranDACDTO {\n");
    
    sb.append("    tranDACId: ").append(toIndentedString(tranDACId)).append("\n");
    sb.append("    cateId: ").append(toIndentedString(cateId)).append("\n");
    sb.append("    axisTranDac: ").append(toIndentedString(axisTranDac)).append("\n");
    sb.append("    axisDoublesDetect: ").append(toIndentedString(axisDoublesDetect)).append("\n");
    sb.append("    sentidoDac: ").append(toIndentedString(sentidoDac)).append("\n");
    sb.append("    dateTranDac: ").append(toIndentedString(dateTranDac)).append("\n");
    sb.append("    dateRecTranDac: ").append(toIndentedString(dateRecTranDac)).append("\n");
    sb.append("    carrId: ").append(toIndentedString(carrId)).append("\n");
    sb.append("    turnCode: ").append(toIndentedString(turnCode)).append("\n");
    sb.append("    usrsId: ").append(toIndentedString(usrsId)).append("\n");
    sb.append("    manteni: ").append(toIndentedString(manteni)).append("\n");
    sb.append("    violation: ").append(toIndentedString(violation)).append("\n");
    sb.append("    simulation: ").append(toIndentedString(simulation)).append("\n");
    sb.append("    dateRec: ").append(toIndentedString(dateRec)).append("\n");
    sb.append("    consecutive: ").append(toIndentedString(consecutive)).append("\n");
    sb.append("    receiptData: ").append(toIndentedString(receiptData)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
