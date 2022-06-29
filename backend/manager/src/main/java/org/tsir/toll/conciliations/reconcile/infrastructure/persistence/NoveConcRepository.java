package org.tsir.toll.conciliations.reconcile.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.tsir.toll.conciliations.reconcile.domain.entities.NoveConc;

public interface NoveConcRepository extends JpaRepository<NoveConc, Long>, QuerydslPredicateExecutor<NoveConc> {

	
	
}
