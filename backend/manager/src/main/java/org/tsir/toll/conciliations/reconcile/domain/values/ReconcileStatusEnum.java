package org.tsir.toll.conciliations.reconcile.domain.values;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeración de estados generales de activación:  * `N` - Sin discrepancia.  * `S` - Con Discrepancia.  * `C` - Conciliado. 
 */
public enum ReconcileStatusEnum {
  N("N"),
  
  S("S"),
  
  C("C");

  private String value;

  ReconcileStatusEnum(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ReconcileStatusEnum fromValue(String text) {
    for (ReconcileStatusEnum b : ReconcileStatusEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}