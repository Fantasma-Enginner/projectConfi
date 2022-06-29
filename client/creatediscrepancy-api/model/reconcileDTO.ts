/**
 * Discrepancia
 * Corresponde al módulo de discrepancia-Crear Discrepancia
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

export interface ReconcileDTO { 
    /**
     * Id de Conc
     */
    idConc?: string;
    /**
     * Id Tran Dac
     */
    idTranDac?: string;
    /**
     * Código de la estación
     */
    stationCode?: number;
    /**
     * Fecha del recaudo
     */
    dateCollection?: string;
    /**
     * Id de carril
     */
    laneId?: number;
    /**
     * Código de turno
     */
    turnCode?: number;
    /**
     * Categoría de Consola
     */
    consoleCategory?: number;
    /**
     * Categoría de DAC
     */
    dacCategory?: number;
    /**
     * Sentido
     */
    sentConc?: string;
    /**
     * id del recolector
     */
    usercode?: string;
    /**
     * Nombre de la novedad
     */
    noveltyName?: string;
    /**
     * Valor recaudado
     */
    valueCollection?: string;
    /**
     * Nombre de la regla de conciliación
     */
    conciliationRuleName?: string;
    /**
     * Valor real conciliado
     */
    reconcileValue?: number;
    /**
     * Id de la regla de conciliación
     */
    ruleId?: number;
    /**
     * fecha de la transacción
     */
    dateTransaction?: string;
    /**
     * Id de la afectación
     */
    afectaConcId?: number;
    /**
     * Id de la forma de pago
     */
    idFormPago?: number;
    /**
     * Numero de placa
     */
    numPlaca?: string;
    /**
     * Nombre usuario
     */
    usercodename?: string;
    /**
     * FormapagoName
     */
    idFormPagoname?: string;
}