package org.tsir.toll.conciliations.reconcile.infrastructure.persistence;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.tsir.toll.conciliations.reconcile.domain.entities.TranDac;

public interface TranDacRepository extends JpaRepository<TranDac, Long>, QuerydslPredicateExecutor<TranDac> {

	
	
	@Query(value = "SELECT t FROM TranDac t WHERE t.idTranDac = ?1 AND t.fechaRec = ?2")
	public TranDac getByIdAndDateCollection(Long id,LocalDate fecharec);

	
	
}
