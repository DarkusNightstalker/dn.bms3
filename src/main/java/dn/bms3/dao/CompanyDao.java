package dn.bms3.dao;

import dn.bms3.dao.interfac.ICompanyDao;
import dn.bms3.model.Company;
import dn.core3.hibernate.generic.GenericDao;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao  extends GenericDao<Company, Integer> implements ICompanyDao {

    @Override
    public List<Object[]> getDataByList(List<Long> ids) {
//        if(paramList.isEmpty()) return Collections.EMPTY_LIST;
//        List<Integer> iids= Lists.transform(paramList,new Function<Long,Integer>(){
//            @Override
//            public Integer apply(Long o) {
//                return o.intValue();
//            }
//        });
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT c.id,c.name,c.city,c.address FROM Company c WHERE c.active = true AND c.id IN :ids ORDER BY c.code");
        query.setParameterList("ids", ids);
        
        return query.list();
    }
}
