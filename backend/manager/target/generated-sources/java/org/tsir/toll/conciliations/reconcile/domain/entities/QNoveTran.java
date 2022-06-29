package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNoveTran is a Querydsl query type for NoveTran
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNoveTran extends EntityPathBase<NoveTran> {

    private static final long serialVersionUID = -684773440L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNoveTran noveTran = new QNoveTran("noveTran");

    public final NumberPath<Long> idFormPago = createNumber("idFormPago", Long.class);

    public final QNove idNove;

    public final NumberPath<Long> idNoveTran = createNumber("idNoveTran", Long.class);

    public final NumberPath<Long> idTran = createNumber("idTran", Long.class);

    public final NumberPath<Long> idTranEspc = createNumber("idTranEspc", Long.class);

    public final StringPath noRph = createString("noRph");

    public final NumberPath<Long> numeroEjesNoveTran = createNumber("numeroEjesNoveTran", Long.class);

    public final NumberPath<Long> valorNove = createNumber("valorNove", Long.class);

    public QNoveTran(String variable) {
        this(NoveTran.class, forVariable(variable), INITS);
    }

    public QNoveTran(Path<? extends NoveTran> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNoveTran(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNoveTran(PathMetadata metadata, PathInits inits) {
        this(NoveTran.class, metadata, inits);
    }

    public QNoveTran(Class<? extends NoveTran> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idNove = inits.isInitialized("idNove") ? new QNove(forProperty("idNove")) : null;
    }

}

