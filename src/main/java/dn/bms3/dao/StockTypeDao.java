package dn.bms3.dao;

import dn.bms3.dao.interfac.IStockTypeDao;
import dn.bms3.model.StockType;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class StockTypeDao extends GenericDao<StockType, Short> implements IStockTypeDao {
}
