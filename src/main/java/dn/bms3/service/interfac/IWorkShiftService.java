package dn.bms3.service.interfac;

import dn.bms3.model.Company;
import dn.bms3.model.WorkShift;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IWorkShiftService
        extends IGenericService<WorkShift, Integer> {

    public List<Object[]> getFreeBasicDataByCompany(Date paramDate, Company paramCompany);

    public List<Object[]> getBasicDataByCompany(Company paramCompany);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IWorkShiftService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
