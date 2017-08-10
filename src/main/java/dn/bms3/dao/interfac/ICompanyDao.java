package dn.bms3.dao.interfac;

import dn.bms3.model.Company;
import dn.core3.hibernate.generic.interfac.IGenericDao;
import java.util.List;

public interface ICompanyDao extends IGenericDao<Company, Integer> {

    public List<Object[]> getDataByList(List<Long> list);
}
