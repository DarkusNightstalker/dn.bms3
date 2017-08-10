package dn.bms3.service.interfac;

import dn.bms3.model.Company;
import dn.bms3.model.Purchase;
import dn.bms3.model.PurchasePayment;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;

public interface IPurchasePaymentService extends IGenericService<PurchasePayment, Long> {

    public abstract BigDecimal getSumAfterByCompany(Date paramDate, Company paramCompany);

    public BigDecimal getCurrentPay(Purchase selected);
}