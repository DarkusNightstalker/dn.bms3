package dn.bms3.dao;

import dn.bms3.dao.interfac.IRegionDao;
import dn.bms3.model.Region;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class RegionDao
  extends GenericDao<Region, Integer>
  implements IRegionDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\RegionDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */