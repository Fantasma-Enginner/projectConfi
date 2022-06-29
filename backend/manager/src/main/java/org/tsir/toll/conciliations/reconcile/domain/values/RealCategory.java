package org.tsir.toll.conciliations.reconcile.domain.values;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeración de las categoría de recaudo:  * `C` - CONSOLA.  * `D` - DAC  * `O` - OTRA 
 */
public enum RealCategory {
  C("C"),
    D("D"),
    O("O");

  private String value;

  RealCategory(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static RealCategory fromValue(String text) {
    for (RealCategory b : RealCategory.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
