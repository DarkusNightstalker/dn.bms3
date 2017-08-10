package dn.bms3.service.interfac;

import dn.bms3.model.Actor;
import dn.bms3.model.Product;
import dn.bms3.model.Seller;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.List;

public interface ISellerService extends IGenericService<Seller, Long> {

    public List<Long> getIdsByProduct(Product paramProduct);

    public Seller getByDescSupplier(String paramString, Actor paramActor);

    public Seller getByDefaulSupplier(Actor paramActor);
}
