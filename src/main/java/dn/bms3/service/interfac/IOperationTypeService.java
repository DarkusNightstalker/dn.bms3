package dn.bms3.service.interfac;

import dn.bms3.model.OperationType;
import dn.core3.hibernate.generic.interfac.IGenericService;

public  interface IOperationTypeService
  extends IGenericService<OperationType, Short>
{
  public  Short getOpeningBalanceTypeId();
  
  public  Short getSaleTypeId();
  
  public  Short getPurchaseTypeId();
  
  public  Short getISMInTypeId();
  
  public  Short getISMOutTypeId();
  
  public  Short getDecreaseTypeId();
  
  public  Short getCustomerReturnTypeId();
  
  public  Short getSupplierReturnTypeId();
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IOperationTypeService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */