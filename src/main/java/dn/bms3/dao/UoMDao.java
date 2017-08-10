package dn.bms3.dao;

import dn.bms3.dao.interfac.IUoMDao;
import dn.bms3.model.UoM;
import dn.core3.hibernate.generic.GenericDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("uomDao")
public class UoMDao extends GenericDao<UoM, Integer> implements IUoMDao {

    @Override
    public boolean existName(String name, Integer exception) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM UoM uom WHERE uom.name LIKE :name AND uom.id <> :id");
        query.setString("name", name);
        query.setInteger("id", exception == null ? -1 : exception);
        return query.uniqueResult() != null;
    }

    @Override
    public boolean existCode(String code, Integer exception) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM UoM uom WHERE uom.code LIKE :code AND uom.id <> :id");
        query.setString("code", code);
        query.setInteger("id", exception == null ? -1 : exception);
        return query.uniqueResult() != null;
    }
}
