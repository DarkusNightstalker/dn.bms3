package dn.bms3.service;

import dn.bms3.dao.interfac.ICountryDao;
import dn.bms3.model.Country;
import dn.bms3.service.interfac.ICountryService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CountryService
        extends GenericService<Country, Integer>
        implements ICountryService {

    @Autowired
    @Qualifier("countryDao")
    private ICountryDao dao;

    protected IGenericDao<Country, Integer> getDao() {
        return this.dao;
    }
}
