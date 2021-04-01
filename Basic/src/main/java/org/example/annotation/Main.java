package org.example.annotation;

public class Main {

  public static void main(String[] args) {
    Person person = new Person("wang","mei","22");
    ObjectToJsonConverter objectToJsonConverter = new ObjectToJsonConverter();
    System.out.println(objectToJsonConverter.convertToJson(person));
  }

}
