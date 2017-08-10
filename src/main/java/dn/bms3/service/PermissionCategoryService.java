package dn.bms3.service;

import dn.bms3.dao.interfac.IPermissionCategoryDao;
import dn.bms3.model.PermissionCategory;
import dn.bms3.service.interfac.IPermissionCategoryService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PermissionCategoryService
        extends GenericService<PermissionCategory, Integer>
        implements IPermissionCategoryService {

    @Autowired
    @Qualifier("permissionCategoryDao")
    private IPermissionCategoryDao dao;

    protected IGenericDao<PermissionCategory, Integer> getDao() {
        return this.dao;
    }
}
