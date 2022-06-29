package org.tsir.toll.conciliations.reconcile.application.register;

import static org.tsir.common.modules.ResourceConstants.CONCILIATION_DOMAIN;
import static org.tsir.common.modules.ResourceConstants.SEPARATOR;
import static org.tsir.common.modules.ResourceConstants.CREATE_DISCREPANCY_MODULE;

import org.tsir.common.modules.Operation;
import org.tsir.common.modules.Registrable;

public final class DiscrepancyModule implements Registrable {
	
	public static final DiscrepancyModule INSTANCE = new DiscrepancyModule();
	
	private DiscrepancyModule() {
	}

	private static final String GETDISCREPNACY_CODE = "1";
	public static final String GETDISCREPANCY_AUTHORITY = CONCILIATION_DOMAIN + SEPARATOR + CREATE_DISCREPANCY_MODULE + SEPARATOR
			+ GETDISCREPNACY_CODE;
	public static final Operation CONCILIATION_RESOURCE = Operation.getFromAuthority("Consultar Discrepancias", GETDISCREPANCY_AUTHORITY );

	private static final String PUTDISCREPNACY_CODE = "2";
	public static final String PUTDISCREPANCY_AUTHORITY  = CONCILIATION_DOMAIN + SEPARATOR + CREATE_DISCREPANCY_MODULE + SEPARATOR
			+ PUTDISCREPNACY_CODE;
	public static final Operation RECONCILE_RESOURCE = Operation.getFromAuthority("Crear Discrepnacias", PUTDISCREPANCY_AUTHORITY);

	

}
