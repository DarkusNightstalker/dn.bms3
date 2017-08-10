package dn.bms3.dao;

import dn.bms3.dao.interfac.IStockReturnSupplierDao;
import dn.bms3.model.StockReturnSupplier;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class StockReturnSupplierDao extends GenericDao<StockReturnSupplier, Long> implements IStockReturnSupplierDao {
}
