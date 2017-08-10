package dn.bms3.service.interfac;

import dn.bms3.model.Company;
import dn.bms3.model.Product;
import dn.bms3.model.ProductCostPrice;
import dn.bms3.model.User;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Darkus Nightmare
 * @version 1.0
 */
public interface IProductCostPriceService extends IGenericService<ProductCostPrice, Long> {

    public  Long getIdByCompanyProduct(Company company, Product product);

    public  BigDecimal getCostByCompanyProduct(Company paramCompany, Product paramProduct);
    public  BigDecimal getLastAcquisitionCost(Company paramCompany, Product paramProduct);

    public  void updateGroupCostByCompanyProduct(BigDecimal paramBigDecimal, Company paramCompany, Product paramProduct, User paramUser);

    public  List<Object[]> getCreatedByAfterDate(Date date, String companyCode);

    public  List<Object[]> getEditedByAfterDate(Date date, String companyCode, boolean b);
}

