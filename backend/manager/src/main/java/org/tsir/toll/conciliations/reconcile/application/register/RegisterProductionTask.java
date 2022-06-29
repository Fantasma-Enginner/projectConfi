package org.tsir.toll.conciliations.reconcile.application.register;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.tsir.common.modules.Module;
import org.tsir.common.modules.TaskRegistrable;
import org.tsir.common.services.ParameterService;
import org.tsir.common.services.RegisterService;

public class RegisterProductionTask implements TaskRegistrable {

	private Logger logger = LoggerFactory.getLogger(RegisterProductionTask.class);

	@Autowired
	private RegisterService service;
	


	@Override
	public void register() {
		List<String> results = new ArrayList<>();
		results.addAll(service.registerModule(DiscrepancyModule.INSTANCE, "/creatediscrepancy-app/main.js"));
		logger.info("Registration Module Create Discrepanciy: \n{}", results);

	}

}
