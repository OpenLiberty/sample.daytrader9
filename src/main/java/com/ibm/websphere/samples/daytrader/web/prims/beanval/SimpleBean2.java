package com.ibm.websphere.samples.daytrader.web.prims.beanval;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

public class SimpleBean2 extends SimpleBean1 {

  private List<@PositiveOrZero Integer> numbers= new ArrayList<Integer>();
  private List<@NotBlank String> strings = new ArrayList<String>();
    
  @PastOrPresent 
  LocalDateTime now = LocalDateTime.now();
  
  @FutureOrPresent
  LocalDateTime future = LocalDateTime.now().plusDays(1);
      
  public SimpleBean2() throws Exception {
    super();

    numbers.add(1);
    numbers.add(2);
    
    strings.add("string1");
    strings.add("string2");
  }
}
