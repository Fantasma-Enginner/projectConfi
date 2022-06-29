package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLog is a Querydsl query type for Log
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLog extends EntityPathBase<Log> {

    private static final long serialVersionUID = 1350623L;

    public static final QLog log = new QLog("log");

    public final NumberPath<Long> idEsta = createNumber("idEsta", Long.class);

    public final NumberPath<Long> idLog = createNumber("idLog", Long.class);

    public final StringPath ip = createString("ip");

    public final StringPath locationLog = createString("locationLog");

    public final DateTimePath<java.util.Date> logDate = createDateTime("logDate", java.util.Date.class);

    public final StringPath logMensaje = createString("logMensaje");

    public final StringPath logNivel = createString("logNivel");

    public final StringPath logTipo = createString("logTipo");

    public final NumberPath<Long> usrs = createNumber("usrs", Long.class);

    public QLog(String variable) {
        super(Log.class, forVariable(variable));
    }

    public QLog(Path<? extends Log> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLog(PathMetadata metadata) {
        super(Log.class, metadata);
    }

}

