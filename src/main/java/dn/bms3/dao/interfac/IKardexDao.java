package dn.bms3.dao.interfac;

import dn.bms3.model.Kardex;
import dn.core3.hibernate.generic.interfac.IGenericDao;
import java.io.Serializable;

public abstract interface IKardexDao
  extends IGenericDao<Kardex, Serializable>
{}
