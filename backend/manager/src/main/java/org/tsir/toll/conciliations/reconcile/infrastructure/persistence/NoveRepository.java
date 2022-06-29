package org.tsir.toll.conciliations.reconcile.infrastructure.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.tsir.toll.conciliations.reconcile.domain.entities.Nove;

public interface NoveRepository extends JpaRepository<Nove, Long>, QuerydslPredicateExecutor<Nove> {

	public Nove findByIdNove(Long idNove);
	
	
}
