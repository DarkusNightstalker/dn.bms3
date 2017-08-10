package dn.bms3.service.interfac;

import dn.bms3.model.IdentityDocument;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IIdentityDocumentService extends IGenericService<IdentityDocument, Short> {

    /**
     *
     * @param paramString
     * @param paramShort
     * @return
     */
    public boolean validCode(String paramString, Short paramShort);

    public List<Object[]> getBasicData();

    public Short getIdByLength(int paramInt);

    public List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);

    public List<Object[]> getCreateByAfterDate(Date paramDate);

    public Short getIdByCode(String string);
}
