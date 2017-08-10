package dn.bms3.dao.interfac;

import dn.bms3.model.Rol;
import dn.core3.hibernate.generic.interfac.IGenericDao;

public interface IRolDao  extends IGenericDao<Rol, Integer>{
  public  boolean existCode(String code, Integer except);
}

