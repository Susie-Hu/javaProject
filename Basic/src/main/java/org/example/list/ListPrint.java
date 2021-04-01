package org.example.list;

import java.util.ArrayList;
import java.util.List;

public class ListPrint {
  List<String> lists = new ArrayList<>();

  public void add(String item){
    lists.add(item);
  }

  @Override
  public String toString() {
    return "ListPrint{" +
        "lists=" + lists +
        '}';
  }

  public static void main(String[] args) {
    ListPrint listPrint = new ListPrint();
    listPrint.add("my");
    listPrint.add("name");
    listPrint.add("is");
    System.out.println(listPrint.toString());
    System.out.println(listPrint.lists);
  }

}
