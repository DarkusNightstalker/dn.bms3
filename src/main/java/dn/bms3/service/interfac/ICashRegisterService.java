package dn.bms3.service.interfac;

import dn.bms3.model.CashRegister;
import dn.bms3.model.Company;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.Date;

public  interface ICashRegisterService extends IGenericService<CashRegister, Long> {

    public Date getLastDate(Company paramCompany);
}
