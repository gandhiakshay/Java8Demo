package com.demo.generic;

import java.util.List;

class MyGen<K, V> {

  private K key;
  private V value;

  public MyGen(K key, V value) {
    System.err.println("Constructor invoked");
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  // public <T extends Comparable<T>> int showArray(T[] arr) {
  // return 0;
  // }

  @SuppressWarnings("unchecked")
  public <E> E show(E element, E element2) {
    if (element.getClass() == Integer.class)
      return (E) (Integer) ((Integer) element + (Integer) element2);
    else return (E) (element.toString() + " " + element2.toString());
  }

  /**
   * Upper Bounded Wildcards using extends keyword
   *
   * @param list
   * @return
   */
  public static double sumOfList(List<? extends Number> list) {
    double sum = 0.0;
    for (Number n : list) {
      sum += n.doubleValue();
    }
    return sum;
  }

  /**
   * Unbounded Wildcards
   *
   * @param list
   */
  public static void printList(List<?> list) {
    for (Object obj : list) {
      System.err.print(obj + " ");
    }
    System.err.println();
  }

  /**
   * Lower Bounded Wildcards using super keyword
   *
   * @param list
   */
  public static void showList(List<? super Integer> list) {
    for (int i = 1; i <= 10; i++) {
      list.add(i);
    }
    System.out.println(list);
  }
}
