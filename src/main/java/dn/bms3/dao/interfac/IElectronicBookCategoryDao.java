package dn.bms3.dao.interfac;

import dn.bms3.model.ElectronicBookCategory;
import dn.core3.hibernate.generic.interfac.IGenericDao;

public interface IElectronicBookCategoryDao extends IGenericDao<ElectronicBookCategory, Short> {

    public boolean existCode(String paramString, Short paramShort);
}
