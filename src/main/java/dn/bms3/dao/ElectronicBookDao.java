package dn.bms3.dao;

import dn.bms3.dao.interfac.IElectronicBookDao;
import dn.bms3.model.ElectronicBook;
import dn.core3.hibernate.generic.GenericDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ElectronicBookDao extends GenericDao<ElectronicBook, Short> implements IElectronicBookDao {

    @Override
    public boolean existCode(String code, Short id) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM ElectronicBook eb WHERE eb.code LIKE :code AND eb.id != :id");
        query.setString("code", code);
        query.setLong("id", id == null ? -1L : id);

        return query.uniqueResult() != null;
    }
}
