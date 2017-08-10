package dn.bms3.dao.interfac;

import dn.bms3.model.User;
import dn.core3.hibernate.generic.interfac.IGenericDao;

public interface IUserDao extends IGenericDao<User, Integer> {

    public User login(String username, String password) throws Exception;

    public Integer getNextId();

    public boolean existUsername(String username, Integer except);
}
