package dn.bms3.service.interfac;

import dn.bms3.model.PaymentProof;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Darkus Nightmare
 * @version 1.0
 */
public interface IPaymentProofService extends IGenericService<PaymentProof, Short> {

    /**
     *
     * @param code
     * @param exception
     * @return
     */
    public boolean existCode(String code, Short exception);

    /**
     *
     * @param abbr
     * @return
     */
    public Short getIdByAbbr(String abbr);

    /**
     *
     * @param date
     * @return Lista de datos de los comprobantes de pago creados desde la fecha
     * especifica <br/>
     * <b>FORMATO : </b><br/>
     * <code>[0]</code> - <b>Tipo : </b>{@link java.lang.Short} - Identificador
     * único de registro<br/>
     * <code>[1]</code> - <b>Tipo : </b>{@link java.lang.String} - Codigo<br/>
     * <code>[2]</code> - <b>Tipo : </b>{@link java.lang.String} -
     * Abreviatura<br/>
     * <code>[3]</code> - <b>Tipo : </b>{@link java.lang.String} - Nombre<br/>
     * <code>[4]</code> - <b>Tipo : </b>{@link java.lang.Boolean} - Sirve para
     * vender<br/>
     * <code>[5]</code> - <b>Tipo : </b>{@link java.lang.Boolean} - Sirve para
     * comprar<br/>
     * <code>[6]</code> - <b>Tipo : </b>{@link java.lang.Boolean} - Sirve para
     * movimiento interno<br/>
     * <code>[7]</code> - <b>Tipo : </b>{@link java.lang.Boolean} - Sirve para
     * devoluciones<br/>
     * <code>[8]</code> - <b>Tipo : </b>{@link java.lang.Boolean} - Esta
     * activo<br/>
     * <code>[9]</code> - <b>Tipo : </b>{@link java.lang.Integer} -
     * Identificador de usuario creador<br/>
     * <code>[10]</code> - <b>Tipo : </b>{@link java.util.Date} - Fecha de
     * creación<br/>
     */
    public List<Object[]> getCreateByAfterDate(Date date);

    /**
     *
     * @param date
     * @param withCreateds
     * @return Lista de datos de los comprobantes de pago editados desde la
     * fecha especifica <br/>
     * <b>FORMATO : </b><br/>
     * <code>[0]</code> - <b>Tipo : </b>{@link java.lang.Short} - Identificador
     * único de registro<br/>
     * <code>[1]</code> - <b>Tipo : </b>{@link java.lang.String} - Codigo<br/>
     * <code>[2]</code> - <b>Tipo : </b>{@link java.lang.String} -
     * Abreviatura<br/>
     * <code>[3]</code> - <b>Tipo : </b>{@link java.lang.String} - Nombre<br/>
     * <code>[4]</code> - <b>Tipo : </b>{@link java.lang.Boolean} - Sirve para
     * vender<br/>
     * <code>[5]</code> - <b>Tipo : </b>{@link java.lang.Boolean} - Sirve para
     * comprar<br/>
     * <code>[6]</code> - <b>Tipo : </b>{@link java.lang.Boolean} - Sirve para
     * movimiento interno<br/>
     * <code>[7]</code> - <b>Tipo : </b>{@link java.lang.Boolean} - Sirve para
     * devoluciones<br/>
     * <code>[8]</code> - <b>Tipo : </b>{@link java.lang.Boolean} - Esta
     * activo<br/>
     * <code>[9]</code> - <b>Tipo : </b>{@link java.lang.Integer} -
     * Identificador de usuario creador<br/>
     * <code>[10]</code> - <b>Tipo : </b>{@link java.util.Date} - Fecha de
     * creación<br/>
     * <code>[11]</code> - <b>Tipo : </b>{@link java.lang.Integer} -
     * Identificador de usuario editor<br/>
     * <code>[12]</code> - <b>Tipo : </b>{@link java.util.Date} - Ultima fecha
     * de edición<br/>
     */
    public List<Object[]> getEditedByAfterDate(Date date, boolean withCreateds);

    /**
     *
     * @param code
     * @return
     */
    public Short getIdByCode(String code);

    public List<Object[]> getForReturn();
}
