package dn.bms3.dao;

import dn.bms3.dao.interfac.IStockReturnSupplierDetailDao;
import dn.bms3.model.StockReturnSupplierDetail;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class StockReturnSupplierDetailDao extends GenericDao<StockReturnSupplierDetail, Long> implements IStockReturnSupplierDetailDao {
}
