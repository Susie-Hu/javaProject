package org.example.jaxb;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.example.jaxb.Country;

public class Main {

  public static void main(String[] args) throws JAXBException {
    File file = new File("country.xml");
    JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);

/**
 * the only difference with the marshaling operation is here
 */
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    Country country = (Country) jaxbUnmarshaller.unmarshal(file);
    System.out.println(country);
  }

}
