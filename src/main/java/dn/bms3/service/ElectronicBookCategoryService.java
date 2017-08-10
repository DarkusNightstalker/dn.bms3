package dn.bms3.service;

import dn.bms3.dao.interfac.IElectronicBookCategoryDao;
import dn.bms3.model.ElectronicBookCategory;
import dn.bms3.service.interfac.IElectronicBookCategoryService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ElectronicBookCategoryService
        extends GenericService<ElectronicBookCategory, Short>
        implements IElectronicBookCategoryService {

    @Autowired
    @Qualifier("electronicBookCategoryDao")
    private IElectronicBookCategoryDao dao;

    public boolean existCode(String code, Short id) {
        return this.dao.existCode(code, id);
    }

    protected IGenericDao<ElectronicBookCategory, Short> getDao() {
        return this.dao;
    }

    public List<Object[]> getBasicData() {
        return this.dao.listHQL("SELECT ebc.id,ebc.code,ebc.name FROM ElectronicBookCategory ebc WHERE ebc.active = true ORDER by ebc.id");
    }
}
