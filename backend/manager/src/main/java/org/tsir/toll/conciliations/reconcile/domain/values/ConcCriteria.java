package org.tsir.toll.conciliations.reconcile.domain.values;

import java.util.Arrays;

import org.springframework.util.ObjectUtils;
import org.tsir.common.api.exceptions.DataTypeCriteriaException;
import org.tsir.common.api.exceptions.NotSupportCriteriaException;

public enum ConcCriteria {

	CODE_KEY("CODE"),

	NAME_KEY("NAME"),

	STATE_KEY("STATE");

	private ConcCriteria(String key) {
		this.key = key;
	}

	private String key;

	public String getKey() {
		return key;
	}

	public static ConcCriteria fromKey(String key) {
		if (ObjectUtils.isEmpty(key)) {
			throw new DataTypeCriteriaException("Perfil/Grupo de Usuario", key,
					Arrays.toString(ConcCriteria.values()));
		}
		for (ConcCriteria pc : ConcCriteria.values()) {
			if (pc.getKey().equals(key)) {
				return pc;
			}
		}
		throw new NotSupportCriteriaException("Perfil/Grupo de Usuario", key);
	}
}
