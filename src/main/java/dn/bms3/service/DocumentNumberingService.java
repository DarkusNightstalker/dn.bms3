package dn.bms3.service;

import dn.bms3.dao.interfac.IDocumentNumberingDao;
import dn.bms3.model.DocumentNumbering;
import dn.bms3.model.User;
import dn.bms3.service.interfac.IDocumentNumberingService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DocumentNumberingService extends GenericService<DocumentNumbering, Integer> implements IDocumentNumberingService {

    @Autowired
    @Qualifier("documentNumberingDao")
    private IDocumentNumberingDao dao;

    @Override
    protected IGenericDao<DocumentNumbering, Integer> getDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getDataByUser(User user, String ruc) {
        return this.dao.getDataByUser(user, ruc);
    }

    @Override
    public List<Object[]> getListData() {
        return this.dao.listHQL("SELECT "
                + "dn.id,"
                + "dn.paymentProof.id,"
                + "dn.rucCompany,"
                + "dn.serie,"
                + "dn.numbering,"
                + "dn.electronic FROM DocumentNumbering dn ");
    }
}
