package dn.bms3.service.interfac;

import dn.bms3.model.District;
import dn.core3.hibernate.generic.interfac.IGenericService;

public interface IDistrictService extends IGenericService<District, Integer> {    
    public String getUbigeoNameById(Integer id);
}
