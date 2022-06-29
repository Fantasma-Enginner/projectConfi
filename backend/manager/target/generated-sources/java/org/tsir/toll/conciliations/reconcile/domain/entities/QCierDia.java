package org.tsir.toll.conciliations.reconcile.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCierDia is a Querydsl query type for CierDia
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCierDia extends EntityPathBase<CierDia> {

    private static final long serialVersionUID = -2074535164L;

    public static final QCierDia cierDia = new QCierDia("cierDia");

    public final NumberPath<Integer> estado = createNumber("estado", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> fechaCerrado = createDateTime("fechaCerrado", java.time.LocalDateTime.class);

    public final DatePath<java.time.LocalDate> fechaCierre = createDate("fechaCierre", java.time.LocalDate.class);

    public final NumberPath<Long> idCierDia = createNumber("idCierDia", Long.class);

    public final NumberPath<Long> idEsta = createNumber("idEsta", Long.class);

    public final NumberPath<Long> idUsrs = createNumber("idUsrs", Long.class);

    public final NumberPath<Long> numReversado = createNumber("numReversado", Long.class);

    public final NumberPath<Long> stateClosingId = createNumber("stateClosingId", Long.class);

    public final NumberPath<Long> vlrOtros = createNumber("vlrOtros", Long.class);

    public final NumberPath<Long> vlrPico = createNumber("vlrPico", Long.class);

    public final NumberPath<Long> vlrRecargas = createNumber("vlrRecargas", Long.class);

    public final NumberPath<Long> vlrRecaudo = createNumber("vlrRecaudo", Long.class);

    public final NumberPath<Long> vlrTotal = createNumber("vlrTotal", Long.class);

    public QCierDia(String variable) {
        super(CierDia.class, forVariable(variable));
    }

    public QCierDia(Path<? extends CierDia> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCierDia(PathMetadata metadata) {
        super(CierDia.class, metadata);
    }

}

