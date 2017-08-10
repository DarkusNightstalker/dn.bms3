package dn.bms3.service.interfac;

import dn.bms3.model.ElectronicBook;
import dn.core3.hibernate.generic.interfac.IGenericService;

public interface IElectronicBookService
  extends IGenericService<ElectronicBook, Short>
{
  public boolean existCode(String paramString, Short paramShort);
}
