package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlac is a Querydsl query type for Plac
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlac extends EntityPathBase<Plac> {

    private static final long serialVersionUID = 41985507L;

    public static final QPlac plac = new QPlac("plac");

    public final NumberPath<Long> chequeoCatePlac = createNumber("chequeoCatePlac", Long.class);

    public final StringPath color = createString("color");

    public final DateTimePath<java.sql.Timestamp> fechaActualizacionPlac = createDateTime("fechaActualizacionPlac", java.sql.Timestamp.class);

    public final NumberPath<Long> idCate = createNumber("idCate", Long.class);

    public final StringPath idPlac = createString("idPlac");

    public final StringPath marca = createString("marca");

    public final NumberPath<Long> modelo = createNumber("modelo", Long.class);

    public final NumberPath<Integer> regCatPlac = createNumber("regCatPlac", Integer.class);

    public QPlac(String variable) {
        super(Plac.class, forVariable(variable));
    }

    public QPlac(Path<? extends Plac> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlac(PathMetadata metadata) {
        super(Plac.class, metadata);
    }

}

