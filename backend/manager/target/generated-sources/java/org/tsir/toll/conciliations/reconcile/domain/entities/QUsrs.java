package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUsrs is a Querydsl query type for Usrs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsrs extends EntityPathBase<Usrs> {

    private static final long serialVersionUID = 42141732L;

    public static final QUsrs usrs = new QUsrs("usrs");

    public final StringPath apellidoUsrs = createString("apellidoUsrs");

    public final StringPath claveUsrs = createString("claveUsrs");

    public final NumberPath<Long> codigoUsrs = createNumber("codigoUsrs", Long.class);

    public final StringPath estadoUsrs = createString("estadoUsrs");

    public final NumberPath<Long> idEsta = createNumber("idEsta", Long.class);

    public final NumberPath<Long> idGrupUsrs = createNumber("idGrupUsrs", Long.class);

    public final StringPath idTisc = createString("idTisc");

    public final NumberPath<Long> idUsrs = createNumber("idUsrs", Long.class);

    public final StringPath nombreUsrs = createString("nombreUsrs");

    public final DateTimePath<java.sql.Timestamp> pwdFecha = createDateTime("pwdFecha", java.sql.Timestamp.class);

    public QUsrs(String variable) {
        super(Usrs.class, forVariable(variable));
    }

    public QUsrs(Path<? extends Usrs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsrs(PathMetadata metadata) {
        super(Usrs.class, metadata);
    }

}

