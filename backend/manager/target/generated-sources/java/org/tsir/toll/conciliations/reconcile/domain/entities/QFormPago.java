package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFormPago is a Querydsl query type for FormPago
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFormPago extends EntityPathBase<FormPago> {

    private static final long serialVersionUID = -1849617982L;

    public static final QFormPago formPago = new QFormPago("formPago");

    public final NumberPath<Long> idFormPago = createNumber("idFormPago", Long.class);

    public final StringPath nombreFormPago = createString("nombreFormPago");

    public QFormPago(String variable) {
        super(FormPago.class, forVariable(variable));
    }

    public QFormPago(Path<? extends FormPago> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFormPago(PathMetadata metadata) {
        super(FormPago.class, metadata);
    }

}

