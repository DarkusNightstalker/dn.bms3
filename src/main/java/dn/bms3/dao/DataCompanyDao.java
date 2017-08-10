package dn.bms3.dao;

import dn.bms3.dao.interfac.IDataCompanyDao;
import dn.bms3.model.DataCompany;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class DataCompanyDao extends GenericDao<DataCompany, Integer> implements IDataCompanyDao {
}
