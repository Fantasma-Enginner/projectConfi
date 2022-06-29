package org.tsir.toll.conciliations.reconcile.domain.values;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeración de los responsables de los ajustes:  * `1` - GERENCIA TÉCNICA.  * `2` - RECOLECTORA.  * `3` - N/A. 
 */
public enum Responsable {
  NUMBER_1(1),
    NUMBER_2(2),
    NUMBER_3(3);

  private Integer value;

  Responsable(Integer value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Responsable fromValue(String text) {
    for (Responsable b : Responsable.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
