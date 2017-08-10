/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dn.bms3.dao.interfac;

import dn.bms3.model.Ubigeo;
import dn.core3.hibernate.generic.interfac.IGenericDao;

/**
 *
 * @author Darkus Nightmare
 */
public interface IUbigeoDao extends IGenericDao<Ubigeo, Integer> {

    @Override
    default void saveOrUpdate(Ubigeo object){
        throw new UnsupportedOperationException();
    }
    
    @Override
    default int save(Ubigeo object){
        throw new UnsupportedOperationException();
    }
    
    @Override
    default void update(Ubigeo object){
        throw new UnsupportedOperationException();
    }
    @Override
    default void delete(Ubigeo object){
        throw new UnsupportedOperationException();
    }
    
}
