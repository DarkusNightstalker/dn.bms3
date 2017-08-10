package dn.bms3.dao.interfac;

import dn.bms3.model.UoM;
import dn.core3.hibernate.generic.interfac.IGenericDao;

public interface IUoMDao extends IGenericDao<UoM, Integer> {

    public boolean existName(String name, Integer except);

    public boolean existCode(String code, Integer except);
}
