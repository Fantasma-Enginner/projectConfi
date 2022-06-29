package org.tsir.toll.conciliations.reconcile.application.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.tsir.toll.conciliations.reconcile.domain.dto.LaneDTO;
import org.tsir.toll.conciliations.reconcile.domain.dto.UserDTO;
import org.tsir.common.services.parameter.dto.ParameterDTO;

import org.tsir.toll.conciliations.reconcile.domain.dto.PlacDTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class WebClientServices {
	
	private ObjectMapper objectMapper = new ObjectMapper();

	private Logger log = LoggerFactory.getLogger(WebClientServices.class);

	static final String ERROR_FILTERS = "no fue posible convertir a json la lista con los filtros de consulta";
	static final String AUTHORIZATION = "Authorization";
	static final String FILTER = "filter";

//	private ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
//			.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(8 * 1024 * 1024)).build();
//	

	// Permite traer el codigo de la estación por medio del ID del carril
	public List<LaneDTO> getCodStationForLane(Long codeLane, String token) {
		//log.info("Codigo del carril para TOLLS desde el metodo: "+ codeLane);
		Map<String, String> filters = new HashMap<>();
		filters.put("LABEL", codeLane.toString());
		String jsonString = null;
		ObjectMapper mapper = new ObjectMapper();
		// log.info("Cod Carril = "+codeLane);
		try {
			jsonString = mapper.writeValueAsString(filters);
		} catch (JsonProcessingException e) {
			log.error(ERROR_FILTERS, e);
		}
		log.info("jsonString = " + jsonString);
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromUriString("http://localhost:8760/tolls-manager/api/v1/tolls/lanes").queryParam(FILTER, jsonString);
		UriComponents uriComponent = builder.build().encode();
		return WebClient.create().get().uri(uriComponent.toUri())
				.headers(httpHeaders -> httpHeaders.add(AUTHORIZATION, token)).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(new ParameterizedTypeReference<List<LaneDTO>>() {
				}).block();
	}

	// Permite traer la información de un usuario por medio del id
	public List<UserDTO> getUserForId(Long idUsrs, String token) {
		Map<String, String> filters = new HashMap<>();
		filters.put("CODE", idUsrs.toString()); //Esta como CODE pero la API filtra por el ID_USRS
		String jsonString = null;
		ObjectMapper mapper = new ObjectMapper();
		// log.info("Cod usuario = "+codeUsrs);
		try {
			jsonString = mapper.writeValueAsString(filters);
		} catch (JsonProcessingException e) {
			log.error(ERROR_FILTERS, e);
		}
		log.info("jsonString = " + jsonString);
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromUriString("http://localhost:8760/settings-users/api/v1/users/").queryParam(FILTER, jsonString);
		UriComponents uriComponent = builder.build().encode();
		return WebClient.create().get().uri(uriComponent.toUri())
				.headers(httpHeaders -> httpHeaders.add(AUTHORIZATION, token)).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(new ParameterizedTypeReference<List<UserDTO>>() {
				}).block();
	}
	

		public List<ParameterDTO> getParameter(Integer idEsta, String token) {
			return WebClient.create("http://localhost:8760/management-parameters/api/v1/parameter?stationId="+ idEsta).get().headers(httpHeaders -> httpHeaders.add(AUTHORIZATION, token))
//					.uri(uriBuilder -> uriBuilder.path("/ParametersManager/api/v1/parameter/"))
//							.queryParam("stationId", idEsta).build()
					.accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<ParameterDTO>>() {
					}).block();
		}
		
		public List<ParameterDTO> getParameterByName(String nombre, String token) {
			return WebClient.create("http://localhost:8760/management-parameters/api/v1/parameterbyNombre?nombre=" + nombre).get().headers(httpHeaders -> httpHeaders.add(AUTHORIZATION, token))
//					.uri(uriBuilder -> uriBuilder.path("/ParametersManager/api/v1/parameter/"))
//							.queryParam("stationId", idEsta).build()
					.accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<ParameterDTO>>() {
					}).block();
		}
		

		
		
		
		
		//------------------------------ servicio para peaje sombra : buscar placas ---------------------------
		
		
		
		public List<PlacDTO> findPlates(Map<String, String> mapFilter, String token) {
			try {
				log.info(mapFilter.toString());
				log.info("map "+ mapFilter);
				
				
				String json = objectMapper.writeValueAsString(mapFilter);
	            System.out.println(json);
				
				
				UriComponentsBuilder builder = UriComponentsBuilder
						.fromUriString("http://localhost:8760/transactions-shadowtoll/api/v1/plac").queryParam(FILTER, json);
				UriComponents uriComponent = builder.build().encode();
				return WebClient.create()
						.get()
						.uri(uriComponent.toUri())
						.headers(httpHeaders -> httpHeaders.add(AUTHORIZATION, token))
						.accept(MediaType.APPLICATION_JSON)
						.retrieve()
						.bodyToMono(new ParameterizedTypeReference<List<PlacDTO>>() {
						}).block();
			} catch (Exception e) {
				return Collections.emptyList();
			}
		}
		
		
		//------------------------------ servicio para peaje sombra : insertar placa ---------------------------		

		public Void CreatePlate(PlacDTO toCreate, String token) {
			try {
				UriComponentsBuilder builder = UriComponentsBuilder
						.fromUriString("http://localhost:8760/transactions-shadowtoll/api/v1/plac");
				UriComponents uriComponent = builder.build().encode();
				return WebClient.create()
						.post()
						.uri(uriComponent.toUri())
						.headers(httpHeaders -> httpHeaders.add(AUTHORIZATION, token))
						.bodyValue(toCreate)
						.accept(MediaType.APPLICATION_JSON)
						.retrieve()
						.bodyToMono(Void.class)
						.block();
			} catch (Exception e) {
				System.out.println("--------Unable to create a plate-------");;
			}
			return null;
		}
		
		
		
		
		
		

}
