package dn.bms3.service.interfac;

import dn.bms3.model.Company;
import dn.bms3.model.InternalStockMovement;
import dn.bms3.model.InternalStockMovementDetail;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.List;

public interface IInternalStockMovementDetailService extends IGenericService<InternalStockMovementDetail, Long> {

    public List<Object[]> getRemoveds(List<Long> paramList, Long paramLong);

    public void restoreStock(InternalStockMovementDetail paramInternalStockMovementDetail, Company paramCompany1, Company paramCompany2);

    public List<Object[]> getDataForManage(InternalStockMovement paramInternalStockMovement);

    public BigDecimal getQuantityById(Long paramLong);

    public BigDecimal getUnitCostById(Long paramLong);
    
    public Long countNotUploaded();
}