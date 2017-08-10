package dn.bms3.service;

import dn.bms3.dao.interfac.IOperationTypeDao;
import dn.bms3.model.OperationType;
import dn.bms3.service.interfac.IOperationTypeService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OperationTypeService
        extends GenericService<OperationType, Short>
        implements IOperationTypeService {

    @Autowired
    @Qualifier("operationTypeDao")
    private IOperationTypeDao dao;

    protected IGenericDao<OperationType, Short> getDao() {
        return this.dao;
    }

    public Short getOpeningBalanceTypeId() {
        return (Short) this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[]{"16"});
    }

    public Short getSaleTypeId() {
        return (Short) this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[]{"01"});
    }

    public Short getPurchaseTypeId() {
        return (Short) this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[]{"02"});
    }

    public Short getISMInTypeId() {
        return (Short) this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[]{"21"});
    }

    public Short getISMOutTypeId() {
        return (Short) this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[]{"11"});
    }

    public Short getDecreaseTypeId() {
        return (Short) this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[]{"13"});
    }

    public Short getCustomerReturnTypeId() {
        return (Short) this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[]{"24"});
    }

    public Short getSupplierReturnTypeId() {
        return (Short) this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[]{"25"});
    }
}
