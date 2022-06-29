package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTranDac is a Querydsl query type for TranDac
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTranDac extends EntityPathBase<TranDac> {

    private static final long serialVersionUID = 381974390L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTranDac tranDac = new QTranDac("tranDac");

    public final StringPath codigoTurn = createString("codigoTurn");

    public final NumberPath<Long> consecutive = createNumber("consecutive", Long.class);

    public final NumberPath<Long> ejesDoblesTranDac = createNumber("ejesDoblesTranDac", Long.class);

    public final NumberPath<Long> ejesTranDac = createNumber("ejesTranDac", Long.class);

    public final DatePath<java.time.LocalDate> fechaRec = createDate("fechaRec", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> fechaRecTranDac = createDateTime("fechaRecTranDac", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> fechaTranDac = createDateTime("fechaTranDac", java.time.LocalDateTime.class);

    public final NumberPath<Long> idCarr = createNumber("idCarr", Long.class);

    public final NumberPath<Long> idCate = createNumber("idCate", Long.class);

    public final NumberPath<Long> idTranDac = createNumber("idTranDac", Long.class);

    public final QUsrs idUsrs;

    public final StringPath mantenimiento = createString("mantenimiento");

    public final StringPath receiptData = createString("receiptData");

    public final QReconcile reconcilie;

    public final StringPath sentidoTranDac = createString("sentidoTranDac");

    public final StringPath simulacion = createString("simulacion");

    public final StringPath violacion = createString("violacion");

    public QTranDac(String variable) {
        this(TranDac.class, forVariable(variable), INITS);
    }

    public QTranDac(Path<? extends TranDac> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTranDac(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTranDac(PathMetadata metadata, PathInits inits) {
        this(TranDac.class, metadata, inits);
    }

    public QTranDac(Class<? extends TranDac> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idUsrs = inits.isInitialized("idUsrs") ? new QUsrs(forProperty("idUsrs")) : null;
        this.reconcilie = inits.isInitialized("reconcilie") ? new QReconcile(forProperty("reconcilie"), inits.get("reconcilie")) : null;
    }

}

