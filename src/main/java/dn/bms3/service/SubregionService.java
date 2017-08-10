/*    */ package dn.bms3.service;
/*    */ 
/*    */ import dn.bms3.dao.interfac.ISubregionDao;
/*    */ import dn.bms3.model.Subregion;
/*    */ import dn.bms3.service.interfac.ISubregionService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
@Service
/*    */ public class SubregionService
/*    */   extends GenericService<Subregion, Integer>
/*    */   implements ISubregionService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("subregionDao")
/*    */   private ISubregionDao dao;
/*    */   
/*    */   protected IGenericDao<Subregion, Integer> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\SubregionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */