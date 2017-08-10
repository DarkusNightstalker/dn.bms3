package dn.bms3.dao;

import dn.bms3.dao.interfac.IPaymentProofDao;
import dn.bms3.model.PaymentProof;
import dn.core3.hibernate.generic.GenericDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentProofDao
        extends GenericDao<PaymentProof, Short>
        implements IPaymentProofDao {

    public boolean existCode(String code, Short id) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM PaymentProof pp WHERE pp.code LIKE :code AND pp.id != :id");
        query.setString("code", code);
        query.setLong("id", id == null ? -1L : id.shortValue());

        return query.uniqueResult() != null;
    }

    public Short getIdByAbbr(String abbr) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT pp.id FROM PaymentProof pp WHERE pp.abbr LIKE ?");
        query.setString(0, abbr);
        return (Short) query.uniqueResult();
    }
}
