package dn.bms3.dao;

import dn.bms3.dao.interfac.IPermissionDao;
import dn.bms3.model.Permission;
import dn.bms3.model.PermissionCategory;
import dn.bms3.model.User;
import dn.core3.hibernate.generic.GenericDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionDao
        extends GenericDao<Permission, Integer>
        implements IPermissionDao {

    public List<Permission> getBy(PermissionCategory category) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT p FROM Permission p WHERE " + (category != null ? "p.permissionCategory = :category" : "p.permissionCategory is null"));
        if (category != null) {
            query.setEntity("category", category);
        }
        return query.list();
    }

    public List<String> getPermissionCodeFromUser(User user) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT DISTINCT p.code FROM Permission p join p.rols r join r.users u WHERE u.id = ? and  p.active = true and r.active = true");

        query.setInteger(0, user.getId());
        return query.list();
    }
}
