package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNoveConc is a Querydsl query type for NoveConc
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNoveConc extends EntityPathBase<NoveConc> {

    private static final long serialVersionUID = -685282378L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNoveConc noveConc = new QNoveConc("noveConc");

    public final DatePath<java.util.Date> fecha = createDate("fecha", java.util.Date.class);

    public final NumberPath<Long> idConcCruz = createNumber("idConcCruz", Long.class);

    public final NumberPath<Long> idNove = createNumber("idNove", Long.class);

    public final NumberPath<Long> idNoveConc = createNumber("idNoveConc", Long.class);

    public final QReconcile reconcileId;

    public QNoveConc(String variable) {
        this(NoveConc.class, forVariable(variable), INITS);
    }

    public QNoveConc(Path<? extends NoveConc> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNoveConc(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNoveConc(PathMetadata metadata, PathInits inits) {
        this(NoveConc.class, metadata, inits);
    }

    public QNoveConc(Class<? extends NoveConc> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reconcileId = inits.isInitialized("reconcileId") ? new QReconcile(forProperty("reconcileId"), inits.get("reconcileId")) : null;
    }

}

