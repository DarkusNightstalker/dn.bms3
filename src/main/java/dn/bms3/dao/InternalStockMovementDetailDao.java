package dn.bms3.dao;

import dn.bms3.dao.interfac.IInternalStockMovementDetailDao;
import dn.bms3.model.InternalStockMovementDetail;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class InternalStockMovementDetailDao
  extends GenericDao<InternalStockMovementDetail, Long>
  implements IInternalStockMovementDetailDao
{}
