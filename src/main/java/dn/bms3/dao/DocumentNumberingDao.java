package dn.bms3.dao;

import dn.bms3.dao.interfac.IDocumentNumberingDao;
import dn.bms3.model.DocumentNumbering;
import dn.bms3.model.User;
import dn.core3.hibernate.generic.GenericDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentNumberingDao        extends GenericDao<DocumentNumbering, Integer>        implements IDocumentNumberingDao {

    @Override
    public List<Object[]> getDataByUser(User user, String ruc) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT dn.id,dn.paymentProof.id,dn.serie FROM DocumentNumbering dn join dn.users u WHERE u.id = ? AND dn.rucCompany LIKE ?");

        query.setInteger(0, user.getId());
        query.setString(1, ruc);
        return query.list();
    }
}
