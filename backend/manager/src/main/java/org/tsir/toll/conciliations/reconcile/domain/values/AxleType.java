package org.tsir.toll.conciliations.reconcile.domain.values;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeración de los tipos de ejes adicionales:  * `GRUA` - Eje adicional de vehiculos remolcados por grùa.  * `REMOLQUE` - Eje adicional de remolque.  * `ADICIONAL` - Eje adicional para vehiculos de carga.  * `AGRICOLA` - Eje adicional de vehiculos de transporte agrícola. 
 */
public enum AxleType {
  GRUA("GRUA"),
    REMOLQUE("REMOLQUE"),
    ADICIONAL("ADICIONAL"),
    AGRICOLA("AGRICOLA");

  private String value;

  AxleType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AxleType fromValue(String text) {
    for (AxleType b : AxleType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
