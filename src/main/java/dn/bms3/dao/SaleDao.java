package dn.bms3.dao;

import dn.bms3.dao.interfac.ISaleDao;
import dn.bms3.model.Company;
import dn.bms3.model.Sale;
import dn.core3.hibernate.generic.GenericDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Implementación DAO para el modelo SALE
 *
 * @author Darkus Nightmare
 */
@Repository
public class SaleDao extends GenericDao<Sale, Long> implements ISaleDao {

    @Override
    public List<Object[]> getNotVerifySales(Company company, List<Long> exceptions) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT "
                + "s.id,"
                + "s.dateIssue,"
                + "s.paymentProof.abbr||' '||s.fullDocument,"
                + "s.customerName,"
                + "s.subtotal+s.igv-s.subtotalDiscount-s.igvDiscount FROM Sale s WHERE s.company = :company and s.verified = false and s.active = true " + (!exceptions.isEmpty() ? " and s.id NOT IN (:ids)" : ""));
        query.setEntity("company", company);
        if (!exceptions.isEmpty()) {
            query.setParameterList("ids", exceptions);
        }
        List<Object[]> data = query.list();

        if (!data.isEmpty()) {
            query = getSessionFactory().getCurrentSession().createQuery("SELECT s.id FROM Sale s WHERE s.company = :company and s.verified = false and s.active = true " + (!exceptions.isEmpty() ? " and s.id NOT IN (:ids)" : ""));
            query.setEntity("company", company);
            if (!exceptions.isEmpty()) {
                query.setParameterList("ids", exceptions);
            }
            try {
                exceptions.addAll(query.list());
            } catch (UnsupportedOperationException e) {
            }
        }
        return data;
    }
}
