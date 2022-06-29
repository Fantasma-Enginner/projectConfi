package org.tsir.toll.conciliations.reconcile.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tsir.toll.conciliations.reconcile.domain.entities.Reconcile;

public interface ModifiConcUpdateRepository extends JpaRepository<Reconcile, Long> {

}
