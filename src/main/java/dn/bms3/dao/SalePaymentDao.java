package dn.bms3.dao;

import dn.bms3.dao.interfac.ISalePaymentDao;
import dn.bms3.model.SalePayment;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

/**
 * Implementación DAO para el modelo SALE PAYMENT
 * 
 * @author Darkus Nightmare
 * @version 1.0
 */
@Repository
public class SalePaymentDao extends GenericDao<SalePayment, Long> implements ISalePaymentDao {
}
