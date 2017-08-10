package dn.bms3.service.interfac;

import dn.bms3.model.Company;
import dn.bms3.model.Product;
import dn.bms3.model.Stock;
import dn.bms3.model.User;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IStockService
        extends IGenericService<Stock, Long> {

    public void substractQuantity(BigDecimal paramBigDecimal, Product paramProduct, Company paramCompany, User paramUser);

    public void addQuantity(BigDecimal paramBigDecimal, Product paramProduct, Company paramCompany, User paramUser);

    public Long getIdByCompanyProduct(Company paramCompany, Product paramProduct);

    public BigDecimal getGroupQuantityByCompanyProduct(Company paramCompany, Product paramProduct);

    public List<Object[]> getCreatedByAfterDate(Date paramDate, String paramString);

    public List<Object[]> getEditedByAfterDate(Date paramDate, String paramString, boolean paramBoolean);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IStockService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
