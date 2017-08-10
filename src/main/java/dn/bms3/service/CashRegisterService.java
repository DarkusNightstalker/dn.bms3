package dn.bms3.service;

import dn.bms3.dao.interfac.ICashRegisterDao;
import dn.bms3.model.CashRegister;
import dn.bms3.model.Company;
import dn.bms3.service.interfac.ICashRegisterService;
import dn.core3.hibernate.generic.GenericService;
import dn.core3.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CashRegisterService extends GenericService<CashRegister, Long> implements ICashRegisterService {

    @Autowired
    @Qualifier("cashRegisterDao")
    private ICashRegisterDao dao;

    protected IGenericDao<CashRegister, Long> getBasicDao() {
        return this.dao;
    }

    public Date getLastDate(Company company) {
        List result = this.dao.listHQLPage("SELECT cr.createDate FROM CashRegister cr WHERE cr.company = ? ORDER BY cr.createDate DESC", 1, 1, new Object[]{company});

        return result.isEmpty() ? null : (Date) result.get(0);
    }
}
