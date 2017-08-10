package dn.bms3.service;

import dn.bms3.dao.interfac.IPaymentProofDao;
import dn.bms3.model.PaymentProof;
import dn.bms3.service.interfac.IPaymentProofService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentProofService extends GenericService<PaymentProof, Short> implements IPaymentProofService {

    @Autowired
    @Qualifier("paymentProofDao")
    private IPaymentProofDao dao;

    @Override
    public boolean existCode(String code, Short id) {
        return this.dao.existCode(code, id);
    }

    @Override
    protected IGenericDao<PaymentProof, Short> getDao() {
        return this.dao;
    }

    @Override
    public Short getIdByAbbr(String abbr) {
        return this.dao.getIdByAbbr(abbr);
    }

    @Override
    public List<Object[]> getCreateByAfterDate(Date date) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "pp.id,"
                    + "pp.code,"
                    + "pp.abbr,"
                    + "pp.name,"
                    + "pp.forSale,"
                    + "pp.forPurchase,"
                    + "pp.forStored,"
                    + "pp.forReturn,"
                    + "pp.active,"
                    + "pp.createUser.id,"
                    + "pp.createDate "
                + "FROM PaymentProof pp "
                + "WHERE pp.createDate > ?", new Object[]{date});
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date date, boolean b) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "pp.id,"
                    + "pp.code,"
                    + "pp.abbr,"
                    + "pp.name,"
                    + "pp.forSale,"
                    + "pp.forPurchase,"
                    + "pp.forStored,"
                    + "pp.forReturn,"
                    + "pp.active,"
                    + "pp.createUser.id,"
                    + "pp.createDate,"
                    + "pp.editUser.id,"
                    + "pp.editDate "
                + "FROM PaymentProof pp "
                + "WHERE pp.createDate < ? and pp.editDate > ?", date, date);
    }

    @Override
    public Short getIdByCode(String code) {
        return (Short) this.dao.getByHQL(""
                + "SELECT "
                    + "pp.id "
                + "FROM PaymentProof pp "
                + "WHERE pp.code LIKE ?", code);
    }

    @Override
    public List<Object[]> getForReturn() {
        return this.dao.listHQL(""
                + "SELECT "
                    + "pp.id,"
                    + "pp.abbr,"
                    + "pp.name "
                + "FROM PaymentProof pp "
                + "WHERE "
                    + "pp.active = true AND "
                    + "pp.forReturn = true");
    }
}
