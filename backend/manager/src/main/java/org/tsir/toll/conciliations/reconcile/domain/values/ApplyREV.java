package org.tsir.toll.conciliations.reconcile.domain.values;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

/**
 * Enumeración de la aplicación de REV (Recaudo electronico vehicular):  * `0` - NO APLICA REV.  * `1` - SI APLICA REV.   
 */
public enum ApplyREV {
    NUMBER_0(0),
    NUMBER_1(1);

  private Integer value;

  ApplyREV(Integer value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ApplyREV fromValue(String text) {
    for (ApplyREV b : ApplyREV.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
