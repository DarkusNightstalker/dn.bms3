package dn.bms3.dao;

import dn.bms3.dao.interfac.IPurchaseDetailDao;
import dn.bms3.model.PurchaseDetail;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseDetailDao
  extends GenericDao<PurchaseDetail, Long>
  implements IPurchaseDetailDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\PurchaseDetailDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */