package dn.bms3.dao;

import dn.bms3.dao.interfac.IInternalStockMovementDao;
import dn.bms3.model.InternalStockMovement;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class InternalStockMovementDao
  extends GenericDao<InternalStockMovement, Long>
  implements IInternalStockMovementDao
{}
