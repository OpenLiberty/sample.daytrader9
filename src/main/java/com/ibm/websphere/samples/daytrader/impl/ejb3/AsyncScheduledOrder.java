package com.ibm.websphere.samples.daytrader.impl.ejb3;


import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.ibm.websphere.samples.daytrader.interfaces.TradeServices;
import com.ibm.websphere.samples.daytrader.util.TradeConfig;
import com.ibm.websphere.samples.daytrader.util.TradeRunTimeModeLiteral;


@Dependent
public class AsyncScheduledOrder implements Runnable {

  TradeServices tradeService;

  Integer orderID;
  boolean twoPhase;

  @Inject 
  public AsyncScheduledOrder(@Any Instance<TradeServices> services) {
    tradeService = services.select(new TradeRunTimeModeLiteral(TradeConfig.getRunTimeModeNames()[TradeConfig.getRunTimeMode()])).get();
  }

  public void setProperties(Integer orderID, boolean twoPhase) {
    this.orderID = orderID;
    this.twoPhase =  twoPhase;
  }     

  @Override
  public void run() {


    try {  
      tradeService.completeOrder(orderID, twoPhase);      

    } catch (Exception e) {

      e.printStackTrace();
    }
  }
}
