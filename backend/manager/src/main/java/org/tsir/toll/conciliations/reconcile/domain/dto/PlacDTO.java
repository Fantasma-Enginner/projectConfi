package org.tsir.toll.conciliations.reconcile.domain.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PlacDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-02-24T17:19:40.141Z[GMT]")


public class PlacDTO   {
  @JsonProperty("idPlac")
  private String idPlac = null;

  @JsonProperty("fechaActualizacionPlaca")
  private Timestamp fechaActualizacionPlaca = null;

  @JsonProperty("idCate")
  private Long idCate = null;

  @JsonProperty("chequeoCatPlac")
  private Long chequeoCatPlac = null;

  @JsonProperty("color")
  private String color = null;

  @JsonProperty("marca")
  private String marca = null;

  @JsonProperty("modelo")
  private Integer modelo = null;

  @JsonProperty("regCatPlac")
  private Integer regCatPlac = null;
  
  
  public PlacDTO idPlac(String idPlac) {
    this.idPlac = idPlac;
    return this;
  }

  /**
   * id de la placa la cual debe ser alfanumerico
   * @return idPlac
   **/
  @Schema(example = "ABC123", description = "id de la placa la cual debe ser alfanumerico")
  
    public String getIdPlac() {
    return idPlac;
  }

  public void setIdPlac(String idPlac) {
    this.idPlac = idPlac;
  }

  public PlacDTO fechaActualizacionPlaca(Timestamp fechaActualizacionPlaca) {
    this.fechaActualizacionPlaca = fechaActualizacionPlaca;
    return this;
  }

  /**
   * Fecha del recaudo
   * @return fechaActualizacionPlaca
   **/
  @Schema(example = "09/11/2021", description = "Fecha del recaudo")
  
    public Timestamp getFechaActualizacionPlaca() {
    return fechaActualizacionPlaca;
  }

  public void setFechaActualizacionPlaca(Timestamp fechaActualizacionPlaca) {
    this.fechaActualizacionPlaca = fechaActualizacionPlaca;
  }

  public PlacDTO idCate(Long idCate) {
    this.idCate = idCate;
    return this;
  }

  /**
   * id de la Categoría
   * @return idCate
   **/
  @Schema(example = "1", description = "id de la Categoría")
  
    public Long getIdCate() {
    return idCate;
  }

  public void setIdCate(Long idCate) {
    this.idCate = idCate;
  }

  public PlacDTO chequeoCatPlac(Long chequeoCatPlac) {
    this.chequeoCatPlac = chequeoCatPlac;
    return this;
  }

  /**
   * chequeo de la categoría placa
   * @return chequeoCatPlac
   **/
  @Schema(example = "28", description = "chequeo de la categoría placa")
  
    public Long getChequeoCatPlac() {
    return chequeoCatPlac;
  }

  public void setChequeoCatPlac(Long chequeoCatPlac) {
    this.chequeoCatPlac = chequeoCatPlac;
  }

  public PlacDTO color(String color) {
    this.color = color;
    return this;
  }

  /**
   * color del vehiculo
   * @return color
   **/
  @Schema(example = "Azul", description = "color del vehiculo")
  
    public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public PlacDTO marca(String marca) {
    this.marca = marca;
    return this;
  }

  /**
   * marca del vehiculo
   * @return marca
   **/
  @Schema(example = "0", description = "marca del vehiculo")
  
    public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public PlacDTO modelo(Integer modelo) {
    this.modelo = modelo;
    return this;
  }
  
  

  /**
   * modelo del vehiculo
   * @return modelo
   **/
  @Schema(example = "2012", description = "modelo del vehiculo")
  
    public Integer getModelo() {
    return modelo;
  }

  public void setModelo(Integer modelo) {
    this.modelo = modelo;
  }

  public PlacDTO regCatPlac(Integer regCatPlac) {
    this.regCatPlac = regCatPlac;
    return this;
  }

  /**
   * registro de la categoría
   * @return regCatPlac
   **/
  @Schema(description = "registro de la categoría")
  
    public Integer getRegCatPlac() {
    return regCatPlac;
  }

  public void setRegCatPlac(Integer regCatPlac) {
    this.regCatPlac = regCatPlac;
  }

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlacDTO placDTO = (PlacDTO) o;
    return Objects.equals(this.idPlac, placDTO.idPlac) &&
        Objects.equals(this.fechaActualizacionPlaca, placDTO.fechaActualizacionPlaca) &&
        Objects.equals(this.idCate, placDTO.idCate) &&
        Objects.equals(this.chequeoCatPlac, placDTO.chequeoCatPlac) &&
        Objects.equals(this.color, placDTO.color) &&
        Objects.equals(this.marca, placDTO.marca) &&
        Objects.equals(this.modelo, placDTO.modelo) &&
        Objects.equals(this.regCatPlac, placDTO.regCatPlac);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPlac, fechaActualizacionPlaca, idCate, chequeoCatPlac, color, marca, modelo, regCatPlac);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlacDTO {\n");
    
    sb.append("    idPlac: ").append(toIndentedString(idPlac)).append("\n");
    sb.append("    fechaActualizacionPlaca: ").append(toIndentedString(fechaActualizacionPlaca)).append("\n");
    sb.append("    idCate: ").append(toIndentedString(idCate)).append("\n");
    sb.append("    chequeoCatPlac: ").append(toIndentedString(chequeoCatPlac)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    marca: ").append(toIndentedString(marca)).append("\n");
    sb.append("    modelo: ").append(toIndentedString(modelo)).append("\n");
    sb.append("    regCatPlac: ").append(toIndentedString(regCatPlac)).append("\n");
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
