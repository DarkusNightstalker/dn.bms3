package dn.bms3.dao.interfac;

import dn.bms3.model.ElectronicBook;
import dn.core3.hibernate.generic.interfac.IGenericDao;

public interface IElectronicBookDao extends IGenericDao<ElectronicBook, Short> {

    public boolean existCode(String paramString, Short paramShort);
}
