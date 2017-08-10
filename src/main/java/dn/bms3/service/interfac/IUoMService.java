package dn.bms3.service.interfac;

import dn.bms3.model.UoM;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IUoMService
        extends IGenericService<UoM, Integer> {

    public boolean existName(String paramString, Integer paramInteger);

    public boolean existAbbr(String paramString, Integer paramInteger);

    public boolean existCode(String paramString, Integer paramInteger);

    public Integer getIdByCode(String paramString);

    public List<Object[]> getBasicData();

    public List<Object[]> getCreatedByAfterDate(Date paramDate);

    public List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IUoMService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
