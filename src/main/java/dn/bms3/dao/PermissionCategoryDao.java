package dn.bms3.dao;

import dn.bms3.dao.interfac.IPermissionCategoryDao;
import dn.bms3.model.PermissionCategory;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionCategoryDao
  extends GenericDao<PermissionCategory, Integer>
  implements IPermissionCategoryDao
{}

