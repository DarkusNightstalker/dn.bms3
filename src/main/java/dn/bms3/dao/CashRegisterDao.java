package dn.bms3.dao;

import dn.bms3.dao.interfac.ICashRegisterDao;
import dn.bms3.model.CashRegister;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class CashRegisterDao
  extends GenericDao<CashRegister, Long>
  implements ICashRegisterDao
{}
