package dn.bms3.dao;

import dn.bms3.dao.interfac.IProductLineDao;
import dn.bms3.model.ProductLine;
import dn.core3.hibernate.generic.GenericDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProductLineDao
        extends GenericDao<ProductLine, Integer>
        implements IProductLineDao {

    public boolean existPath(String path, Integer exception) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM ProductLine pl WHERE pl.path LIKE :path ANND pl.id <> :id");
        query.setString("path", path);
        query.setInteger("id", exception == null ? -1 : exception.intValue());
        return query.uniqueResult() != null;
    }
}
