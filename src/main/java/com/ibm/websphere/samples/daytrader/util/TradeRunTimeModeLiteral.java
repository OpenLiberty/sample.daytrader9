package com.ibm.websphere.samples.daytrader.util;

import javax.enterprise.util.AnnotationLiteral;

import com.ibm.websphere.samples.daytrader.interfaces.RuntimeMode;

public class TradeRunTimeModeLiteral extends AnnotationLiteral<RuntimeMode> implements RuntimeMode {
    /**
   * 
   */
  private static final long serialVersionUID = -252789556335033400L;
    private String value;
    public TradeRunTimeModeLiteral(String value) {
        this.value = value;
    }

    @Override
    public String value() {
         return value;
    }

}