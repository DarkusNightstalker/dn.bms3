package dn.bms3.dao;

import dn.bms3.dao.interfac.IFinancialEntityDao;
import dn.bms3.model.FinancialEntity;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class FinancialEntityDao
  extends GenericDao<FinancialEntity, Short>
  implements IFinancialEntityDao
{}
