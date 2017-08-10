package dn.bms3.dao;

import dn.bms3.dao.interfac.IStockReturnCustomerDao;
import dn.bms3.model.StockReturnCustomer;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class StockReturnCustomerDao extends GenericDao<StockReturnCustomer, Long> implements IStockReturnCustomerDao {
}
