/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dn.bms3.dao;

import dn.bms3.dao.interfac.IDirectAccessDao;
import dn.bms3.model.DirectAccess;
import dn.core3.hibernate.generic.GenericDao;

/**
 *
 * @author Darkus Nightmare
 */
public class DirectAccessDao extends GenericDao<DirectAccess, Short> implements IDirectAccessDao {
    
}
