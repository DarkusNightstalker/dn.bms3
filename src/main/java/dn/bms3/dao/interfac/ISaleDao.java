package dn.bms3.dao.interfac;

import dn.bms3.model.Company;
import dn.bms3.model.Sale;
import dn.core3.hibernate.generic.interfac.IGenericDao;
import java.util.List;

/**
 * Interfaz DAO para el modelo SALE
 * @author Darkus Nightmare
 * @version  1.0
 */
public interface ISaleDao extends IGenericDao<Sale, Long> {

    /**
     * Obtiene las ventas no verificadas de una sede en especifico y que no se tenga los identificadores señalados
     * @param company Sede 
     * @param exceptions Identificadores a no tomar en cuenta
     * @return Lista de datos de las ventas no verificadas <br/>
     *<b>FORMATO : </b><br/>
     * <code>[0]</code> - Identificador único de registro<br/>
     * <code>[1]</code> - Fecha de emisión<br/>
     * <code>[2]</code> - Tipo,serie y numero de comprobante de pago<br/>
     * <code>[3]</code> - Nombre del cliente<br/>
     * <code>[4]</code> - Total de la venta<br/>
     */
    public List<Object[]> getNotVerifySales(Company company, List<Long> exceptions);
}
