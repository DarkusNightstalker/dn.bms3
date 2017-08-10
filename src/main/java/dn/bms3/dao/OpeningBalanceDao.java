package dn.bms3.dao;

import dn.bms3.dao.interfac.IOpeningBalanceDao;
import dn.bms3.model.OpeningBalance;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class OpeningBalanceDao
  extends GenericDao<OpeningBalance, Long>
  implements IOpeningBalanceDao
{}

