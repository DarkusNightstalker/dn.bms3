package dn.bms3.dao;

import dn.bms3.dao.interfac.IKardexDao;
import dn.bms3.model.Kardex;
import dn.core3.hibernate.generic.GenericDao;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class KardexDao
  extends GenericDao<Kardex, Serializable>
  implements IKardexDao
{}

