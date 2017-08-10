package dn.bms3.dao;

import dn.bms3.dao.interfac.IActorDao;
import dn.bms3.model.Actor;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class ActorDao extends GenericDao<Actor, Long> implements IActorDao {
}
