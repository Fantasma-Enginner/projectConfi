package org.tsir.toll.conciliations.reconcile.infrastructure.persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.tsir.toll.conciliations.reconcile.domain.entities.CierDia;
import org.tsir.toll.conciliations.reconcile.domain.entities.Reconcile;

public interface CierDiaRepository extends JpaRepository<CierDia, Long>, QuerydslPredicateExecutor<CierDia> {

	
	@Query("SELECT cierdia FROM CierDia cierdia WHERE fechaCierre = ?1")
	public CierDia cierreporfecha(LocalDate validardate);
	
	
}
