package dn.bms3.service;

import dn.bms3.dao.interfac.IProductDao;
import dn.bms3.model.Product;
import dn.bms3.service.interfac.IProductService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Darkus Nightmare
 * @version 1.0
 */
@Service
public class ProductService extends GenericService<Product, Long> implements IProductService {

    @Autowired
    @Qualifier("productDao")
    private IProductDao dao;

    @Override
    protected IGenericDao<Product, Long> getDao() {
        return this.dao;
    }

    @Override
    public boolean existBarCode(String code, Long exception) {
        return this.dao.existBarCode(code, exception);
    }

    @Override
    public Product getByBarcode(String barcode) {
        return (Product) this.dao.getByHQL(""
                + "FROM Product p "
                + "WHERE p.barcode LIKE ?", barcode);
    }

    @Override
    public Object[] getAuditoryData(Long id) {
        return (Object[]) this.dao.getByHQL(""
                + "SELECT "
                    + "cu,"
                    + "p.createDate,"
                    + "eu,"
                    + "p.editDate "
                + "FROM Product p "
                    + "LEFT JOIN p.createUser as cu "
                    + "LEFT JOIN p.editUser as eu "
                + "WHERE p.id = ?", id);
    }

    @Override
    public List<Object[]> getSuppliersBasicData(Long id) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "s.id,"
                    + "s.ubigeo.name,"
                    + "s.identityDocument.abbr,"
                    + "s.identityNumber,"
                    + "s.name "
                + "FROM Product p "
                    + "join p.suppliers s "
                + "WHERE p.id = ?", id);
    }

    @Override
    public List<Object[]> getSellersBasicData(Long id) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "s.id,"
                    + "s.description,"
                    + "s.supplier.ubigeo.name,"
                    + "s.supplier.identityDocument.abbr,"
                    + "s.supplier.identityNumber,s.supplier.name  "
                + "FROM Product p "
                    + "join p.sellers s "
                + "WHERE "
                    + "p.id = ? AND "
                    + "s.active =true AND "
                    + "s.supplier.active = true", id);
    }

    @Override
    public List<String> getAllBarcodes() {
        return this.dao.listHQL(""
                + "SELECT "
                    + "p.barcode "
                + "FROM Product p "
                + "WHERE "
                    + "p.active = true");
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date date) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "p.id,"
                    + "p.barcode,"
                    + "p.name,"
                    + "p.description,"
                    + "p.stockType.id,"
                    + "p.stockType.code,"
                    + "p.uom.id,"
                    + "p.uom.code,"
                    + "p.active,"
                    + "p.createUser.id,"
                    + "p.createDate "
                + "FROM Product p "
                + "WHERE"
                    + " p.createDate > ? "
                + "ORDER BY p.createDate", date);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date date, boolean b) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "p.id,"
                    + "p.barcode,"
                    + "p.name,"
                    + "p.description,"
                    + "p.stockType.id,"
                    + "p.stockType.code,"
                    + "p.uom.id,"
                    + "p.uom.code,"
                    + "p.active,"
                    + "p.createUser.id,"
                    + "p.createDate,"
                    + "p.editUser.id,"
                    + "p.editDate "
                + "FROM Product p "
                + "WHERE "
                    + "p.editDate > ? AND "
                    + "p.createDate < ? "
                + "ORDER BY p.editDate", date);
    }
    
    @Override
    public List<Object[]> forAutocomplete(Integer quantity,String query) {
        return dao.listHQLPage(""
                + "SELECT "
                    + "p.id,"
                    + "p.barcode,"
                    + "p.name "
                + "FROM Product p "
                + "WHERE "
                    + "p.barcode LIKE ? OR "
                    + "LOWER(p.name) LIKE LOWER(?)", 1, quantity, "%"+query+"%","%"+query+"%");
    }
}
