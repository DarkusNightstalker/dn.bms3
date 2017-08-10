package dn.bms3.dao;

import dn.bms3.dao.interfac.IRolDao;
import dn.bms3.model.Rol;
import dn.core3.hibernate.generic.GenericDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RolDao
        extends GenericDao<Rol, Integer>
        implements IRolDao {

    public boolean existCode(String code, Integer id) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM Rol r WHERE r.code LIKE :code AND r.id != :id");
        query.setString("code", code);
        query.setInteger("id", id == null ? -1 : id.intValue());
        return query.uniqueResult() != null;
    }
}
