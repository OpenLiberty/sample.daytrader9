package com.ibm.websphere.samples.daytrader.impl.direct;

import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class AsyncOrderSubmitter {
  
  
  @Resource
  private ManagedExecutorService mes;

  @Inject
  private AsyncOrder asyncOrder;
  
  
  public Future<?> submitOrder(Integer orderID, boolean twoPhase) {
    asyncOrder.setProperties(orderID,twoPhase);
    return mes.submit(asyncOrder);
  }
}
