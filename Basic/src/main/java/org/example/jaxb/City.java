package org.example.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city")
public class City {
  private String name;

  @XmlAttribute(name = "name")
  public void setName(String name){
    this.name = name;
  }

  @Override
  public String toString() {
    return "City{" +
        "name='" + name + '\'' +
        '}';
  }
}
