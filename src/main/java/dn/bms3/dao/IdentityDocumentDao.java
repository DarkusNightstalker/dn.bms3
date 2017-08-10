package dn.bms3.dao;

import dn.bms3.dao.interfac.IIdentityDocumentDao;
import dn.bms3.model.IdentityDocument;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class IdentityDocumentDao
  extends GenericDao<IdentityDocument, Short>
  implements IIdentityDocumentDao
{}
