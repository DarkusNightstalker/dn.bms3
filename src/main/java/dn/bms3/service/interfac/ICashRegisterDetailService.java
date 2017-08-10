package dn.bms3.service.interfac;

import dn.bms3.enumerated.CashType;
import dn.bms3.model.CashRegister;
import dn.bms3.model.CashRegisterDetail;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.io.Serializable;

/**
 * Interfaz SERVICE para el model CASH REGISTER DETAIL
 * 
 * @author Darkus Nightmare
 * @version 1.0
 */
public abstract interface ICashRegisterDetailService extends IGenericService<CashRegisterDetail, Serializable> {

    /**
     * Obtiene la cantidad de monedas  o billetes que hubo en un cierre de caja por un tipo especifico de cambio
     * 
     * @param cashRegisterId Identificador unico del cierre de caja
     * @param type tipo de cambio
     * @return cantidad de monedas o billetes del tipo de cambio ingresado
     */
    public abstract Integer getQuantity(Long cashRegisterId, CashType type);

    /**
     * Obtiene las cantidades mapeadas por tipo de moneda , ademas de la sumatoria total del valor de estas de un cierre de caja especifico
     * 
     * @param cashRegisterId Identificador único de cierre de caja
     * @return Mapeo de tipos con cantidades respectivas y la sumatoria total <br/>
     * <b>FORMATO :</b><br/>
     * <code>[0]</code> - <b>Tipo : </b> {@link java.util.Map} &lt;{@link dn.bms3.enumerated.CashType},{@link java.lang.Integer}&gt; - mapeo de cantidades<br/>
     * <code>[1]</code> - <b>Tipo : </b> {@link java.math.BigDecimal} - sumatorial total
     */
    public abstract Object[] getQuantitiesAsMap(Long cashRegisterId);

    /**
     * Elimina de la base de datos todos los detalles de un cierre de caja especifico
     * @param cashRegister cierre de caja del que se va a eliminar los detalles
     */
    public void deleteBy(CashRegister cashRegister);
}
