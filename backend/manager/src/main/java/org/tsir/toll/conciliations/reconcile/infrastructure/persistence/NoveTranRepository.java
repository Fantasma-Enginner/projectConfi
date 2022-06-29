package org.tsir.toll.conciliations.reconcile.infrastructure.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.tsir.toll.conciliations.reconcile.domain.entities.NoveTran;

public interface NoveTranRepository extends JpaRepository<NoveTran, Long>, QuerydslPredicateExecutor<NoveTran> {

	public List<NoveTran> findByIdTranAndNoRph(Long idTran, String noRph);
	public List<NoveTran> findByIdTran(Long idTran);
	
	
}
