package org.example;/**
 * TODO
 *
 * @author husi
 * @since 11/13/2020
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.example.serialization.Account;
import org.example.serialization.Account2;
import org.junit.Test;

/**
 *@ClassName SerializationTest
 *@Description TODO
 *@Date 11/13/2020 2:06 PM
 *@Version 1.0
 **/
public class SerializationTest {

  @Test
  public void serializationAndDeserialization() throws IOException, ClassNotFoundException {
    Account jack = new Account("jack",10,123423);
    FileOutputStream fos = new FileOutputStream("file.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(jack);
    oos.flush();
    fos.close();
    oos.close();

    FileInputStream fis = new FileInputStream("file.txt");
    ObjectInputStream ois = new ObjectInputStream(fis);
    Account jackson;
    jackson = (Account) ois.readObject();
    System.out.println(jackson);
  }

  @Test
  public void serializationClass() throws IOException {
    Account jack = new Account("jack",10,123423);
    FileOutputStream fos = new FileOutputStream("file-serialization.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(jack);
    oos.flush();
    fos.close();
    oos.close();
  }

  @Test
  public void deserializationToClassUpdated() throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream("file-serialization.txt");
    ObjectInputStream ois = new ObjectInputStream(fis);
    Account jackson;
    jackson = (Account) ois.readObject();
    System.out.println(jackson);
  }

}
