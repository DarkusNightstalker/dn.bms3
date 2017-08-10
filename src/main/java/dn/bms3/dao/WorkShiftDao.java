package dn.bms3.dao;

import dn.bms3.dao.interfac.IWorkShiftDao;
import dn.bms3.model.WorkShift;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class WorkShiftDao extends GenericDao<WorkShift, Integer> implements IWorkShiftDao {
}
