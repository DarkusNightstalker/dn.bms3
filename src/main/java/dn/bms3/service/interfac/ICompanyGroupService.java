package dn.bms3.service.interfac;

import dn.bms3.model.CompanyGroup;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.List;

public interface ICompanyGroupService extends IGenericService<CompanyGroup, Integer> {

    public List<Object[]> getBasicData();
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\ICompanyGroupService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
