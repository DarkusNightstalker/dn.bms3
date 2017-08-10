package dn.bms3.dao;

import dn.bms3.dao.interfac.IPaymentVoucherDao;
import dn.bms3.model.PaymentVoucher;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentVoucherDao
  extends GenericDao<PaymentVoucher, Long>
  implements IPaymentVoucherDao
{}

