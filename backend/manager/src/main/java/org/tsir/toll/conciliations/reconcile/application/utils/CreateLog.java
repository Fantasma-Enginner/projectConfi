package org.tsir.toll.conciliations.reconcile.application.utils;

import static org.tsir.common.api.security.Constants.SUPER_SECRET_KEY;
import static org.tsir.common.api.security.Constants.TOKEN_BEARER_PREFIX;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsir.toll.conciliations.reconcile.domain.entities.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import org.tsir.toll.conciliations.reconcile.infrastructure.persistence.LogRepository;

@Service
public class CreateLog {

	@Autowired
	private LogRepository LogDAO;

	@Autowired
	private WebClientServices webClient;

	private Logger log = LoggerFactory.getLogger(CreateLog.class);

	static final String ERROR_FILTERS = "no fue posible convertir a json la lista con los filtros de consulta";
	static final String AUTHORIZATION = "Authorization";
	static final String FILTER = "filter";

	public void insertLog(String mensaje, String tipo, Long idEsta, String token) {
		Log log = new Log();

		Long sub = null;
		if (token != null) {
			// Se procesa el token y se recupera el usuario.
			Claims claims = Jwts.parser().setSigningKey(SUPER_SECRET_KEY)
					.parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, "")).getBody();
			sub = Long.parseLong(claims.getSubject());
		}

		log.setUsrs(sub);
		log.setLogMensaje(mensaje);
		log.setLogNivel("Info");
		log.setLogTipo(tipo);
		log.setLocationLog("Web");
		log.setLogDate(new Timestamp(System.currentTimeMillis()));
		log.setIp(null);
		log.setIdEsta(idEsta);
		LogDAO.save(log);

	}

}
