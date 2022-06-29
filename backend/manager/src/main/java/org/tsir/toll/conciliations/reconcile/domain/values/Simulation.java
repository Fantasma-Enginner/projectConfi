package org.tsir.toll.conciliations.reconcile.domain.values;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeración de sentidos del carril:  * `C` - CON VIOLACION.  * `S` - SIN VIOLACION.   .      
 */
public enum Simulation {
  C("C"),
  N("N"),
  S("S");

  private String value;

  Simulation(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Simulation fromValue(String text) {
    for (Simulation b : Simulation.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
