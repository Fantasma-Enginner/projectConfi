package org.tsir.toll.conciliations.reconcile.domain.services;

import java.awt.color.ProfileDataException;
import java.util.List;
import java.util.Map;

import javax.servlet.UnavailableException;


import org.tsir.toll.conciliations.reconcile.domain.entities.Reconcile;

public interface ReconcileService {
		
		public List<Reconcile> getReconcile(Map<String, String> filter,Map<String, Integer> paging);
		
		

}
