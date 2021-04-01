package org.example.serialization;/**
 * TODO
 *
 * @author husi
 * @since 11/13/2020
 */

import java.io.Serializable;

/**
 *@ClassName Account
 *@Description TODO
 *@Date 11/13/2020 1:55 PM
 *@Version 1.0
 **/
public class Account2 implements Serializable {

  private String name;
  private int age;
  private long brithday;
  private String address;

  public Account2(String name, int age, long brithday) {
    this.name = name;
    this.age = age;
    this.brithday = brithday;
  }

  @Override
  public String toString() {
    return "Account{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", brithday=" + brithday +
        '}';
  }
}
