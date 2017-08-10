package dn.bms3.dao.interfac;

import dn.bms3.model.Permission;
import dn.bms3.model.PermissionCategory;
import dn.bms3.model.User;
import dn.core3.hibernate.generic.interfac.IGenericDao;
import java.util.List;

public abstract interface IPermissionDao
  extends IGenericDao<Permission, Integer>
{
  public abstract List<Permission> getBy(PermissionCategory paramPermissionCategory);
  
  public abstract List<String> getPermissionCodeFromUser(User paramUser);
}

