package dn.bms3.service.interfac;

import dn.bms3.model.Company;
import dn.bms3.model.Product;
import dn.bms3.model.ProductSalePrice;
import dn.bms3.model.User;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IProductSalePriceService
        extends IGenericService<ProductSalePrice, Long> {

    public List<Object[]> getBasicDataByCompanyProduct(Company paramCompany, Product paramProduct);

    public void deleteByCompanyProduct(Company paramCompany, Product paramProduct);

    public void saveForGroup(BigDecimal price, Integer quantity, Company currentCompany, Product selected, User user);

    public List<Object[]> getCreatedByAfterDate(Date paramDate, String paramString);

    public BigDecimal getBasicPrice(Company currentCompany, Product product);
}


