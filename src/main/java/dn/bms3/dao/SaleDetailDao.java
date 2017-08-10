package dn.bms3.dao;

import dn.bms3.dao.interfac.ISaleDetailDao;
import dn.bms3.model.SaleDetail;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class SaleDetailDao
  extends GenericDao<SaleDetail, Long>
  implements ISaleDetailDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\SaleDetailDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */