package dn.bms3.service.interfac;

import dn.bms3.model.InternalStockMovement;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IInternalStockMovementService extends IGenericService<InternalStockMovement, Long> {

    public List<Object[]> getCreatedByAfterDate(Date paramDate, String paramString);

    public List<Object[]> getEditedByAfterDate(Date paramDate, String paramString, boolean paramBoolean);

    public Long countNotUploaded();

    public void completeUploaded();

}
