package dn.bms3.dao.interfac;

import dn.bms3.model.PaymentProof;
import dn.core3.hibernate.generic.interfac.IGenericDao;

public interface IPaymentProofDao extends IGenericDao<PaymentProof, Short> {

    public boolean existCode(String code, Short except);

    public Short getIdByAbbr(String abbr);
}
