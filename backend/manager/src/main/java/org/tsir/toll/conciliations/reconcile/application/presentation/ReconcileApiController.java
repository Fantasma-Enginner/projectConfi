	package org.tsir.toll.conciliations.reconcile.application.presentation;

import org.tsir.toll.conciliations.reconcile.infrastructure.api.ApiMessage;
import org.tsir.toll.conciliations.reconcile.infrastructure.api.ReconcileApi;
import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.DetaPagoRepository;
import org.tsir.toll.conciliations.reconcile.application.MappingFactory;
import org.tsir.toll.conciliations.reconcile.application.register.DiscrepancyModule;

import org.tsir.toll.conciliations.reconcile.domain.dto.LaneDTO;
import org.tsir.toll.conciliations.reconcile.domain.dto.ReconcileDTO;
import org.tsir.toll.conciliations.reconcile.domain.entities.DetaPago;
import org.tsir.toll.conciliations.reconcile.domain.entities.Reconcile;

import org.tsir.toll.conciliations.reconcile.domain.services.ModifyConcservice;
import org.tsir.toll.conciliations.reconcile.domain.services.ReconcileService;

import org.tsir.toll.conciliations.reconcile.application.utils.WebClientServices;
import org.tsir.common.api.RequestHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.annotation.PostConstruct;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;

import static org.tsir.common.api.security.Constants.HEADER_AUTHORIZACION_KEY;
import static org.tsir.common.api.security.Constants.SUPER_SECRET_KEY;
import static org.tsir.common.api.security.Constants.TOKEN_BEARER_PREFIX;

import java.awt.color.ProfileDataException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping({ "/api/v1" })
public class ReconcileApiController extends RequestHandler implements ReconcileApi {

	@Autowired
	private ReconcileService reconcileService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private WebClientServices webClient;

	@Autowired
	private ModifyConcservice modifyConcservice;
	
	@Autowired
	private MappingFactory mapper;
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(ReconcileApiController.class);
	@Autowired
	private final HttpServletRequest request;

	@Autowired
	public ReconcileApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.request = request;
		this.objectMapper = objectMapper;
	}

	@PostConstruct
	private void loadMapping() {
		mapper.loadReconcileMapping();
	}

	@Override
	//@PreAuthorize("hasAuthority('" + DiscrepancyModule.GETDISCREPANCY_AUTHORITY + "')")
	public ResponseEntity<List<ReconcileDTO>> findStepsWithoutDiscrepancy(@Valid Map<String, String> filter,@Valid Map<String, Integer> paging, @Valid Map<String, String> sorting) {
		String tokenInt = getRequest().get().getHeader("Authorization");
		List<ReconcileDTO> body;
		List<Reconcile> lsMod = reconcileService.getReconcile(filter,paging);

		body = lsMod.stream().map(mapper::mapReconcileDTO).collect(Collectors.toList());

		// Comunicacion con API Tolls
		List<LaneDTO> lanes = null;
		if (!lsMod.isEmpty()) {

			try {
				lanes = webClient.getCodStationForLane(lsMod.get(0).getLaneId(), tokenInt);
			} catch (Exception e) {
				log.error("ERROR!! al comunicarse con el servicio de obtener el código de la estacion de la API TOLLS",
						e);

			}

			List<ReconcileDTO> body2 = new ArrayList<ReconcileDTO>();
			if (lanes.size() > 0) {
				for (ReconcileDTO obj : body) {
					obj.setStationCode(lanes.get(0).getToll());
					body2.add(obj);
				}
				body = body2;
			}
		}
		

		return ResponseEntity.ok(body);

	}

	@Override
	//@PreAuthorize("hasAuthority('" + DiscrepancyModule.PUTDISCREPANCY_AUTHORITY + "')")
	public ResponseEntity<HashMap<String, String>> createDiscrepancy(Long code, @Valid ReconcileDTO body) {
		String token = getRequest().get().getHeader("Authorization");
		if(getRequest().isPresent()) {
			token= getRequest().get().getHeader("Authorization");
		}
		Long idUsuario = null;
		if (token != null) {
			// Se procesa el token y se recupera el usuario.
			Claims claims = Jwts.parser().setSigningKey(SUPER_SECRET_KEY)
					.parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, "")).getBody();
			idUsuario = Long.parseLong(claims.getSubject());
			
		}
        HashMap<String, String> respuesta = modifyConcservice.putConc(code, body,idUsuario,token);
 		 
		if (respuesta.isEmpty()) {
			return new ResponseEntity<HashMap<String, String>>(respuesta,HttpStatus.CREATED);
		}
		return new ResponseEntity<HashMap<String, String>>(respuesta,HttpStatus.BAD_REQUEST);
	
	}

}
