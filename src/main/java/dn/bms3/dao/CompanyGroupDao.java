package dn.bms3.dao;

import dn.bms3.dao.interfac.ICompanyGroupDao;
import dn.bms3.model.CompanyGroup;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyGroupDao
        extends GenericDao<CompanyGroup, Integer>
        implements ICompanyGroupDao {
}
