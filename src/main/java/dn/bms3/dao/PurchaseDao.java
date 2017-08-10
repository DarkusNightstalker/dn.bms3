package dn.bms3.dao;

import dn.bms3.dao.interfac.IPurchaseDao;
import dn.bms3.model.Purchase;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseDao
  extends GenericDao<Purchase, Long>
  implements IPurchaseDao
{}
