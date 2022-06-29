package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReconcile is a Querydsl query type for Reconcile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReconcile extends EntityPathBase<Reconcile> {

    private static final long serialVersionUID = 1985905577L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReconcile reconcile = new QReconcile("reconcile");

    public final NumberPath<Double> adjustValue = createNumber("adjustValue", Double.class);

    public final StringPath codUsrs = createString("codUsrs");

    public final NumberPath<Long> codUsrsConc = createNumber("codUsrsConc", Long.class);

    public final NumberPath<Double> collectValue = createNumber("collectValue", Double.class);

    public final DatePath<java.sql.Date> dateCollection = createDate("dateCollection", java.sql.Date.class);

    public final DateTimePath<java.sql.Timestamp> fechaTran = createDateTime("fechaTran", java.sql.Timestamp.class);

    public final StringPath idPlac = createString("idPlac");

    public final QTranCons idTranCons;

    public final QTranDac idTranDac;

    public final StringPath idUsrsResponsable = createString("idUsrsResponsable");

    public final NumberPath<Long> laneId = createNumber("laneId", Long.class);

    public final QNoveConc noveconc;

    public final NumberPath<Long> reconcileCategory = createNumber("reconcileCategory", Long.class);

    public final DateTimePath<java.sql.Timestamp> reconcileDateTime = createDateTime("reconcileDateTime", java.sql.Timestamp.class);

    public final NumberPath<Long> reconcileId = createNumber("reconcileId", Long.class);

    public final StringPath reconcileStatus = createString("reconcileStatus");

    public final NumberPath<Long> reconcileValue = createNumber("reconcileValue", Long.class);

    public final StringPath sentidoConc = createString("sentidoConc");

    public final NumberPath<Long> turnId = createNumber("turnId", Long.class);

    public QReconcile(String variable) {
        this(Reconcile.class, forVariable(variable), INITS);
    }

    public QReconcile(Path<? extends Reconcile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReconcile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReconcile(PathMetadata metadata, PathInits inits) {
        this(Reconcile.class, metadata, inits);
    }

    public QReconcile(Class<? extends Reconcile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idTranCons = inits.isInitialized("idTranCons") ? new QTranCons(forProperty("idTranCons"), inits.get("idTranCons")) : null;
        this.idTranDac = inits.isInitialized("idTranDac") ? new QTranDac(forProperty("idTranDac"), inits.get("idTranDac")) : null;
        this.noveconc = inits.isInitialized("noveconc") ? new QNoveConc(forProperty("noveconc"), inits.get("noveconc")) : null;
    }

}

