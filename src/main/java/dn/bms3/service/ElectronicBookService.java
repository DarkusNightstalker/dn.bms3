package dn.bms3.service;

import dn.bms3.dao.interfac.IElectronicBookDao;
import dn.bms3.model.ElectronicBook;
import dn.bms3.service.interfac.IElectronicBookService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ElectronicBookService
        extends GenericService<ElectronicBook, Short>
        implements IElectronicBookService {

    @Autowired
    @Qualifier("electronicBookDao")
    private IElectronicBookDao dao;

    public boolean existCode(String code, Short id) {
        return this.dao.existCode(code, id);
    }

    protected IGenericDao<ElectronicBook, Short> getDao() {
        return this.dao;
    }
}
