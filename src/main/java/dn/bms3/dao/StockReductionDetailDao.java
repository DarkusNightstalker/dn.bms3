package dn.bms3.dao;

import dn.bms3.dao.interfac.IStockReductionDetailDao;
import dn.bms3.model.StockReductionDetail;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class StockReductionDetailDao extends GenericDao<StockReductionDetail, Long> implements IStockReductionDetailDao {
}
