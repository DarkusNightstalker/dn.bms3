package dn.bms3.dao;

import dn.bms3.dao.interfac.IStockReductionDao;
import dn.bms3.model.StockReduction;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class StockReductionDao
  extends GenericDao<StockReduction, Long>
  implements IStockReductionDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\StockReductionDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */