package org.tsir.toll.conciliations.reconcile.domain.values;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeración de los tipos de tarifa de un peaje:  * `CERRADO` - El carril no se encuentra en operación.  * `MANUAL` - El carril se encuentra en operación con recepción de medios de pago manuales en el cual debe haber presencia de un recolector.  * `DEDICADO` - El carril se encuentra en operación con recepción de medios de pago que permite el paso automatico y en el cual no se requiere presencia de un recolector.  * `MIXTO` - El carril se encuentra en operación recibiendo medios de pago tanto manuales como automaticos.  * `AEREO` - El carril se encuentra en operación con apoyo de casetas aéreas; en este modo hay dos o mas casetas de atencion en la misma linea del carril. En este modo solo se reciben medios de pago manuales. 
 */
public enum OperationMode {
  CERRADO("CERRADO"),
    MANUAL("MANUAL"),
    DEDICADO("DEDICADO"),
    MIXTO("MIXTO"),
    AEREO("AEREO");

  private String value;

  OperationMode(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OperationMode fromValue(String text) {
    for (OperationMode b : OperationMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
