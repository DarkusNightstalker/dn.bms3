package dn.bms3.dao;

import dn.bms3.dao.interfac.IElectronicBookCategoryDao;
import dn.bms3.model.ElectronicBookCategory;
import dn.core3.hibernate.generic.GenericDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ElectronicBookCategoryDao        extends GenericDao<ElectronicBookCategory, Short>        implements IElectronicBookCategoryDao {

    @Override
    public boolean existCode(String code, Short id) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM ElectronicBookCategory ebc WHERE ebc.code LIKE :code AND ebc.id != :id");
        query.setString("code", code);
        query.setLong("id", id == null ? -1L : id);

        return query.uniqueResult() != null;
    }
}
