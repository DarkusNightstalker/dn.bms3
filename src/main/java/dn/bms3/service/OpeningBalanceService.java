package dn.bms3.service;

import dn.bms3.dao.interfac.IOpeningBalanceDao;
import dn.bms3.model.Company;
import dn.bms3.model.OpeningBalance;
import dn.bms3.model.OperationType;
import dn.bms3.model.Product;
import dn.bms3.model.UoM;
import dn.bms3.model.User;
import dn.bms3.service.interfac.IOpeningBalanceService;
import dn.bms3.service.interfac.IOperationTypeService;
import gkfire.auditory.Auditory;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import gkfire.util.Month;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OpeningBalanceService
        extends GenericService<OpeningBalance, Long>
        implements IOpeningBalanceService {

    @Autowired
    @Qualifier("openingBalanceDao")
    private IOpeningBalanceDao dao;
    @Autowired
    @Qualifier("operationTypeService")
    private IOperationTypeService operationTypeService;

    protected IGenericDao<OpeningBalance, Long> getDao() {
        return this.dao;
    }

    public void generate(Integer year, Month month, Integer companyId, User user) {
        List<Object[]> data = this.dao.listHQL("SELECT st.product.id,st.quantity,st.product.uom.id,COALESCE((SELECT pcp.cost FROM ProductCostPrice pcp WHERE pcp.product = st.product AND pcp.company = st.company),0) as cost FROM Stock st WHERE st.product.active = true AND st.quantity > 0 AND st.company.id = ?", new Object[]{companyId});

        for (Object[] item : data) {
            OpeningBalance ob = new OpeningBalance();
            ob.setCompany(new Company(companyId));
            ob.setMonth(month);
            ob.setOperationType(new OperationType(this.operationTypeService.getOpeningBalanceTypeId()));
            ob.setProduct(new Product((Long) item[0]));
            ob.setQuantity((BigDecimal) item[1]);
            ob.setUnitCost((BigDecimal) item[3]);
            ob.setTotalCost(new BigDecimal(ob.getQuantity().doubleValue() * ob.getUnitCost().doubleValue()).setScale(2, RoundingMode.HALF_UP));
            ob.setUom(new UoM((Integer) item[2]));
            ob.setYear(year);
            Auditory.make(ob, user);
            this.dao.saveOrUpdate(ob);
        }
    }
}
