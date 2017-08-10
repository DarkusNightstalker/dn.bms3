package dn.bms3.dao.interfac;

import dn.bms3.enumerated.CashType;
import dn.bms3.model.CashRegisterDetail;
import dn.core3.hibernate.generic.interfac.IGenericDao;
import java.io.Serializable;

public interface ICashRegisterDetailDao extends IGenericDao<CashRegisterDetail, Serializable> {

    public Integer getQuantity(Long id, CashType cashType);
}
