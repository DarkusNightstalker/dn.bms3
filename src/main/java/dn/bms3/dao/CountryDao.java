package dn.bms3.dao;

import dn.bms3.dao.interfac.ICountryDao;
import dn.bms3.model.Country;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao
  extends GenericDao<Country, Integer>
  implements ICountryDao
{}

