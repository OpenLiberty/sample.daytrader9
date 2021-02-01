/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.websphere.samples.daytrader.web.prims.beanval;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SimpleBean1 {
  /**
   * Logging support and the static initializer for this class. Used to trace file
   * version information. This will display the current version of the class in the
   * debug log at the time the class is loaded.
   */
  private static final String thisClass = SimpleBean1.class.getName();
  private static Logger traceLogger = Logger.getLogger(thisClass);
  private static ValidatorFactory validatorFactory = null;
  private Validator validator;

  @Min(1)
  int iMin = 1;
  @Max(1)
  Integer iMax = 1;
  @Size(min = 1)
  int[] iMinArray = { 1 };
  @Size(max = 1)
  Integer[] iMaxArray = { 1 };
  @Pattern(regexp = "[a-z][a-z]*", message = "go to your room!")
  String pattern = "mypattern";

  

  boolean setToFail = false;

  

  public SimpleBean1() throws Exception {
    if (validatorFactory == null) {
      Context nContext = new InitialContext();
      validatorFactory = (ValidatorFactory) nContext.lookup("java:comp/ValidatorFactory");
      
    }
    validator = validatorFactory.getValidator();
  }

  @NotNull
  public String getDesc() {
    return pattern;
  }

  public void checkInjectionValidation() {

    traceLogger.entering(thisClass, "checkInjectionValidation", this);
   
    Set<ConstraintViolation<SimpleBean1>> cvSet = validator.validate(this);

    if (!cvSet.isEmpty()) {
      String msg = formatConstraintViolations(cvSet);
      traceLogger.log(Level.INFO, "Some reason cvSet was not null: " + cvSet + ", " + msg);

      throw new IllegalStateException("validation should not have found constraints: " + msg);
    }

    traceLogger.exiting(thisClass, "checkInjectionValidation ");
  }


  @Override
  public String toString() {
    String result = "iMin:" + iMin + " iMax:" + iMax + " iMinArray:" + iMinArray + " iMaxArray:" + iMaxArray + " pattern:" + pattern
        + " setToFail:" + setToFail;

    return result;
  }

  /**
   * Convert the constraint violations for use within WAS diagnostic logs.
   *
   * @return a String representation of the constraint violations formatted one per line and uniformly indented.
   */
  public String formatConstraintViolations(Set<ConstraintViolation<SimpleBean1>> cvSet) {
    traceLogger.entering(thisClass, "formatConstraintViolations " + cvSet);

    StringBuffer msg = new StringBuffer();
    for (ConstraintViolation<SimpleBean1> cv : cvSet) {
      msg.append("\n\t" + cv.toString());
    }

    traceLogger.exiting(thisClass, "formatConstraintViolations " + msg);
    return msg.toString();
  }
}
