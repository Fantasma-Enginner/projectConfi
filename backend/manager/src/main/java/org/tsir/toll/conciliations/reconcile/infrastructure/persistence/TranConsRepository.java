package org.tsir.toll.conciliations.reconcile.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.tsir.toll.conciliations.reconcile.domain.entities.TranCons;

public interface TranConsRepository extends JpaRepository<TranCons, Long>, QuerydslPredicateExecutor<TranCons> {
	
	public TranCons getByIdTranCons(Long id);
}
