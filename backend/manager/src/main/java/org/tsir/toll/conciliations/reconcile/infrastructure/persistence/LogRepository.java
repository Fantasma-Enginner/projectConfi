package org.tsir.toll.conciliations.reconcile.infrastructure.persistence;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.tsir.toll.conciliations.reconcile.domain.entities.Log;

public interface LogRepository extends JpaRepository<Log, Long>, QuerydslPredicateExecutor<Log> {

	
	
}
