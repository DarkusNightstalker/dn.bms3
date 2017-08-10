package dn.bms3.dao;

import dn.bms3.dao.interfac.IOperationTypeDao;
import dn.bms3.model.OperationType;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class OperationTypeDao
  extends GenericDao<OperationType, Short>
  implements IOperationTypeDao
{}

