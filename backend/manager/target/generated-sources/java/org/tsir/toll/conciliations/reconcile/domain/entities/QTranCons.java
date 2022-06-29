package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTranCons is a Querydsl query type for TranCons
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTranCons extends EntityPathBase<TranCons> {

    private static final long serialVersionUID = -1043711679L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTranCons tranCons = new QTranCons("tranCons");

    public final NumberPath<Long> codigoTranCons = createNumber("codigoTranCons", Long.class);

    public final NumberPath<Long> consecutivoTranCons = createNumber("consecutivoTranCons", Long.class);

    public final DateTimePath<java.time.LocalDateTime> fechaTranCons = createDateTime("fechaTranCons", java.time.LocalDateTime.class);

    public final NumberPath<Long> idCate = createNumber("idCate", Long.class);

    public final QFormPago idFormPago;

    public final QPlac idPlac;

    public final NumberPath<Long> idTranCons = createNumber("idTranCons", Long.class);

    public final QUsrsTurn idUsrsTurn;

    public final StringPath novedadTranCons = createString("novedadTranCons");

    public final SetPath<NoveTran, QNoveTran> noveTranCollection = this.<NoveTran, QNoveTran>createSet("noveTranCollection", NoveTran.class, QNoveTran.class, PathInits.DIRECT2);

    public final StringPath placaDetectada = createString("placaDetectada");

    public final NumberPath<Integer> resultadoValidacionDocEspc = createNumber("resultadoValidacionDocEspc", Integer.class);

    public final StringPath sentidoTranCons = createString("sentidoTranCons");

    public final StringPath signature = createString("signature");

    public final StringPath tiqueteInvias = createString("tiqueteInvias");

    public final NumberPath<Long> totalEjes = createNumber("totalEjes", Long.class);

    public final NumberPath<Long> totalIva = createNumber("totalIva", Long.class);

    public final NumberPath<Long> totalTranCons = createNumber("totalTranCons", Long.class);

    public final NumberPath<Integer> validacionDocumento = createNumber("validacionDocumento", Integer.class);

    public final NumberPath<Long> valorCateTranCons = createNumber("valorCateTranCons", Long.class);

    public QTranCons(String variable) {
        this(TranCons.class, forVariable(variable), INITS);
    }

    public QTranCons(Path<? extends TranCons> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTranCons(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTranCons(PathMetadata metadata, PathInits inits) {
        this(TranCons.class, metadata, inits);
    }

    public QTranCons(Class<? extends TranCons> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idFormPago = inits.isInitialized("idFormPago") ? new QFormPago(forProperty("idFormPago")) : null;
        this.idPlac = inits.isInitialized("idPlac") ? new QPlac(forProperty("idPlac")) : null;
        this.idUsrsTurn = inits.isInitialized("idUsrsTurn") ? new QUsrsTurn(forProperty("idUsrsTurn"), inits.get("idUsrsTurn")) : null;
    }

}

