package org.tsir.toll.conciliations.reconcile.domain.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TranConsDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-25T20:51:55.887Z[GMT]")


public class TranConsDTO   {
  @JsonProperty("tranConsId")
  private Long tranConsId = null;

  @JsonProperty("cateId")
  private Long cateId = null;

  @JsonProperty("idUsrsTurn")
  private Long idUsrsTurn = null;

  @JsonProperty("codigoTranCons")
  private Long codigoTranCons = null;

  @JsonProperty("sentidoTranCons")
  private String sentidoTranCons = null;

  @JsonProperty("dateTranCons")
  private String dateTranCons = null;

  @JsonProperty("novedadTranCons")
  private String novedadTranCons = null;

  @JsonProperty("valorCateTranCons")
  private Long valorCateTranCons = null;

  @JsonProperty("totalTranCons")
  private Long totalTranCons = null;

  @JsonProperty("idPlac")
  private String idPlac = null;

  @JsonProperty("consecutivoTranCons")
  private Long consecutivoTranCons = null;

  @JsonProperty("idFormaPago")
  private Long idFormaPago = null;

  @JsonProperty("totalIva")
  private Long totalIva = null;

  @JsonProperty("totalEjes")
  private Long totalEjes = null;

  @JsonProperty("tiqueteInvias")
  private String tiqueteInvias = null;

  @JsonProperty("placaDetectada")
  private String placaDetectada = null;

  @JsonProperty("chequeoTranCons")
  private String chequeoTranCons = null;

  @JsonProperty("chequeoTranTag")
  private Long chequeoTranTag = null;

  @JsonProperty("validacion")
  private Long validacion = null;

  @JsonProperty("resultadoValidacion")
  private Long resultadoValidacion = null;

  @JsonProperty("signature")
  private String signature = null;
  
  @JsonProperty("categoryDetectedByDac")
  private Long categoryDetectedByDac = null;

  public TranConsDTO tranConsId(Long tranConsId) {
    this.tranConsId = tranConsId;
    return this;
  }

  /**
   * Identificador de la transacción de consola
   * @return tranConsId
   **/
  @Schema(example = "280115931065754300", description = "Identificador de la transacción de consola")
  
    public Long getTranConsId() {
    return tranConsId;
  }

  public void setTranConsId(Long tranConsId) {
    this.tranConsId = tranConsId;
  }

  public TranConsDTO categoryDetectedByDac(Long categoryDetectedByDac) {
    this.categoryDetectedByDac = categoryDetectedByDac;
    return this;
  }

  /**
   * Id de categoría del vehículo detectada por el DAC
   * @return cateId
   **/
  @Schema(example = "2", description = "Id de categoría del vehículo detectada por el DAC")
  
    public Long getCategoryDetectedByDac() {
    return categoryDetectedByDac;
  }

  public void setCategoryDetectedByDac(Long categoryDetectedByDac) {
    this.categoryDetectedByDac = categoryDetectedByDac;
  }
  
  public TranConsDTO cateId(Long cateId) {
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

  public TranConsDTO idUsrsTurn(Long idUsrsTurn) {
    this.idUsrsTurn = idUsrsTurn;
    return this;
  }

  /**
   * ID del usuario
   * @return idUsrsTurn
   **/
  @Schema(example = "130000000001", description = "ID del usuario")
  
    public Long getIdUsrsTurn() {
    return idUsrsTurn;
  }

  public void setIdUsrsTurn(Long idUsrsTurn) {
    this.idUsrsTurn = idUsrsTurn;
  }

  public TranConsDTO codigoTranCons(Long codigoTranCons) {
    this.codigoTranCons = codigoTranCons;
    return this;
  }

  /**
   * Codigo de la transacción
   * @return codigoTranCons
   **/
  @Schema(example = "130000000001", description = "Codigo de la transacción")
  
    public Long getCodigoTranCons() {
    return codigoTranCons;
  }

  public void setCodigoTranCons(Long codigoTranCons) {
    this.codigoTranCons = codigoTranCons;
  }

  public TranConsDTO sentidoTranCons(String sentidoTranCons) {
    this.sentidoTranCons = sentidoTranCons;
    return this;
  }

  /**
   * Sentido de carril
   * @return sentidoTranCons
   **/
  @Schema(example = "N", description = "Sentido de carril")
  
    public String getSentidoTranCons() {
    return sentidoTranCons;
  }

  public void setSentidoTranCons(String sentidoTranCons) {
    this.sentidoTranCons = sentidoTranCons;
  }

  public TranConsDTO dateTranCons(String dateTranCons) {
    this.dateTranCons = dateTranCons;
    return this;
  }

  /**
   * Fecha de transacción por consola
   * @return dateTranCons
   **/
  @Schema(example = "25/06/20", description = "Fecha de transacción por consola")
  
    public String getDateTranCons() {
    return dateTranCons;
  }

  public void setDateTranCons(String dateTranCons) {
    this.dateTranCons = dateTranCons;
  }

  public TranConsDTO novedadTranCons(String novedadTranCons) {
    this.novedadTranCons = novedadTranCons;
    return this;
  }

  /**
   * Novedad de la transacción por consola
   * @return novedadTranCons
   **/
  @Schema(example = "123123456789", description = "Novedad de la transacción por consola")
  
    public String getNovedadTranCons() {
    return novedadTranCons;
  }

  public void setNovedadTranCons(String novedadTranCons) {
    this.novedadTranCons = novedadTranCons;
  }

  public TranConsDTO valorCateTranCons(Long valorCateTranCons) {
    this.valorCateTranCons = valorCateTranCons;
    return this;
  }

  /**
   * Valor de la categoria
   * @return valorCateTranCons
   **/
  @Schema(example = "13000", description = "Valor de la categoria")
  
    public Long getValorCateTranCons() {
    return valorCateTranCons;
  }

  public void setValorCateTranCons(Long valorCateTranCons) {
    this.valorCateTranCons = valorCateTranCons;
  }

  public TranConsDTO totalTranCons(Long totalTranCons) {
    this.totalTranCons = totalTranCons;
    return this;
  }

  /**
   * Total de la transacción de consola
   * @return totalTranCons
   **/
  @Schema(example = "200000200000101", description = "Total de la transacción de consola")
  
    public Long getTotalTranCons() {
    return totalTranCons;
  }

  public void setTotalTranCons(Long totalTranCons) {
    this.totalTranCons = totalTranCons;
  }

  public TranConsDTO idPlac(String idPlac) {
    this.idPlac = idPlac;
    return this;
  }

  /**
   * Placa
   * @return idPlac
   **/
  @Schema(example = "ABC123", description = "Placa")
  
    public String getIdPlac() {
    return idPlac;
  }

  public void setIdPlac(String idPlac) {
    this.idPlac = idPlac;
  }

  public TranConsDTO consecutivoTranCons(Long consecutivoTranCons) {
    this.consecutivoTranCons = consecutivoTranCons;
    return this;
  }

  /**
   * Identificativo consecutivo transacción de consola
   * @return consecutivoTranCons
   **/
  @Schema(example = "200000200000101", description = "Identificativo consecutivo transacción de consola")
  
    public Long getConsecutivoTranCons() {
    return consecutivoTranCons;
  }

  public void setConsecutivoTranCons(Long consecutivoTranCons) {
    this.consecutivoTranCons = consecutivoTranCons;
  }

  public TranConsDTO idFormaPago(Long idFormaPago) {
    this.idFormaPago = idFormaPago;
    return this;
  }

  /**
   * ID forma de pago
   * @return idFormaPago
   **/
  @Schema(example = "200000200000101", description = "ID forma de pago")
  
    public Long getIdFormaPago() {
    return idFormaPago;
  }

  public void setIdFormaPago(Long idFormaPago) {
    this.idFormaPago = idFormaPago;
  }

  public TranConsDTO totalIva(Long totalIva) {
    this.totalIva = totalIva;
    return this;
  }

  /**
   * Total de IVA
   * @return totalIva
   **/
  @Schema(example = "200000200000101", description = "Total de IVA")
  
    public Long getTotalIva() {
    return totalIva;
  }

  public void setTotalIva(Long totalIva) {
    this.totalIva = totalIva;
  }

  public TranConsDTO totalEjes(Long totalEjes) {
    this.totalEjes = totalEjes;
    return this;
  }

  /**
   * Total de ejes
   * @return totalEjes
   **/
  @Schema(example = "200000200000101", description = "Total de ejes")
  
    public Long getTotalEjes() {
    return totalEjes;
  }

  public void setTotalEjes(Long totalEjes) {
    this.totalEjes = totalEjes;
  }

  public TranConsDTO tiqueteInvias(String tiqueteInvias) {
    this.tiqueteInvias = tiqueteInvias;
    return this;
  }

  /**
   * Tiquete de Invias
   * @return tiqueteInvias
   **/
  @Schema(example = "1231114564", description = "Tiquete de Invias")
  
    public String getTiqueteInvias() {
    return tiqueteInvias;
  }

  public void setTiqueteInvias(String tiqueteInvias) {
    this.tiqueteInvias = tiqueteInvias;
  }

  public TranConsDTO placaDetectada(String placaDetectada) {
    this.placaDetectada = placaDetectada;
    return this;
  }

  /**
   * Placa detectada
   * @return placaDetectada
   **/
  @Schema(example = "ABC123", description = "Placa detectada")
  
    public String getPlacaDetectada() {
    return placaDetectada;
  }

  public void setPlacaDetectada(String placaDetectada) {
    this.placaDetectada = placaDetectada;
  }

  public TranConsDTO chequeoTranCons(String chequeoTranCons) {
    this.chequeoTranCons = chequeoTranCons;
    return this;
  }

  /**
   * Chequeo del tran cons
   * @return chequeoTranCons
   **/
  @Schema(example = "200000200000101", description = "Chequeo del tran cons")
  
    public String getChequeoTranCons() {
    return chequeoTranCons;
  }

  public void setChequeoTranCons(String chequeoTranCons) {
    this.chequeoTranCons = chequeoTranCons;
  }

  public TranConsDTO chequeoTranTag(Long chequeoTranTag) {
    this.chequeoTranTag = chequeoTranTag;
    return this;
  }

  /**
   * Chequeo transacción TAG
   * @return chequeoTranTag
   **/
  @Schema(example = "200000200000101", description = "Chequeo transacción TAG")
  
    public Long getChequeoTranTag() {
    return chequeoTranTag;
  }

  public void setChequeoTranTag(Long chequeoTranTag) {
    this.chequeoTranTag = chequeoTranTag;
  }

  public TranConsDTO validacion(Long validacion) {
    this.validacion = validacion;
    return this;
  }

  /**
   * Validación de documento
   * @return validacion
   **/
  @Schema(example = "200000200000101", description = "Validación de documento")
  
    public Long getValidacion() {
    return validacion;
  }

  public void setValidacion(Long validacion) {
    this.validacion = validacion;
  }

  public TranConsDTO resultadoValidacion(Long resultadoValidacion) {
    this.resultadoValidacion = resultadoValidacion;
    return this;
  }

  /**
   * Resultado de la validación
   * @return resultadoValidacion
   **/
  @Schema(example = "200000200000101", description = "Resultado de la validación")
  
    public Long getResultadoValidacion() {
    return resultadoValidacion;
  }

  public void setResultadoValidacion(Long resultadoValidacion) {
    this.resultadoValidacion = resultadoValidacion;
  }

  public TranConsDTO signature(String signature) {
    this.signature = signature;
    return this;
  }

  /**
   * Signature
   * @return signature
   **/
  @Schema(example = "200000200000101", description = "Signature")
  
    public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TranConsDTO tranConsDTO = (TranConsDTO) o;
    return Objects.equals(this.tranConsId, tranConsDTO.tranConsId) &&
        Objects.equals(this.cateId, tranConsDTO.cateId) &&
        Objects.equals(this.idUsrsTurn, tranConsDTO.idUsrsTurn) &&
        Objects.equals(this.codigoTranCons, tranConsDTO.codigoTranCons) &&
        Objects.equals(this.sentidoTranCons, tranConsDTO.sentidoTranCons) &&
        Objects.equals(this.dateTranCons, tranConsDTO.dateTranCons) &&
        Objects.equals(this.novedadTranCons, tranConsDTO.novedadTranCons) &&
        Objects.equals(this.valorCateTranCons, tranConsDTO.valorCateTranCons) &&
        Objects.equals(this.totalTranCons, tranConsDTO.totalTranCons) &&
        Objects.equals(this.idPlac, tranConsDTO.idPlac) &&
        Objects.equals(this.consecutivoTranCons, tranConsDTO.consecutivoTranCons) &&
        Objects.equals(this.idFormaPago, tranConsDTO.idFormaPago) &&
        Objects.equals(this.totalIva, tranConsDTO.totalIva) &&
        Objects.equals(this.totalEjes, tranConsDTO.totalEjes) &&
        Objects.equals(this.tiqueteInvias, tranConsDTO.tiqueteInvias) &&
        Objects.equals(this.placaDetectada, tranConsDTO.placaDetectada) &&
        Objects.equals(this.chequeoTranCons, tranConsDTO.chequeoTranCons) &&
        Objects.equals(this.chequeoTranTag, tranConsDTO.chequeoTranTag) &&
        Objects.equals(this.validacion, tranConsDTO.validacion) &&
        Objects.equals(this.resultadoValidacion, tranConsDTO.resultadoValidacion) &&
        Objects.equals(this.signature, tranConsDTO.signature) &&
        Objects.equals(this.categoryDetectedByDac, tranConsDTO.categoryDetectedByDac);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tranConsId, cateId, idUsrsTurn, codigoTranCons, sentidoTranCons, dateTranCons, novedadTranCons, valorCateTranCons, totalTranCons, idPlac, consecutivoTranCons, idFormaPago, totalIva, totalEjes, tiqueteInvias, placaDetectada, chequeoTranCons, chequeoTranTag, validacion, resultadoValidacion, signature,categoryDetectedByDac);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranConsDTO {\n");
    
    sb.append("    tranConsId: ").append(toIndentedString(tranConsId)).append("\n");
    sb.append("    cateId: ").append(toIndentedString(cateId)).append("\n");
    sb.append("    idUsrsTurn: ").append(toIndentedString(idUsrsTurn)).append("\n");
    sb.append("    codigoTranCons: ").append(toIndentedString(codigoTranCons)).append("\n");
    sb.append("    sentidoTranCons: ").append(toIndentedString(sentidoTranCons)).append("\n");
    sb.append("    dateTranCons: ").append(toIndentedString(dateTranCons)).append("\n");
    sb.append("    novedadTranCons: ").append(toIndentedString(novedadTranCons)).append("\n");
    sb.append("    valorCateTranCons: ").append(toIndentedString(valorCateTranCons)).append("\n");
    sb.append("    totalTranCons: ").append(toIndentedString(totalTranCons)).append("\n");
    sb.append("    idPlac: ").append(toIndentedString(idPlac)).append("\n");
    sb.append("    consecutivoTranCons: ").append(toIndentedString(consecutivoTranCons)).append("\n");
    sb.append("    idFormaPago: ").append(toIndentedString(idFormaPago)).append("\n");
    sb.append("    totalIva: ").append(toIndentedString(totalIva)).append("\n");
    sb.append("    totalEjes: ").append(toIndentedString(totalEjes)).append("\n");
    sb.append("    tiqueteInvias: ").append(toIndentedString(tiqueteInvias)).append("\n");
    sb.append("    placaDetectada: ").append(toIndentedString(placaDetectada)).append("\n");
    sb.append("    chequeoTranCons: ").append(toIndentedString(chequeoTranCons)).append("\n");
    sb.append("    chequeoTranTag: ").append(toIndentedString(chequeoTranTag)).append("\n");
    sb.append("    validacion: ").append(toIndentedString(validacion)).append("\n");
    sb.append("    resultadoValidacion: ").append(toIndentedString(resultadoValidacion)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    categoryDetectedByDac: ").append(toIndentedString(categoryDetectedByDac)).append("\n");
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
