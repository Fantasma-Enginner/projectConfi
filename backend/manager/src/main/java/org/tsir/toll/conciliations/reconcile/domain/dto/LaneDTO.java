package org.tsir.toll.conciliations.reconcile.domain.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.tsir.toll.conciliations.reconcile.domain.values.Direction;
import org.tsir.toll.conciliations.reconcile.domain.values.OperationMode;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LaneDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-28T16:10:25.709Z[GMT]")


public class LaneDTO   {
  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("toll")
  private Integer toll = null;

  @JsonProperty("label")
  private String label = null;

  @JsonProperty("assignDirection")
  private Direction assignDirection = null;

  @JsonProperty("currentDirection")
  private Direction currentDirection = null;

  @JsonProperty("mode")
  private OperationMode mode = null;

  public LaneDTO code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public LaneDTO toll(Integer toll) {
    this.toll = toll;
    return this;
  }

  /**
   * Get toll
   * @return toll
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getToll() {
    return toll;
  }

  public void setToll(Integer toll) {
    this.toll = toll;
  }

  public LaneDTO label(String label) {
    this.label = label;
    return this;
  }

  /**
   * Nombre o etiqueta del del carril en la estación para su visualización en informes o tiquetes comprobantes de pago.  
   * @return label
   **/
  @Schema(description = "Nombre o etiqueta del del carril en la estación para su visualización en informes o tiquetes comprobantes de pago.  ")
  
    public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public LaneDTO assignDirection(Direction assignDirection) {
    this.assignDirection = assignDirection;
    return this;
  }

  /**
   * Get assignDirection
   * @return assignDirection
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Direction getAssignDirection() {
    return assignDirection;
  }

  public void setAssignDirection(Direction assignDirection) {
    this.assignDirection = assignDirection;
  }

  public LaneDTO currentDirection(Direction currentDirection) {
    this.currentDirection = currentDirection;
    return this;
  }

  /**
   * Get currentDirection
   * @return currentDirection
   **/
  @Schema(description = "")
  
    @Valid
    public Direction getCurrentDirection() {
    return currentDirection;
  }

  public void setCurrentDirection(Direction currentDirection) {
    this.currentDirection = currentDirection;
  }

  public LaneDTO mode(OperationMode mode) {
    this.mode = mode;
    return this;
  }

  /**
   * Get mode
   * @return mode
   **/
  @Schema(description = "")
  
    @Valid
    public OperationMode getMode() {
    return mode;
  }

  public void setMode(OperationMode mode) {
    this.mode = mode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LaneDTO laneDTO = (LaneDTO) o;
    return Objects.equals(this.code, laneDTO.code) &&
        Objects.equals(this.toll, laneDTO.toll) &&
        Objects.equals(this.label, laneDTO.label) &&
        Objects.equals(this.assignDirection, laneDTO.assignDirection) &&
        Objects.equals(this.currentDirection, laneDTO.currentDirection) &&
        Objects.equals(this.mode, laneDTO.mode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, toll, label, assignDirection, currentDirection, mode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LaneDTO {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    toll: ").append(toIndentedString(toll)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    assignDirection: ").append(toIndentedString(assignDirection)).append("\n");
    sb.append("    currentDirection: ").append(toIndentedString(currentDirection)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
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
