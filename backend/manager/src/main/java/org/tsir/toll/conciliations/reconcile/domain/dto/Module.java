package org.tsir.toll.conciliations.reconcile.domain.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * Module
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-26T01:10:03.916Z[GMT]")


public class Module   {
  @JsonProperty("moduleId")
  private Integer moduleId = null;

  @JsonProperty("moduleName")
  private String moduleName = null;

  public Module moduleId(Integer moduleId) {
    this.moduleId = moduleId;
    return this;
  }

  /**
   * Id del módulo
   * @return moduleId
   **/
  @Schema(description = "Id del módulo")
  
    public Integer getModuleId() {
    return moduleId;
  }

  public void setModuleId(Integer moduleId) {
    this.moduleId = moduleId;
  }

  public Module moduleName(String moduleName) {
    this.moduleName = moduleName;
    return this;
  }

  /**
   * Nombre del módulo
   * @return moduleName
   **/
  @Schema(description = "Nombre del módulo")
  
    public String getModuleName() {
    return moduleName;
  }

  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Module module = (Module) o;
    return Objects.equals(this.moduleId, module.moduleId) &&
        Objects.equals(this.moduleName, module.moduleName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(moduleId, moduleName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Module {\n");
    
    sb.append("    moduleId: ").append(toIndentedString(moduleId)).append("\n");
    sb.append("    moduleName: ").append(toIndentedString(moduleName)).append("\n");
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
