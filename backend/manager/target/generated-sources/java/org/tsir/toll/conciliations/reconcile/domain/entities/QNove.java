package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QNove is a Querydsl query type for Nove
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNove extends EntityPathBase<Nove> {

    private static final long serialVersionUID = 41929461L;

    public static final QNove nove = new QNove("nove");

    public final NumberPath<Long> codigoNove = createNumber("codigoNove", Long.class);

    public final NumberPath<Long> idNove = createNumber("idNove", Long.class);

    public final NumberPath<Long> idTipoNove = createNumber("idTipoNove", Long.class);

    public final ArrayPath<byte[], Byte> imagenNove = createArray("imagenNove", byte[].class);

    public final StringPath nombreImpresion = createString("nombreImpresion");

    public final StringPath nombreNove = createString("nombreNove");

    public final StringPath referencia = createString("referencia");

    public final NumberPath<Long> valorNove = createNumber("valorNove", Long.class);

    public QNove(String variable) {
        super(Nove.class, forVariable(variable));
    }

    public QNove(Path<? extends Nove> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNove(PathMetadata metadata) {
        super(Nove.class, metadata);
    }

}

