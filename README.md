## This has moved to the public: https://github.com/OpenLiberty/sample.daytrader8. I will probably leave this here for awhile, but will eventually delete.


# daytrader8
## Changes since daytrader7
1. Moved the ejb.jar into the war to simplify deployment. No more ear.
2. Also moved some classes from the ejb to to war. EJB only conatined EJB code and classes needed by it (and some needed by the war).
3. Added CDI everywhere. Now the 2 main impls (TradeDirect and TradeSLSBBean) are CDI beans and are injected into to components that need them. TradeDirect has also been updated to not do lookups anymore.
4. Added a CDI Intereceptor to log method entries.
5. Got rid of the trace/action trace, just enabled daytrader=fine to trace.
6. Improved async mode to use Managed(Scheduled)Executor service.
7. Changed the JMSMessage event to be async (new in CDI 2.0)
8. Added HTTP/2 primitive.
9. Separated DB reset/build code out from TradeDirect.
10. Added JAX-RS 2.1 code
11. Added beanvalidation 2.0 annotations
12. Enabled jsf 2.3 cdi integration

## EE8 Features

### Servlet 4.0
1. Added http/2 primitive
2. TODO: Get http/2 into full end2end benchmark

### CDI 2.0
1. Added 2 async events
    *   TradeSLSBBean/TradeDirect -> MarketSummary WebSocket
    *   RecentQuotePriceChangeList.add -> MarketSummary WebSocket and JAX-RS Broadcaster
2. TODO: ?

### JAX-RS 2.1
1. added JAX-RS primitive from jaxrsbench (this should hit JAX-RS 2.1, JSONP 1.1, and JSONB 1.0)
2. Added Broadcaster and SSE (Server Side Events), but not sure how to test this with JMeter...
3. Added simple JAX-RS quote lookup api.

### JSONP 1.1?
1. See JAX-RS 2.1

### JSONB 1.0?
1. See JAX-RS 2.1

### JPA 2.2?

### Bean Validation 2.0
1. Added more 1.0 and 2.0 annotations to the entities (validated in ejb3 mode)
2. TODO: Add annotatins to jsf code?

### JSF 2.3
1. Enabled jsf-2.3 cdi integration and now injecting ExternalContext.
2. TODO: ?
