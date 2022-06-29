package org.tsir.toll.conciliations.reconcile.domain.values;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeración de los posible sentidos de circulación en una estación de peaje:  * `PRINCIPAL` - Sentido de tránsito desde la ciudad origen hacia la ciudad destino.  * `RETORNO` - Sentido de tránsito desde la ciudad destino hacia la cuidad principal. 
 */
public enum Direction {
  PRINCIPAL("PRINCIPAL"),
    RETORNO("RETORNO");

  private String value;

  Direction(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Direction fromValue(String text) {
    for (Direction b : Direction.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
