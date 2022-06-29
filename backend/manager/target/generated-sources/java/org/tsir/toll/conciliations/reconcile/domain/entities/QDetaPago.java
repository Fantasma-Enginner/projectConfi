package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDetaPago is a Querydsl query type for DetaPago
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDetaPago extends EntityPathBase<DetaPago> {

    private static final long serialVersionUID = -1279197524L;

    public static final QDetaPago detaPago = new QDetaPago("detaPago");

    public final NumberPath<Long> idDetaPago = createNumber("idDetaPago", Long.class);

    public final NumberPath<Long> idFormPago = createNumber("idFormPago", Long.class);

    public final NumberPath<Long> idTiqu = createNumber("idTiqu", Long.class);

    public final NumberPath<Long> idTran = createNumber("idTran", Long.class);

    public final NumberPath<Long> idTranEpay = createNumber("idTranEpay", Long.class);

    public final NumberPath<Long> idTranEspc = createNumber("idTranEspc", Long.class);

    public final NumberPath<Long> idTranTisc = createNumber("idTranTisc", Long.class);

    public final NumberPath<java.math.BigDecimal> numeroDetaPago = createNumber("numeroDetaPago", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> valorDetaPago = createNumber("valorDetaPago", java.math.BigDecimal.class);

    public QDetaPago(String variable) {
        super(DetaPago.class, forVariable(variable));
    }

    public QDetaPago(Path<? extends DetaPago> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDetaPago(PathMetadata metadata) {
        super(DetaPago.class, metadata);
    }

}

