------------------------------------------------------------------------
--- Table: PLAC
--- Table: Tabla que almacena el registro de placas de vehiculos
------------------------------------------------------------------------
do $$
declare
v_count integer;
begin

-----------------------------------------------------------------
-- Table: conc
-- Tabla  para que almacena las conciliaciones
-----------------------------------------------------------------
	 
     SELECT count(1) INTO V_COUNT from information_schema.tables where table_name = 'conc';
	 IF V_COUNT = 0 THEN
	 EXECUTE('
CREATE TABLE IF NOT EXISTS conc
(
    id_conc                bigint NOT NULL,
    id_tran_dac            bigint,
    id_tran_cons           bigint,
    id_cate                bigint NOT NULL,
    valor_real_conc        bigint,
    valor_recaudado_conc   bigint, 
    fecha_tran             timestamp without time zone,
    fecha_conc             timestamp without time zone,
    sentido_conc           character varying(1) COLLATE pg_catalog."default",
    ejes_conc              bigint,
    ejes_dobles_conc       bigint,
    discrepancia_conc      character varying(1) COLLATE pg_catalog."default",
    diferencia_conc        bigint,
    id_usrs_responsable    character varying(1) COLLATE pg_catalog."default",
    id_usrs_conciliador    bigint,
    est_verificado_conc    character varying(1) COLLATE pg_catalog."default",
    id_usrs_verificador    bigint,
    fecha_rec              timestamp without time zone,
    code_turn              character varying(1) COLLATE pg_catalog."default",
    id_carr                bigint,
    conc_state             character varying(1) COLLATE pg_catalog."default",
    id_state_conc          bigint,
    cod_usrs               character varying(1) COLLATE pg_catalog."default",
    date_conc              timestamp without time zone,
    id_plac                character varying(1) COLLATE pg_catalog."default",
	
    CONSTRAINT cier_dia_pkey PRIMARY KEY(id_conc)
	
	
	
);');

EXECUTE ('COMMENT ON COLUMN        conc.id_conc
    IS ''Llave primaria''');

EXECUTE('COMMENT ON COLUMN         conc.id_tran_dac
    IS ''Id Tran Dac''');
	
EXECUTE ('COMMENT ON COLUMN        conc.id_tran_cons
    IS ''Id Tran cons''');

EXECUTE ('COMMENT ON COLUMN        conc.id_cate
    IS ''Identificador de la categoria''');	

EXECUTE('COMMENT ON COLUMN         conc.valor_real_conc
    IS ''Conc Valor Real''');

EXECUTE ('COMMENT ON COLUMN        conc.valor_recaudado_conc
    IS ''Conc Valor Recaudado''');
	
EXECUTE ('COMMENT ON COLUMN        conc.fecha_tran
    IS ''Conc Fecha Tran''');
	
EXECUTE ('COMMENT ON COLUMN        conc.fecha_conc
    IS ''Conc Fecha Conc''');
	
	
EXECUTE ('COMMENT ON COLUMN       conc.sentido_conc
    IS ''Sentido Conc''');
	
	
EXECUTE ('COMMENT ON COLUMN       conc.ejes_conc
    IS ''Ejes Conc ''');
	
	
EXECUTE ('COMMENT ON COLUMN      conc.ejes_dobles_conc 
    IS ''Conc Ejes Dobles''');

EXECUTE ('COMMENT ON COLUMN      conc.discrepancia_conc 
    IS ''Conc Discrepancia Conc''');

EXECUTE ('COMMENT ON COLUMN      conc.diferencia_conc 
    IS ''Conc Diferencia Conc''');

EXECUTE ('COMMENT ON COLUMN      conc.id_usrs_responsable 
    IS ''Identificador Usuario Responsable''');

EXECUTE ('COMMENT ON COLUMN      conc.id_usrs_conciliador 
    IS ''Identificador Usuario Conciliador''');

EXECUTE ('COMMENT ON COLUMN      conc.est_verificado_conc
    IS ''Conc Estado Verificado''');

EXECUTE ('COMMENT ON COLUMN      conc.id_usrs_verificador 
    IS ''Conc Usuario Verificador''');

EXECUTE ('COMMENT ON COLUMN      conc.fecha_rec 
    IS ''Conc Fecha''');

EXECUTE ('COMMENT ON COLUMN      conc.code_turn 
    IS ''Conc Codigo Turno''');

EXECUTE ('COMMENT ON COLUMN      conc.id_carr 
    IS ''Conc Id Carril''');

EXECUTE ('COMMENT ON COLUMN      conc.conc_state  
    IS ''Conc Estado''');

EXECUTE ('COMMENT ON COLUMN      conc.id_state_conc
    IS ''Identificador Estado Conc''');

EXECUTE ('COMMENT ON COLUMN      conc.cod_usrs 
    IS ''Codigo Usuario''');

EXECUTE ('COMMENT ON COLUMN      conc.date_conc 
    IS ''Fecha Conc''');

EXECUTE ('COMMENT ON COLUMN      conc.id_plac 
    IS ''Id Plac''');
	

	     raise notice 'TABLA CREADA SATISFACTORIAMENTE: CONC';
 ELSE
	  raise notice 'TABLA VALIDADA:CONC';
END IF;


-----------------------------------------------------------------
-- Table: log
-- Tabla para determinar el estado y demas aspectos del conciliacion
-----------------------------------------------------------------
SELECT count(1) INTO V_COUNT from information_schema.tables where table_name = 'log';
	 IF V_COUNT = 0 THEN
	EXECUTE('		 
CREATE TABLE IF NOT EXISTS log(
    id_log          bigint NOT NULL,
	usrs            bigint,
	log_mensaje     character varying(250) COLLATE pg_catalog."default",
	log_nivel       character varying(20) COLLATE pg_catalog."default",
	log_date        timestamp without time zone,
	log_tipo        character varying(100) COLLATE pg_catalog."default",
	location_log    character varying(20) COLLATE pg_catalog."default",
    ip              character varying(20) COLLATE pg_catalog."default",	
    id_esta         bigint,
            
        CONSTRAINT log_pkey PRIMARY KEY (id_log)
);');

EXECUTE ('COMMENT ON COLUMN log.id_log
    IS ''identificador de la trazabilidad.'';');

EXECUTE ('COMMENT ON COLUMN log.usrs
    IS ''usuario quien realiza la accion.'';');

EXECUTE ('COMMENT ON COLUMN log.log_mensaje
    IS ''mensaje del porque la accion.'';');


EXECUTE ('COMMENT ON COLUMN log.log_nivel
    IS ''tipo del mensaje.'';');


EXECUTE ('COMMENT ON COLUMN log.log_date
    IS ''fecha y hora de la accion.'';');
	

EXECUTE ('COMMENT ON COLUMN log.log_tipo
    IS ''tipo del mensaje.'';');


EXECUTE ('COMMENT ON COLUMN log.location_log
    IS ''desde donde se origina la accion.'';');


EXECUTE ('COMMENT ON COLUMN log.ip
    IS ''ip de la maquina donde se realiza la accion.'';');


EXECUTE ('COMMENT ON COLUMN log.id_esta
    IS ''identificador de la estacion.'';');	
	
	

   raise notice 'TABLA CREADA SATISFACTORIAMENTE: LOG';
 ELSE
	  raise notice 'TABLA VALIDADA: LOG';		 
END IF;

---------------------------------------------------------------------------------------------------
-- Table:TRAN_DAC
-- Tabla para almacenar el registro de la transaccion y sus movimientos
---------------------------------------------------------------------------------------------------
SELECT count(1) INTO V_COUNT from information_schema.tables where table_name = 'tran_dac';
IF V_COUNT = 0 THEN
EXECUTE('
CREATE TABLE IF NOT EXISTS tran_dac(
id_tran_dac bigint NOT NULL,
id_cate bigint NOT NULL,
ejes_tran_dac smallint NOT NULL,
ejes_dobles_tran_dac smallint NOT NULL,
sentido_tran_dac varchar(1) NOT NULL,
fecha_tran_dac timestamp without time zone NOT NULL,
fecha_recaudo_tran_dac timestamp without time zone NOT NULL,
id_carr bigint NOT NULL,
codigo_turn varchar(2),
id_usrs bigint,
mantenimiento varchar(1),
violacion varchar(1),
simulacion varchar(1),
fecha_rec timestamp withot time zone,
receipt_data varchar(25),
consecutive bigint,

CONSTRAINT tran_dac_pkey PRIMARY KEY (id_tran_dac)
);');

EXECUTE ('COMMENT ON COLUMN tran_dac.id_tran_dac
IS ''identificador de la transaccion dac .'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.id_cate
IS ''identificador de la categoria.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.ejes_tran_dac
IS ''ejes de transaccion .'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.ejes_dobles_tran_dac
IS '' ejes dobles de transaccion.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.sentido_tran_dac
IS ''sentido transaccion dac.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.fecha_tran_dac
IS ''fecha transaccion dac.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.fecha_recaudo_tran_dac
IS ''fecha recaudo.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.id_carr
IS ''identificador del carril.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.codigo_turn
IS ''identificador del turno.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.id_usrs
IS ''identificador del usuario.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.mantenimiento
IS ''mantenimiento.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.violacion
IS ''violacion.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.simulacion
IS ''simulacion.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.fecha_rec
IS ''fecha rec.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.receipt_data
IS ''receipt data.'';');

EXECUTE ('COMMENT ON COLUMN tran_dac.consecutive
IS ''consecutive.'';');

raise notice 'TABLA CREADA SATISFACTORIAMENTE: TRAN_DAC';
ELSE
raise notice 'TABLA VALIDADA: TRAN_DAC';
END IF;

end $$;