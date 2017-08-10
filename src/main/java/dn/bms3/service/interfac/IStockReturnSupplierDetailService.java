package dn.bms3.service.interfac;

import dn.bms3.model.StockReturnSupplierDetail;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Darkus Nightmare
 */
public interface IStockReturnSupplierDetailService extends IGenericService<StockReturnSupplierDetail, Long> {

    /**
     *
     * @param idSupplierReturn
     * @return
     */
    public List<Object[]> getDataBySupplierReturn(Long idSupplierReturn);
    
    /**
     *
     * @param idPurchase
     * @param idProduct
     * @param exception
     * @return
     */
    public BigDecimal getSumQuantityByProduct(Long idPurchase,Long idProduct,Long exception);

    /**
     *
     * @param id
     * @return
     */
    public BigDecimal getUnitCostById(Long id);

    /**
     *
     * @param id
     * @return
     */
    public BigDecimal getQuantityById(Long id);

}
