package dn.bms3.service.interfac;

import dn.bms3.model.ElectronicBookCategory;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.List;

public  interface IElectronicBookCategoryService
  extends IGenericService<ElectronicBookCategory, Short>
{
  public  boolean existCode(String paramString, Short paramShort);
  
  public  List<Object[]> getBasicData();
}
