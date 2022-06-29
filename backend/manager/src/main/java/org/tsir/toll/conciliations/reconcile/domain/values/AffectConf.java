package org.tsir.toll.conciliations.reconcile.domain.values;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeración de la aplicación de afecta confiabilidad:  * `0` - NO AFECTA CONFIABILIDAD.  * `1` - AFECTA CONFIABILIDAD.   
 */
public enum AffectConf {
  NUMBER_0(0),
    NUMBER_1(1);

  private Integer value;

  AffectConf(Integer value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AffectConf fromValue(String text) {
    for (AffectConf b : AffectConf.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
