package dn.bms3.service;

import dn.bms3.dao.interfac.IProductLineDao;
import dn.bms3.model.ProductLine;
import dn.bms3.service.interfac.IProductLineService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductLineService
        extends GenericService<ProductLine, Integer>
        implements IProductLineService {

    @Autowired
    @Qualifier("productLineDao")
    private IProductLineDao dao;

    protected IGenericDao<ProductLine, Integer> getDao() {
        return this.dao;
    }

    public boolean existPath(String path, Integer exception) {
        return this.dao.existPath(path, exception);
    }

    public List<Object[]> getBasicData() {
        return this.dao.listHQL("SELECT pl.id,UPPER(pl.path) FROM ProductLine pl where pl.active = true");
    }
}
