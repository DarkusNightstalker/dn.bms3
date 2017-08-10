package dn.bms3.dao;

import dn.bms3.dao.interfac.IProductCostPriceDao;
import dn.bms3.model.ProductCostPrice;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCostPriceDao
        extends GenericDao<ProductCostPrice, Long>
        implements IProductCostPriceDao {
}
