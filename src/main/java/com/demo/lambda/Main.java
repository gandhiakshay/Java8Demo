package com.demo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

  public static void main(String[] args) {

    List<String> strList = new ArrayList<>();
    strList.add("David");
    strList.add("Pierre");
    strList.add("Marc");
    strList.add("Lawrence");

    List<String> strList2 = new ArrayList<>();
    strList2.add("John");
    strList2.add("Nasc");
    strList2.add("Tom");
    strList2.add("Jerry");

    /** without using lambda expression */
    for (String s : strList) {
      System.err.println(s);
    }

    /** using lambda expression */
    strList.forEach(s -> System.out.println(s));

    /** sort the list using java7 & Anonymous class */
    System.out.println(strList); // before sort the list
    Collections.sort(
        strList,
        new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            return o1.compareTo(o2);
          }
        });
    System.out.println(strList); // after sort the list

    /** sort the list using java8 Lambda Expression */
    System.err.println(strList2); // before sort the list
    Collections.sort(strList2, (s1, s2) -> s1.compareTo(s2));
    System.err.println(strList2); // after sort the list

    /** calling method using java7 */
    execute(
        new Printable() {
          @Override
          public void doSomething() {
            System.err.println("doSomething invoked using Lambda expression");
          }
        });

    /** calling method using java8 lambda expression */
    execute(() -> System.out.println("doSomething invoked using Lambda expression"));

    Printable p = () -> System.err.println("doSomething invoked using Lambda expression");
    p.doSomething();

    /** making one method which is evaluate if condition in lambda expression */
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    evaluate(list, (n) -> n % 2 == 0);
  }

  public static void execute(Printable p) {
    p.doSomething();
  }

  public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
    for (Integer n : list) {
      if (predicate.test(n)) {
        System.out.println(n + " ");
      }
    }
  }
}
