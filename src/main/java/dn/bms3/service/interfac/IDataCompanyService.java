package dn.bms3.service.interfac;

import dn.bms3.model.DataCompany;
import dn.core3.hibernate.generic.interfac.IGenericService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public interface IDataCompanyService extends IGenericService<DataCompany, Integer> {

    public String getStringValue(String propertyName) throws IOException, ClassNotFoundException;

    public Integer getIntValue(String propertyName) throws IOException, ClassNotFoundException;

    public Long getLongValue(String propertyName) throws IOException, ClassNotFoundException;

    public Double getDoubleValue(String propertyName) throws IOException, ClassNotFoundException;

    public BigDecimal getBigDecimalValue(String propertyName) throws IOException, ClassNotFoundException;

    public Date getDateValue(String propertyName) throws IOException, ClassNotFoundException;

    public Object getValue(String propertyName) throws IOException, ClassNotFoundException;

    public void saveOrUpdate(String propertyName, Object value) throws IOException, ClassNotFoundException;

    public Boolean getBooleanValue(String propertyName)  throws IOException, ClassNotFoundException;
}
