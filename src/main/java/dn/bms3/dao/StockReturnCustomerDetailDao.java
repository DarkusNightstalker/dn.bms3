package dn.bms3.dao;

import dn.bms3.dao.interfac.IStockReturnCustomerDetailDao;
import dn.bms3.model.StockReturnCustomerDetail;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class StockReturnCustomerDetailDao extends GenericDao<StockReturnCustomerDetail, Long> implements IStockReturnCustomerDetailDao {
}
