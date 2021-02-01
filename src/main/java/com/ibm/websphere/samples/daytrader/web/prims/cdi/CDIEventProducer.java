package com.ibm.websphere.samples.daytrader.web.prims.cdi;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.inject.Inject;

@ApplicationScoped //?
public class CDIEventProducer {

  @Resource
  private ManagedExecutorService mes;

  @Inject
  @Hit
  Event<String> hitCountEvent;
  
  @Inject
  @HitAsync
  Event<String> hitCountEventAsync;
  
  public void produceSyncEvent() {
    hitCountEvent.fire("hitCount++");
  }

  public void produceAsyncEvent() {
    hitCountEventAsync.fireAsync("hitCount++", NotificationOptions.builder().setExecutor(mes).build());
  }
  
  

}
