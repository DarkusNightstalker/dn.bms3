package dn.bms3.service.interfac;

import dn.bms3.model.Permission;
import dn.bms3.model.PermissionCategory;
import dn.bms3.model.User;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.List;

public interface IPermissionService
        extends IGenericService<Permission, Integer> {

    public List<Permission> getBy(PermissionCategory paramPermissionCategory);

    public List<String> getPermissionCodeFromUser(User paramUser);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IPermissionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
