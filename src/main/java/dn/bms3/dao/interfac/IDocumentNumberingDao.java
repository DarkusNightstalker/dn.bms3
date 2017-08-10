package dn.bms3.dao.interfac;

import dn.bms3.model.DocumentNumbering;
import dn.bms3.model.User;
import dn.core3.hibernate.generic.interfac.IGenericDao;
import java.util.List;

public interface IDocumentNumberingDao
        extends IGenericDao<DocumentNumbering, Integer> {

    public List<Object[]> getDataByUser(User paramUser, String paramString);
}
