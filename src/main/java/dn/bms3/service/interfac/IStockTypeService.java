package dn.bms3.service.interfac;

import dn.bms3.model.StockType;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IStockTypeService
        extends IGenericService<StockType, Short> {

    public StockType getByCode(String paramString);

    public List<Object[]> getBasicData();

    public Short getIdByCode(String paramString);

    public List<Object[]> getCreatedByAfterDate(Date paramDate);

    public List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);
}
