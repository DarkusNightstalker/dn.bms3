package dn.bms3.dao;

import dn.bms3.dao.interfac.IProductDao;
import dn.core3.hibernate.generic.GenericDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends GenericDao<dn.bms3.model.Product, Long> implements IProductDao {

    public boolean existBarCode(String code, Long exception) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM Product p where p.barcode  LIKE :code AND p.id <> :id");
        query.setString("code", code);
        query.setLong("id", exception == null ? -1L : exception.longValue());
        return query.uniqueResult() != null;
    }
}
