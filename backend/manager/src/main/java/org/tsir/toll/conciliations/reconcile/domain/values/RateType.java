package org.tsir.toll.conciliations.reconcile.domain.values;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeración de los tipos de tarifa de un peaje:  * `PLENA` - Tarifa plena de acuerdo a la clasificación vehicular de cada peaje.  * `ESPECIAL1` - Tarifa especial tipo 1 o con beneficio diferencial.  * `ESPECIAL2` - Tarifa especial tipo 2 o con beneficio diferencial.  * `ESPECIAL3` - Tarifa especial tipo 3 o con beneficio diferencial.  * `EXENTA` - Vehículos oficiales. 
 */
public enum RateType {
  PLENA("PLENA"),
    ESPECIAL1("ESPECIAL1"),
    ESPECIAL2("ESPECIAL2"),
    ESPECIAL3("ESPECIAL3"),
    EXENTA("EXENTA");

  private String value;

  RateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static RateType fromValue(String text) {
    for (RateType b : RateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
