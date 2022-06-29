package org.tsir.toll.conciliations.reconcile.infrastructure.config;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.tsir.common.utils.ObjectUtilsVP;
import org.tsir.toll.conciliations.reconcile.application.register.RegisterProductionTask;
import org.tsir.common.domain.TimeBasedGenerator;
import org.tsir.common.modules.TaskRegistrable;

import org.tsir.common.utils.InetUtilsVP;
import org.tsir.common.utils.ObjectUtilsVP;
import org.tsir.common.services.CommunicationsService;
import org.tsir.common.services.ParameterService;
import org.tsir.common.services.RegisterService;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ApplicationConfig {

	public static final String API_VERSION = "1.0.1";
	public static final String IMPLEMENTATION_VERSION = "1.0.1.200109";
	public static final String MODULE_DESCRIPTION = "Servicios para la gestión del sistema de conciliaciones.";
	public static final String MODULE_NAME = "ConciliationManager";
	
	@Value("${vialplus.platform.node.toll}")
	public int codeToll;
	
	@Value("${vialplus.platform.node.lane}")
	public int codeLane;

	@PostConstruct
	private void loadIdentifierGenerator() {
		TimeBasedGenerator.setNodeToll(codeToll);
		TimeBasedGenerator.setNodeLane(codeLane);
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder getWebClient() {
		return ObjectUtilsVP.getClient();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(MODULE_NAME).description(MODULE_DESCRIPTION).license("")
				.licenseUrl("http://unlicense.org").termsOfServiceUrl("").version(API_VERSION)
				.contact(new Contact("", "", "")).build();
	}

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("org.tsir.toll.conciliations.reconcile.application.presentation"))
				.build().directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class).apiInfo(apiInfo())
				.securitySchemes(
						Collections.singletonList(new ApiKey("bearerAuth", "Authorization", In.HEADER.name())));
	}

	@Bean()
	public RegisterService getRegisterService() {
		RegisterService service = new RegisterService();
		service.setHost("platform-manager");
		return service;
	}
	
	@Bean
	public CommunicationsService getCommunicationService() {
	CommunicationsService communicationsService = new CommunicationsService();
	communicationsService.setHost("communications-integration");
	return communicationsService;
	}
	
	@Bean
	public ParameterService getParameterService() {
		ParameterService parameterService = new ParameterService();
		parameterService.setHost("management-parameters");
		return parameterService;
	}

	@Bean
	@Profile("prod")
	public TaskRegistrable getRegisterProductionTask() {
		return new RegisterProductionTask();
	}

	@Bean
	@Profile("dev")
	public TaskRegistrable getRegisterDevelopTask() {
		//return () -> {
		//};
		// return new RegisterProductionTask();Esta linea se utiliza para realizar
		// pruebas del Register en ambiente de desarrollo y se debe comentarear las 2
		// lineas anteriores
		return new RegisterProductionTask();
	}

}
