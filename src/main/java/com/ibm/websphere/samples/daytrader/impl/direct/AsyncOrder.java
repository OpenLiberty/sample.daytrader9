package com.ibm.websphere.samples.daytrader.impl.direct;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.UserTransaction;

import com.ibm.websphere.samples.daytrader.interfaces.TradeJDBC;
import com.ibm.websphere.samples.daytrader.interfaces.TradeServices;

@Dependent
public class AsyncOrder implements Runnable {

  @Inject
  @TradeJDBC
  TradeServices tradeService;

  @Resource
  UserTransaction ut;
      
  Integer orderID;
  boolean twoPhase;
  
  public void setProperties(Integer orderID, boolean twoPhase) {
    this.orderID = orderID;
    this.twoPhase =  twoPhase;
  }     
  
  @Override
  public void run() {
        
        
    try {  
      ut.begin();
      tradeService.completeOrder(orderID, twoPhase);      
      ut.commit();
    } catch (Exception e) {
      
      try {
        ut.rollback();
      } catch (Exception e1) {
        try {
          throw new Exception(e1);
        } catch (Exception e2) {
          e2.printStackTrace();
        }
      } 
      try {
        throw new Exception(e);
      } catch (Exception e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    } 
  }
}
