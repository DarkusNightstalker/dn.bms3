package dn.bms3.dao;

import dn.bms3.dao.interfac.IUserDao;
import dn.bms3.model.User;
import dn.bms3.util.AESKeys;
import dn.core3.hibernate.generic.GenericDao;
import dn.core3.util.AES;
import java.math.BigInteger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GenericDao<User, Integer> implements IUserDao {

    @Override
    public User login(String username, String password)
            throws Exception {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT u FROM User u WHERE u.username LIKE :username AND u.password LIKE :password");
        query.setString("username", username);
        query.setString("password", AES.encrypt(password, AESKeys.USER_PASSWORD));
        return (User) query.uniqueResult();
    }

    @Override
    public Integer getNextId() {
        return ((BigInteger) getSessionFactory().getCurrentSession().createSQLQuery("SELECT (last_value+1) FROM user_id_seq").uniqueResult()).intValue();
    }

    @Override
    public boolean existUsername(String username, Integer id) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM User u WHERE u.username LIKE :username AND u.id != :id");
        query.setString("username", username);
        query.setInteger("id", id == null ? -1 : id);
        return query.uniqueResult() != null;
    }
}
