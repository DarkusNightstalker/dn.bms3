package dn.bms3.service;

import dn.bms3.dao.interfac.IWorkShiftDao;
import dn.bms3.model.Company;
import dn.bms3.model.WorkShift;
import dn.bms3.service.interfac.IWorkShiftService;
import dn.core3.hibernate.generic.GenericService;
import dn.core3.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WorkShiftService
        extends GenericService<WorkShift, Integer>
        implements IWorkShiftService {

    @Autowired
    @Qualifier("workShiftDao")
    private IWorkShiftDao dao;

    protected IGenericDao<WorkShift, Integer> getBasicDao() {
        return this.dao;
    }

    public List<Object[]> getFreeBasicDataByCompany(Date date, Company company) {
        return this.dao.listHQL("SELECT ws.id,ws.name,ws.timeEntry FROM WorkShift ws WHERE ws.active = true AND ws.company = ? AND ws.id not in (SELECT cr.workShift.id FROM CashRegister cr WHERE cr.dateArcing = ?) ORDER by ws.timeEntry", new Object[]{company, date});
    }

    public List<Object[]> getBasicDataByCompany(Company company) {
        return this.dao.listHQL("SELECT ws.id,ws.name,ws.timeEntry FROM WorkShift ws WHERE ws.active = true AND ws.company = ? ORDER by ws.timeEntry", new Object[]{company});
    }
}
