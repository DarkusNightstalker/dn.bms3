package dn.bms3.dao;

import dn.bms3.dao.interfac.IProductSalePriceDao;
import dn.bms3.model.ProductSalePrice;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProductSalePriceDao
        extends GenericDao<ProductSalePrice, Long>
        implements IProductSalePriceDao {
}
