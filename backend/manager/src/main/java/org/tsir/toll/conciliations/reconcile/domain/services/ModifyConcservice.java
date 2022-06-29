package org.tsir.toll.conciliations.reconcile.domain.services;

import java.util.HashMap;

import org.tsir.toll.conciliations.reconcile.domain.dto.PlacDTO;
import org.tsir.toll.conciliations.reconcile.domain.dto.ReconcileDTO;

import oracle.jdbc.driver.HAManager;

public interface ModifyConcservice {

	public HashMap<String, String>  putConc( Long code, ReconcileDTO body, Long idUsuario, String token);
}
