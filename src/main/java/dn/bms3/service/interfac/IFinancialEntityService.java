package dn.bms3.service.interfac;

import dn.bms3.model.FinancialEntity;
import dn.core3.hibernate.generic.interfac.IGenericService;

public interface IFinancialEntityService extends IGenericService<FinancialEntity, Short> {

    public  boolean verifyCode(String paramString, Short paramShort);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IFinancialEntityService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
