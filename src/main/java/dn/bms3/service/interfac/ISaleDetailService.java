package dn.bms3.service.interfac;

import dn.bms3.model.Sale;
import dn.bms3.model.SaleDetail;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.List;

public  interface ISaleDetailService
  extends IGenericService<SaleDetail, Long>
{
  public  List<Object[]> getBasicDataBySale(Sale paramSale);
  
  public  BigDecimal getQuantityById(Long paramLong);
  
  public  List<Object[]> getProductDataBySale(Sale paramSale);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\ISaleDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */