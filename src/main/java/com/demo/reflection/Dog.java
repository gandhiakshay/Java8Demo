package com.demo.reflection;

public class Dog implements Animal {

  public int i = 0;
  public String str;
  public int val;
  private String test;

  public Dog() {
    System.out.println("Default Constructor invoked");
  }

  public Dog(int val) {
    this.val = val;
  }

  public Dog(String test) {
    this.test = test;
  }

  public class Pet1 {}

  public class Pet2 {}

  public class Pet3 {}

  public String getTest() {
    return test;
  }

  @Override
  public void eat() {
    System.out.println("Dog is Eating");
  }
}
