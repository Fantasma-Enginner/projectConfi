package org.tsir.toll.conciliations.reconcile.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.tsir.toll.conciliations.reconcile.domain.entities.DetaPago;
import org.tsir.toll.conciliations.reconcile.domain.entities.TranCons;

public interface DetaPagoRepository extends JpaRepository<DetaPago, Long>, QuerydslPredicateExecutor<DetaPago> {

	public DetaPago findByIdTran(Long idTran);
	
}
