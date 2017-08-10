package dn.bms3.service;

import dn.bms3.dao.interfac.IPermissionDao;
import dn.bms3.model.Permission;
import dn.bms3.model.PermissionCategory;
import dn.bms3.model.User;
import dn.bms3.service.interfac.IPermissionService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PermissionService
        extends GenericService<Permission, Integer>
        implements IPermissionService {

    @Autowired
    @Qualifier("permissionDao")
    private IPermissionDao dao;

    public List<Permission> getBy(PermissionCategory category) {
        return this.dao.getBy(category);
    }

    protected IGenericDao<Permission, Integer> getDao() {
        return this.dao;
    }

    public List<String> getPermissionCodeFromUser(User user) {
        return this.dao.getPermissionCodeFromUser(user);
    }
}
