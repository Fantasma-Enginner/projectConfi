package org.tsir.toll.conciliations.reconcile.infrastructure.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Schema for error response body
 */
@Schema(description = "Schema for error response body")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-01T16:37:58.531Z[GMT]")


public class ApiMessage   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("message")
  private String message = null;

  public ApiMessage code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Codigo de respuesta. 
   * @return code
   **/
  @Schema(required = true, description = "Codigo de respuesta. ")
      @NotNull

    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ApiMessage message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Texto del mensaje. 
   * @return message
   **/
  @Schema(required = true, description = "Texto del mensaje. ")
      @NotNull

    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiMessage apiMessage = (ApiMessage) o;
    return Objects.equals(this.code, apiMessage.code) &&
        Objects.equals(this.message, apiMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiMessage {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
