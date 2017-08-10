package dn.bms3.service.interfac;

import dn.bms3.model.PurchaseDetail;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;

public interface IPurchaseDetailService
        extends IGenericService<PurchaseDetail, Long> {

    public BigDecimal getQuantityById(Long paramLong);

    public BigDecimal getUnitCostById(Long paramLong);
}
