package dn.bms3.service;

import dn.bms3.dao.interfac.ICompanyGroupDao;
import dn.bms3.model.CompanyGroup;
import dn.bms3.service.interfac.ICompanyGroupService;
import dn.core3.hibernate.generic.GenericService;
import dn.core3.hibernate.generic.interfac.IGenericDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CompanyGroupService
        extends GenericService<CompanyGroup, Integer>
        implements ICompanyGroupService {

    @Autowired
    @Qualifier("companyGroupDao")
    private ICompanyGroupDao dao;

    protected IGenericDao<CompanyGroup, Integer> getBasicDao() {
        return this.dao;
    }

    public List<Object[]> getBasicData() {
        return this.dao.listHQL("SELECT cg.id,cg.name FROM CompanyGroup cg WHERE cg.active = true");
    }
}
