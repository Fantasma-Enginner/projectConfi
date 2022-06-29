package org.tsir.toll.conciliations.reconcile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.tsir.common.api.exceptions.handler.rest.RestHandler;
import org.tsir.common.api.exceptions.handler.security.SecuredRestHandler;
import org.tsir.common.services.CommunicationsService;
import org.tsir.common.services.RegisterService;

import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@ComponentScan(basePackageClasses = { ConciliationManagerApplication.class, RestHandler.class, SecuredRestHandler.class,
		RegisterService.class, CommunicationsService.class })
@EnableJpaRepositories
@EnableDiscoveryClient
public class ConciliationManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConciliationManagerApplication.class, args);
	}

}
