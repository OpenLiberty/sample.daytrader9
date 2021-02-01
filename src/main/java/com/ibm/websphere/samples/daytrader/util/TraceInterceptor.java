package com.ibm.websphere.samples.daytrader.util;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Arrays;

import javax.annotation.Priority;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.ibm.websphere.samples.daytrader.interfaces.Trace;


@Trace 
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class TraceInterceptor implements Serializable {

  private static final long serialVersionUID = -4195975993998268072L;
  private static final MessageFormat form = new MessageFormat("Method enter -- {0} called with {1}");

  @AroundInvoke
  public Object logMethodEntry(InvocationContext ctx) throws Exception {
    Log.trace(form.format(
        new String[]{
            ctx.getMethod().getDeclaringClass().getSimpleName() + ":"+ ctx.getMethod().getName(),
            Arrays.deepToString(ctx.getParameters())
    }));

    return ctx.proceed();
  }
}
