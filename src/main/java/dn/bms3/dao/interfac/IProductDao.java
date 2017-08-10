package dn.bms3.dao.interfac;

import dn.bms3.model.Product;
import dn.core3.hibernate.generic.interfac.IGenericDao;

public interface IProductDao
        extends IGenericDao<Product, Long> {

    public boolean existBarCode(String paramString, Long paramLong);
}
