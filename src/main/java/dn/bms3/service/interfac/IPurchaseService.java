package dn.bms3.service.interfac;

import dn.bms3.model.Purchase;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.List;

public interface IPurchaseService extends IGenericService<Purchase, Long> {

    public List<Object[]> forAutocomplete(int quantity, String query, Long idSupplier);

    public List<Object[]> getBasicData(Long idSupplier);

    public void clean() throws Exception;

}
