package org.example;

import java.util.Optional;
import org.junit.Test;

public class OptionalTest {

  @Test
  public void test(){
    Optional<String> optional = Optional.empty();
    if(optional.isPresent()){
      System.out.println("It is not empty");
    }else{
      System.out.println("It is empty");
    }
    String name = "susie";
    optional = Optional.of(name);
    if(optional.isPresent()){
      System.out.println("It is not empty");
      String value = optional.get();
      System.out.println(value);
    }else{
      System.out.println("It is empty");
    }
  }

}
