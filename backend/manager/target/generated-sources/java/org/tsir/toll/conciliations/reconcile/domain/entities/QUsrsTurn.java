package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsrsTurn is a Querydsl query type for UsrsTurn
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsrsTurn extends EntityPathBase<UsrsTurn> {

    private static final long serialVersionUID = 2078427841L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsrsTurn usrsTurn = new QUsrsTurn("usrsTurn");

    public final NumberPath<Long> baseUsrsTurn = createNumber("baseUsrsTurn", Long.class);

    public final NumberPath<Long> codigoTurnoUsrs = createNumber("codigoTurnoUsrs", Long.class);

    public final DateTimePath<java.time.LocalDateTime> fechaIngresoUsrs = createDateTime("fechaIngresoUsrs", java.time.LocalDateTime.class);

    public final DatePath<java.time.LocalDate> fechaRec = createDate("fechaRec", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> fechaSalidaUsrs = createDateTime("fechaSalidaUsrs", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> finTurn = createDateTime("finTurn", java.time.LocalDateTime.class);

    public final NumberPath<Long> idTranFinal = createNumber("idTranFinal", Long.class);

    public final NumberPath<Long> idTranInicio = createNumber("idTranInicio", Long.class);

    public final NumberPath<Long> idUsrsTurn = createNumber("idUsrsTurn", Long.class);

    public final DateTimePath<java.time.LocalDateTime> inicioTurn = createDateTime("inicioTurn", java.time.LocalDateTime.class);

    public final StringPath mantenimiento = createString("mantenimiento");

    public final NumberPath<Long> node = createNumber("node", Long.class);

    public final QUsrs usrs;

    public QUsrsTurn(String variable) {
        this(UsrsTurn.class, forVariable(variable), INITS);
    }

    public QUsrsTurn(Path<? extends UsrsTurn> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsrsTurn(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsrsTurn(PathMetadata metadata, PathInits inits) {
        this(UsrsTurn.class, metadata, inits);
    }

    public QUsrsTurn(Class<? extends UsrsTurn> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.usrs = inits.isInitialized("usrs") ? new QUsrs(forProperty("usrs")) : null;
    }

}

