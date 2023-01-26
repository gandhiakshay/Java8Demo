package com.demo.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericDemo {

  public static void drawRect(List<? extends Shape> list) {
    list.forEach(s -> s.draw());
  }

  public static void main(String[] args) {
    /** Before generic using ArrayList */
    // List list = new ArrayList();
    // list.add("Hello");
    // String s = (String)list.get(0); //required to typecast
    // System.err.println(s);

    /** After generic using ArrayList */
    List<String> list = new ArrayList<>();
    list.add("Hello");
    String s = list.get(0); // don't need to typecast
    System.err.println(s);

    /** Generic using HasMap */
    HashMap<Integer, String> map = new HashMap<>();
    map.put(1, "John");
    map.put(2, "Pierre");
    map.put(3, "David");
    map.put(4, "Marc");

    for (Map.Entry<Integer, String> m : map.entrySet()) {
      System.out.println(m.getKey() + " " + m.getValue());
    }

    /** class generic with two parameter */
    List<MyGen<Integer, String>> listObj = new ArrayList<>();
    listObj.add(new MyGen<Integer, String>(1, "John"));
    listObj.add(new MyGen<Integer, String>(2, "Marc"));

    listObj.forEach(o -> System.err.println(o.getKey() + " " + o.getValue()));

    MyGen<Integer, String> rawMyGen = new MyGen<Integer, String>(1, "David");
    System.err.println(rawMyGen.show(10, 25));

    // Integer[] arr = {1,2,3,4,5};
    // rawMyGen.showArray(arr);
    /** Upper Bounded Wildcards using extends keyword */
    List<Double> dblList = Arrays.asList(45.0, 35.5, 20.25, 78.50, 00.006);
    System.out.println("Sum is " + MyGen.sumOfList(dblList));

    List<Circle> shapeList = new ArrayList<>();
    shapeList.add(new Circle());
    drawRect(shapeList);

    /** Unbounded Wildcards */
    List<String> strList = Arrays.asList("Hello", "World");
    MyGen.printList(strList);
    List<Double> doblList = Arrays.asList(45.0, 35.5, 20.25, 78.50, 00.006);
    MyGen.printList(doblList);
    List<Integer> intList = Arrays.asList(45, 35, 20, 78, 12);
    MyGen.printList(intList);

    /** Lower Bounded Wildcards using super keyword */
    List<Number> int2List = new ArrayList<>();
    int2List.add(48);
    int2List.add(45);
    MyGen.showList(int2List);
  }
}
