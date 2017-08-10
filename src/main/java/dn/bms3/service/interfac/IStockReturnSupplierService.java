package dn.bms3.service.interfac;

import dn.bms3.model.Purchase;
import dn.bms3.model.StockReturnSupplier;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Darkus Nightmare
 */
public interface IStockReturnSupplierService extends IGenericService<StockReturnSupplier, Long> {

    /**
     *
     * @param selected
     * @return
     */
    public BigDecimal getSumRepayment(Purchase selected);

    /**
     *
     * @param selected
     * @return
     */
    public List<Object[]> getBasicDataByPurchase(Purchase selected);

}

