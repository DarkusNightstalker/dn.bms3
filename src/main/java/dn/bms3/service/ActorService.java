package dn.bms3.service;

import dn.bms3.dao.interfac.IActorDao;
import dn.bms3.model.Actor;
import dn.bms3.model.User;
import dn.bms3.service.interfac.IActorService;
import dn.core3.hibernate.generic.GenericService;
import dn.core3.hibernate.generic.interfac.IGenericDao;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Darkus Nightmare
 */
@Service
public class ActorService extends GenericService<Actor, Long> implements IActorService {

    @Autowired
    @Qualifier("actorDao")
    private IActorDao actorDao;


    @Override
    protected IGenericDao<Actor, Long> getBasicDao() {
        return this.actorDao;
    }

    @Override
    public void updateNameByIdentityDocument(String identityNumber, String name) {
        this.actorDao.updateHQL(""
                + "UPDATE Actor "
                + "SET "
                    + "name = ?,"
                    + "synchronized_ = true "
                + "WHERE identityNumber LIKE ?", name, identityNumber);
    }

    @Override
    public List<Object[]> getIdentityDataForSynchro(String... identityDocumentCodes) {
        return this.actorDao.listHQL(""
                + "SELECT "
                    + "a.identityNumber,"
                    + "a.identityDocument.code "
                + "FROM Actor a "
                + "WHERE "
                    + "a.synchronized_ = false AND "
                    + "a.identityDocument.code IN (:codes)", new String[]{"codes"},Arrays.asList(identityDocumentCodes));
    }

    @Override
    public Long countIdentityDataForSynchro(String... identityDocumentCodes) {
        return (Long) this.actorDao.getByHQL(""
                + "SELECT "
                    + "COUNT(*) "
                + "FROM Actor a "
                + "WHERE "
                    + "a.synchronized_ = false AND "
                    + "a.identityDocument.code IN (:codes)", new String[]{"codes"},Arrays.asList(identityDocumentCodes));
    }

    @Override
    public Actor getByIdentityNumber(String identityNumber) {
        return (Actor) this.actorDao.getByHQL(""
                + "FROM Actor a "
                + "WHERE a.identityNumber Like ?", new Object[]{identityNumber});
    }

    @Override
    public boolean verifyIdentityNumber(String identityNumber, Long id) {
        return this.actorDao.getByHQL(""
                + "SELECT "
                    + "1 "
                + "FROM Actor a "
                + "WHERE "
                    + "a.identityNumber LIKE ? AND "
                    + "a.id <> ?", identityNumber, id == null ? -1L : id) != null;
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date date) {
        return this.actorDao.listHQL(""
                + "SELECT "
                    + "a.id,"
                    + "a.identityNumber,"
                    + "a.identityDocument.id,"
                    + "a.identityDocument.code,"
                    + "a.name,"
                    + "a.other,"
                    + "a.address,"
                    + "a.points,"
                    + "a.customer,"
                    + "a.supplier,"
                    + "a.synchronized,"
                    + "a.active,"
                    + "a.createUser.id,"
                    + "a.createDate "
                + "FROM Actor a "
                + "WHERE a.createDate > ?", date);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date date, boolean withRecentlyCreated) {
        return this.actorDao.listHQL(""
                + "SELECT "
                    + "a.id,"
                    + "a.identityNumber,"
                    + "a.identityDocument.id,"
                    + "a.identityDocument.code,"
                    + "a.name,"
                    + "a.other,"
                    + "a.address,"
                    + "a.points,"
                    + "a.customer,"
                    + "a.supplier,"
                    + "a.synchronized,"
                    + "a.active,"
                    + "a.createUser.id,"
                    + "a.createDate,"
                    + "a.editUser.id,"
                    + "a.editDate "
                + "FROM Actor a "
                + "WHERE "
                    + "a.createDate < ? AND "
                    + "a.editDate > ?", date, date);
    }

    @Override
    public void subtractPoints(Long id, Long points, User user) {
        this.actorDao.updateHQL(""
                + "UPDATE Actor a "
                + "SET "
                    + "points = (points - ?),"
                    + "editDate = ?,"
                    + "editUser = ? "
                + "WHERE id = ?", points, new Date(), user, id);
    }

    @Override
    public void addPoints(Long id, Long points, User user) {
        this.actorDao.updateHQL(""
                + "UPDATE Actor a "
                + "SET "
                    + "points = (points + ?),"
                    + "editDate = ?,"
                    + "editUser = ? "
                + "WHERE id = ?", points, new Date(), user, id);
    }

    @Override
    public Long getIdByIdentityNumber(String identityNumber) {
        return (Long) this.actorDao.getByHQL(""
                + "SELECT "
                    + "a.id "
                + "FROM Actor a "
                + "WHERE a.identityNumber LIKE ?",identityNumber);
    }

    @Override
    public List<Object[]> forAutocomplete(Integer quantity,String query) {
        return actorDao.listHQLPage(""
                + "SELECT "
                    + "a.id,"
                    + "a.identityDocument.abbr,"
                    + "a.identityNumber,"
                    + "COALESCE(a.other,a.name),"
                    + "a.points "
                + "FROM Actor a "
                + "WHERE "
                    + "LOWER(COALESCE(a.other,a.name)) LIKE LOWER(?) OR "
                    + "a.identityNumber LIKE ?", 1, quantity, "%"+query+"%","%"+query+"%");
    }

    @Override
    public List<Object[]> forSupplierAutocomplete(Integer quantity, String query) {
        return actorDao.listHQLPage(""
                + "SELECT "
                    + "a.id,"
                    + "a.identityDocument.abbr,"
                    + "a.identityNumber,"
                    + "COALESCE(a.other,a.name),"
                    + "u.name,"
                    + "a.address  "
                + "FROM Actor a left join a.ubigeo u "
                + "WHERE "
                + "a.supplier = true AND "
                + "("
                    + "LOWER(COALESCE(a.other,a.name)) LIKE LOWER(?) OR "
                    + "a.identityNumber LIKE ?"
                + ")", 1, quantity, "%"+query+"%","%"+query+"%");
    }

    @Override
    public Long countNotUploaded() {
        return (Long) actorDao.getByHQL("SELECT COUNT(a.id) FROM Actor a WHERE a.uploaded = false");
    }

    @Override
    public void completeUploaded() {
        actorDao.updateHQL("UPDATE Actor a SET a.uploaded = ? WHERE a.uploaded = ?",true,false);
    }
}
