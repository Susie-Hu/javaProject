package org.example.jaxb;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.log4j.Logger;

@XmlRootElement(name = "country")
public class Country {
  static Logger logger = Logger.getLogger(Country.class);
  private String name;
//  private List<City> cities;
  private City city;

  @XmlAttribute(name = "name")
  public void setName(String name){
    this.name = name;
  }

  @XmlElement(name = "city")
  public void setCity(City city){
    System.out.println("test print log");
    logger.info("load city");
//    print(city);
    this.city = city;
  }

  public void print(City city){
    System.out.println("test print log");
    city.setName("hubei");
  }
  
//  @XmlElement(name = "city")
//  public void setCities(List<City> cities){
//    for (City city : cities){
//      System.out.println(city);
//    }
//    this.cities = cities;
//  }

  @Override
  public String toString() {
    return "Country{" +
        "name='" + name + '\'' +
        ", cities=" + city +
        '}';
  }
}
