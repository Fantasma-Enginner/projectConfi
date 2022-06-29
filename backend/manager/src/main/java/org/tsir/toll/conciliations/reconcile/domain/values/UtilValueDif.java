package org.tsir.toll.conciliations.reconcile.domain.values;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeración de la aplicación de utilización valor diferencia:  * `0` - NO UTILIZA VALOR DIFERENCIA.  * `1` - SÍ UTILIZA VALOR DIFERENCIA        
 */
public enum UtilValueDif {
  NUMBER_0(0),
    NUMBER_1(1);

  private Integer value;

  UtilValueDif(Integer value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static UtilValueDif fromValue(String text) {
    for (UtilValueDif b : UtilValueDif.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
