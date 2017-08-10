package dn.bms3.service.interfac;

import dn.bms3.model.Rol;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IRolService
  extends IGenericService<Rol, Integer>
{
  public boolean existCode(String paramString, Integer paramInteger);
  
  public List<Object[]> getCreateByAfterDate(Date paramDate);
  
  public List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IRolService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */