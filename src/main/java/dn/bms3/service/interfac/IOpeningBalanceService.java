package dn.bms3.service.interfac;

import dn.bms3.model.OpeningBalance;
import dn.bms3.model.User;
import dn.core3.hibernate.generic.interfac.IGenericService;
import dn.core3.util.Month;

public  interface IOpeningBalanceService
  extends IGenericService<OpeningBalance, Long>
{
  public  void generate(Integer paramInteger1, Month paramMonth, Integer paramInteger2, User paramUser);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IOpeningBalanceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */