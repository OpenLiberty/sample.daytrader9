package com.ibm.websphere.samples.daytrader.impl.ejb3;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class AsyncScheduledOrderSubmitter {
  
  
  @Resource
  private ManagedScheduledExecutorService mes;

  @Inject
  private AsyncScheduledOrder asyncOrder;
  
  
  public Future<?> submitOrder(Integer orderID, boolean twoPhase) {
    asyncOrder.setProperties(orderID,twoPhase);
    return mes.schedule(asyncOrder,500,TimeUnit.MILLISECONDS);
  }
}
