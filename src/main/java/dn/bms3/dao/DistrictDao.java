package dn.bms3.dao;

import dn.bms3.dao.interfac.IDistrictDao;
import dn.bms3.model.District;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class DistrictDao extends GenericDao<District, Integer> implements IDistrictDao {
}
