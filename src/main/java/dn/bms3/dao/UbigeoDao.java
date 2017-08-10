/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dn.bms3.dao;

import dn.bms3.dao.interfac.IUbigeoDao;
import dn.bms3.model.Ubigeo;
import dn.core3.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Darkus Nightmare
 */
@Repository
public class UbigeoDao extends GenericDao<Ubigeo, Integer> implements IUbigeoDao {

    @Override
    public void saveOrUpdate(Ubigeo object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int save(Ubigeo object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Ubigeo object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Ubigeo object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int updateHQL(String hql) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int updateHQL(String hql, Object... parameters) {
        throw new UnsupportedOperationException();
    }
}
