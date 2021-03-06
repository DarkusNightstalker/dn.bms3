package dn.bms3.dao;

import dn.bms3.dao.interfac.ISubregionDao;
import dn.bms3.model.Subregion;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class SubregionDao extends GenericDao<Subregion, Integer> implements ISubregionDao {
}
