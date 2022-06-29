package org.tsir.toll.conciliations.reconcile.domain.dto;

import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReconcileDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-04T13:15:00.212Z[GMT]")


public class ReconcileDTO   {
  @JsonProperty("idConc")
  private String idConc = null;

  @JsonProperty("idTranDac")
  private String idTranDac = null;

  @JsonProperty("stationCode")
  private Integer stationCode = null;

  @JsonProperty("dateCollection")
  private String dateCollection = null;

  @JsonProperty("laneId")
  private Integer laneId = null;

  @JsonProperty("turnCode")
  private Integer turnCode = null;

  @JsonProperty("consoleCategory")
  private Integer consoleCategory = null;

  @JsonProperty("dacCategory")
  private Integer dacCategory = null;

  @JsonProperty("sentConc")
  private String sentConc = null;

  @JsonProperty("usercode")
  private String usercode = null;
  
  @JsonProperty("usercodename")
  private String usercodename= null;

  @JsonProperty("noveltyName")
  private String noveltyName = null;

  @JsonProperty("valueCollection")
  private String valueCollection = null;

  @JsonProperty("conciliationRuleName")
  private String conciliationRuleName = null;

  @JsonProperty("reconcileValue")
  private Integer reconcileValue = null;

  @JsonProperty("ruleId")
  private Integer ruleId = null;

  @JsonProperty("dateTransaction")
  private String dateTransaction = null;

  @JsonProperty("afectaConcId")
  private Integer afectaConcId = null;

  @JsonProperty("idFormPago")
  private Long idFormPago = null;
  
  @JsonProperty("idFormPagoname")
  private String idFormPagoname = null;

  @JsonProperty("numPlaca")
  private String numPlaca = null;

	@JsonProperty("comprobacion")
	private boolean comprobacion = false;
	
  public ReconcileDTO idConc(String idConc) {
    this.idConc = idConc;
    return this;
  }

  public String getUsercodename() {
	return usercodename;
}

public void setUsercodename(String usercodename) {
	this.usercodename = usercodename;
}

public String getIdFormPagoname() {
	return idFormPagoname;
}

public void setIdFormPagoname(String idFormPagoname) {
	this.idFormPagoname = idFormPagoname;
}

/**
   * Id de Conc
   * @return idConc
   **/
  @Schema(example = "23456789032", description = "Id de Conc")
  
    public String getIdConc() {
    return idConc;
  }

  public void setIdConc(String idConc) {
    this.idConc = idConc;
  }

  public ReconcileDTO idTranDac(String idTranDac) {
    this.idTranDac = idTranDac;
    return this;
  }

  public boolean isComprobacion() {
	return comprobacion;
}

public void setComprobacion(boolean comprobacion) {
	this.comprobacion = comprobacion;
}

/**
   * Id Tran Dac
   * @return idTranDac
   **/
  @Schema(example = "23456780675", description = "Id Tran Dac")
  
    public String getIdTranDac() {
    return idTranDac;
  }

  public void setIdTranDac(String idTranDac) {
    this.idTranDac = idTranDac;
  }

  public ReconcileDTO stationCode(Integer stationCode) {
    this.stationCode = stationCode;
    return this;
  }

  /**
   * Código de la estación
   * @return stationCode
   **/
  @Schema(example = "28", description = "Código de la estación")
  
    public Integer getStationCode() {
    return stationCode;
  }

  public void setStationCode(Integer stationCode) {
    this.stationCode = stationCode;
  }

  public ReconcileDTO dateCollection(String dateCollection) {
    this.dateCollection = dateCollection;
    return this;
  }

  /**
   * Fecha del recaudo
   * @return dateCollection
   **/
  @Schema(example = "09/11/2021", description = "Fecha del recaudo")
  
    public String getDateCollection() {
    return dateCollection;
  }

  public void setDateCollection(String dateCollection) {
    this.dateCollection = dateCollection;
  }

  public ReconcileDTO laneId(Integer laneId) {
    this.laneId = laneId;
    return this;
  }

  /**
   * Id de carril
   * @return laneId
   **/
  @Schema(example = "2801", description = "Id de carril")
  
    public Integer getLaneId() {
    return laneId;
  }

  public void setLaneId(Integer laneId) {
    this.laneId = laneId;
  }

  public ReconcileDTO turnCode(Integer turnCode) {
    this.turnCode = turnCode;
    return this;
  }

  /**
   * Código de turno
   * @return turnCode
   **/
  @Schema(example = "1", description = "Código de turno")
  
    public Integer getTurnCode() {
    return turnCode;
  }

  public void setTurnCode(Integer turnCode) {
    this.turnCode = turnCode;
  }

  public ReconcileDTO consoleCategory(Integer consoleCategory) {
    this.consoleCategory = consoleCategory;
    return this;
  }

  /**
   * Categoría de Consola
   * @return consoleCategory
   **/
  @Schema(example = "2", description = "Categoría de Consola")
  
    public Integer getConsoleCategory() {
    return consoleCategory;
  }

  public void setConsoleCategory(Integer consoleCategory) {
    this.consoleCategory = consoleCategory;
  }

  public ReconcileDTO dacCategory(Integer dacCategory) {
    this.dacCategory = dacCategory;
    return this;
  }

  /**
   * Categoría de DAC
   * @return dacCategory
   **/
  @Schema(description = "Categoría de DAC")
  
    public Integer getDacCategory() {
    return dacCategory;
  }

  public void setDacCategory(Integer dacCategory) {
    this.dacCategory = dacCategory;
  }

  public ReconcileDTO sentConc(String sentConc) {
    this.sentConc = sentConc;
    return this;
  }

  /**
   * Sentido
   * @return sentConc
   **/
  @Schema(example = "A", description = "Sentido")
  
    public String getSentConc() {
    return sentConc;
  }

  public void setSentConc(String sentConc) {
    this.sentConc = sentConc;
  }

  public ReconcileDTO usercode(String usercode) {
    this.usercode = usercode;
    return this;
  }

  /**
   * id del recolector
   * @return usercode
   **/
  @Schema(example = "1234568", description = "id del recolector")
  
    public String getUsercode() {
    return usercode;
  }

  public void setUsercode(String usercode) {
    this.usercode = usercode;
  }

  public ReconcileDTO noveltyName(String noveltyName) {
    this.noveltyName = noveltyName;
    return this;
  }

  /**
   * Nombre de la novedad
   * @return noveltyName
   **/
  @Schema(example = "TRANSPORTE PASAJEROS", description = "Nombre de la novedad")
  
    public String getNoveltyName() {
    return noveltyName;
  }

  public void setNoveltyName(String noveltyName) {
    this.noveltyName = noveltyName;
  }

  public ReconcileDTO valueCollection(String valueCollection) {
    this.valueCollection = valueCollection;
    return this;
  }

  /**
   * Valor recaudado
   * @return valueCollection
   **/
  @Schema(example = "11000", description = "Valor recaudado")
  
    public String getValueCollection() {
    return valueCollection;
  }

  public void setValueCollection(String valueCollection) {
    this.valueCollection = valueCollection;
  }

  public ReconcileDTO conciliationRuleName(String conciliationRuleName) {
    this.conciliationRuleName = conciliationRuleName;
    return this;
  }

  /**
   * Nombre de la regla de conciliación
   * @return conciliationRuleName
   **/
  @Schema(description = "Nombre de la regla de conciliación")
  
    public String getConciliationRuleName() {
    return conciliationRuleName;
  }

  public void setConciliationRuleName(String conciliationRuleName) {
    this.conciliationRuleName = conciliationRuleName;
  }

  public ReconcileDTO reconcileValue(Integer reconcileValue) {
    this.reconcileValue = reconcileValue;
    return this;
  }

  /**
   * Valor real conciliado
   * @return reconcileValue
   **/
  @Schema(description = "Valor real conciliado")
  
    public Integer getReconcileValue() {
    return reconcileValue;
  }

  public void setReconcileValue(Integer reconcileValue) {
    this.reconcileValue = reconcileValue;
  }

  public ReconcileDTO ruleId(Integer ruleId) {
    this.ruleId = ruleId;
    return this;
  }

  /**
   * Id de la regla de conciliación
   * @return ruleId
   **/
  @Schema(description = "Id de la regla de conciliación")
  
    public Integer getRuleId() {
    return ruleId;
  }

  public void setRuleId(Integer ruleId) {
    this.ruleId = ruleId;
  }

  public ReconcileDTO dateTransaction(String dateTransaction) {
    this.dateTransaction = dateTransaction;
    return this;
  }

  /**
   * fecha de la transacción
   * @return dateTransaction
   **/
  @Schema(description = "fecha de la transacción")
  
    public String getDateTransaction() {
    return dateTransaction;
  }

  public void setDateTransaction(String dateTransaction) {
    this.dateTransaction = dateTransaction;
  }

  public ReconcileDTO afectaConcId(Integer afectaConcId) {
    this.afectaConcId = afectaConcId;
    return this;
  }

  /**
   * Id de la afectación
   * @return afectaConcId
   **/
  @Schema(example = "1", description = "Id de la afectación")
  
    public Integer getAfectaConcId() {
    return afectaConcId;
  }

  public void setAfectaConcId(Integer afectaConcId) {
    this.afectaConcId = afectaConcId;
  }

  public ReconcileDTO idFormPago(Long idFormPago) {
    this.idFormPago = idFormPago;
    return this;
  }

  /**
   * Id de la forma de pago
   * @return idFormPago
   **/
  @Schema(example = "9", description = "Id de la forma de pago")
  
    public Long getIdFormPago() {
    return idFormPago;
  }

  public void setIdFormPago(Long idFormPago) {
    this.idFormPago = idFormPago;
  }

  public ReconcileDTO numPlaca(String numPlaca) {
    this.numPlaca = numPlaca;
    return this;
  }

  /**
   * Numero de placa
   * @return numPlaca
   **/
  @Schema(example = "ABC123", description = "Numero de placa")
  
    public String getNumPlaca() {
    return numPlaca;
  }

  public void setNumPlaca(String numPlaca) {
    this.numPlaca = numPlaca;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReconcileDTO reconcileDTO = (ReconcileDTO) o;
    return Objects.equals(this.idConc, reconcileDTO.idConc) &&
        Objects.equals(this.idTranDac, reconcileDTO.idTranDac) &&
        Objects.equals(this.stationCode, reconcileDTO.stationCode) &&
        Objects.equals(this.dateCollection, reconcileDTO.dateCollection) &&
        Objects.equals(this.laneId, reconcileDTO.laneId) &&
        Objects.equals(this.turnCode, reconcileDTO.turnCode) &&
        Objects.equals(this.consoleCategory, reconcileDTO.consoleCategory) &&
        Objects.equals(this.dacCategory, reconcileDTO.dacCategory) &&
        Objects.equals(this.sentConc, reconcileDTO.sentConc) &&
        Objects.equals(this.usercode, reconcileDTO.usercode) &&
        Objects.equals(this.noveltyName, reconcileDTO.noveltyName) &&
        Objects.equals(this.valueCollection, reconcileDTO.valueCollection) &&
        Objects.equals(this.conciliationRuleName, reconcileDTO.conciliationRuleName) &&
        Objects.equals(this.reconcileValue, reconcileDTO.reconcileValue) &&
        Objects.equals(this.ruleId, reconcileDTO.ruleId) &&
        Objects.equals(this.dateTransaction, reconcileDTO.dateTransaction) &&
        Objects.equals(this.afectaConcId, reconcileDTO.afectaConcId) &&
        Objects.equals(this.idFormPago, reconcileDTO.idFormPago) &&
        Objects.equals(this.numPlaca, reconcileDTO.numPlaca);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idConc, idTranDac, stationCode, dateCollection, laneId, turnCode, consoleCategory, dacCategory, sentConc, usercode, noveltyName, valueCollection, conciliationRuleName, reconcileValue, ruleId, dateTransaction, afectaConcId, idFormPago, numPlaca);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReconcileDTO {\n");
    
    sb.append("    idConc: ").append(toIndentedString(idConc)).append("\n");
    sb.append("    idTranDac: ").append(toIndentedString(idTranDac)).append("\n");
    sb.append("    stationCode: ").append(toIndentedString(stationCode)).append("\n");
    sb.append("    dateCollection: ").append(toIndentedString(dateCollection)).append("\n");
    sb.append("    laneId: ").append(toIndentedString(laneId)).append("\n");
    sb.append("    turnCode: ").append(toIndentedString(turnCode)).append("\n");
    sb.append("    consoleCategory: ").append(toIndentedString(consoleCategory)).append("\n");
    sb.append("    dacCategory: ").append(toIndentedString(dacCategory)).append("\n");
    sb.append("    sentConc: ").append(toIndentedString(sentConc)).append("\n");
    sb.append("    usercode: ").append(toIndentedString(usercode)).append("\n");
    sb.append("    noveltyName: ").append(toIndentedString(noveltyName)).append("\n");
    sb.append("    valueCollection: ").append(toIndentedString(valueCollection)).append("\n");
    sb.append("    conciliationRuleName: ").append(toIndentedString(conciliationRuleName)).append("\n");
    sb.append("    reconcileValue: ").append(toIndentedString(reconcileValue)).append("\n");
    sb.append("    ruleId: ").append(toIndentedString(ruleId)).append("\n");
    sb.append("    dateTransaction: ").append(toIndentedString(dateTransaction)).append("\n");
    sb.append("    afectaConcId: ").append(toIndentedString(afectaConcId)).append("\n");
    sb.append("    idFormPago: ").append(toIndentedString(idFormPago)).append("\n");
    sb.append("    numPlaca: ").append(toIndentedString(numPlaca)).append("\n");
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
