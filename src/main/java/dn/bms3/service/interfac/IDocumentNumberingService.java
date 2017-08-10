package dn.bms3.service.interfac;

import dn.bms3.model.DocumentNumbering;
import dn.bms3.model.User;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.List;

/**
 *
 * @author Darkus Nightmare
 */
public  interface IDocumentNumberingService extends IGenericService<DocumentNumbering, Integer> {

    /**
     *
     * @param user
     * @param ruc
     * @return
     */
    public  List<Object[]> getDataByUser(User user, String ruc);

    /**
     *
     * @return Lista de datos de numeración de documentos <br/>
     *<b>FORMATO : </b><br/>
     * <code>[0]</code>  - <b>Tipo : </b>{@link java.lang.Integer} - Identificador único de registro<br/>
     * <code>[1]</code>  - <b>Tipo : </b>{@link java.lang.Short}   - Identificador de tipo de comprobante de pago<br/>
     * <code>[2]</code>  - <b>Tipo : </b>{@link java.lang.String}  - Ruc de empresa<br/>
     * <code>[3]</code>  - <b>Tipo : </b>{@link java.lang.String}  - Serie<br/>
     * <code>[4]</code>  - <b>Tipo : </b>{@link java.lang.Long}    - Numeración actual<br/>
     * <code>[5]</code>  - <b>Tipo : </b>{@link java.lang.Boolean} - Es electronico<br/>
     */
    public  List<Object[]> getListData();
}
