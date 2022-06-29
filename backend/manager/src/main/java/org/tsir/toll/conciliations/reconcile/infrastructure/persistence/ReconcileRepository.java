package org.tsir.toll.conciliations.reconcile.infrastructure.persistence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.tsir.toll.conciliations.reconcile.domain.entities.Reconcile;
import org.tsir.toll.conciliations.reconcile.domain.entities.TranCons;
import org.tsir.toll.conciliations.reconcile.domain.entities.TranDac;

public interface ReconcileRepository extends JpaRepository<Reconcile, Long>, QuerydslPredicateExecutor<Reconcile> {

	@Query(value = "select p.idTranDac from Reconcile p where p.idTranCons in ?1")
	public List<TranDac> findTranDacByTranConsId(List<TranCons> idTranConsList);

	@Query(value = "select COUNT(p) from Reconcile p where p.dateCollection = ?1 and p.laneId = ?2 and p.turnId = cast(?3 as string) and p.reconcileStatus = ?4")
	public Long countConc(Date date, Long lane, Long turn, String status);

	@Query(value = "select p.idTranDac from Reconcile p where p.idTranCons in ?1")
	public TranDac getTranDacByTranCons(TranCons tranCons);
	
}
