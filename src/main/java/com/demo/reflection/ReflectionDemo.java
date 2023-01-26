package com.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

  public static void main(String[] args)
      throws NoSuchFieldException, SecurityException, IllegalArgumentException,
          IllegalAccessException {

    say("com.axelor.reflection.Dog");
    System.out.println("----------------------");
    Dog d = new Dog();
    Class<?> C = d.getClass();

    /** Get the all inner classes */
    Class<?>[] allClass = C.getClasses();
    for (Class<?> c : allClass)
      System.out.println("Inner classes of class Dog : " + c.getSimpleName());
    System.out.println("----------------------");

    /** Get the all Constructors */
    Constructor<?>[] cons = C.getConstructors();
    for (Constructor<?> c : cons) System.out.println("Constructors of class Dog : " + c.getName());
    System.out.println("----------------------");

    /** Get the all methods */
    Method[] methods = C.getDeclaredMethods();
    for (Method m : methods) System.out.println("Method of class Dog : " + m.getName());
    System.out.println("----------------------");

    /** Get the all fields */
    Field[] fields = C.getDeclaredFields();
    for (Field f : fields) System.out.println("Fields of class Dog : " + f.getName());
    System.out.println("----------------------");

    /** Get/Set Public Field Value */
    Dog d2 = new Dog(5);
    Field publicField = C.getField("val");
    System.out.println("Before set public field value : " + publicField.get(d2));
    publicField.set(d2, 20);
    System.out.println("After set public field value : " + publicField.get(d2));
    System.out.println("----------------------");

    /** Get/Set Private Field Value */
    Dog dog = new Dog("Private String");
    Field privateField = C.getDeclaredField("test");
    privateField.setAccessible(true); // Access permission for private field
    System.out.println("Before set public field value : " + privateField.get(dog));
    privateField.set(dog, "Private String Updated");
    System.out.println("After set public field value : " + privateField.get(dog));
    System.out.println("----------------------");
  }

  public static <A> void say(String className) {
    try {
      Class<?> A = Class.forName(className);
      Object o1 = A.newInstance();
      Constructor<?> con = A.getDeclaredConstructor(String.class);
      Object o = con.newInstance("Hello");
      Method m = A.getDeclaredMethod("getTest", null);
      System.out.println(m.invoke(o, null));
      Method m1 = A.getDeclaredMethod("eat", null);
      m1.invoke(o1, null);
    } catch (Exception e) {
    }
  }
}
