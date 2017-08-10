/*    */ package dn.bms3.service;
/*    */ 
/*    */ import dn.bms3.dao.interfac.IRegionDao;
/*    */ import dn.bms3.model.Region;
/*    */ import dn.bms3.service.interfac.IRegionService;
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
/*    */ public class RegionService
/*    */   extends GenericService<Region, Integer>
/*    */   implements IRegionService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("regionDao")
/*    */   private IRegionDao dao;
/*    */   
/*    */   protected IGenericDao<Region, Integer> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\RegionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */