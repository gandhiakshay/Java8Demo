package com.demo.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMain {

  public static void main(String[] args) throws Exception {

    /** generating stream feature */
    List<String> list = Arrays.asList("John", "David", "", "Marc", "", "Tom", "Lawrence");
    List<String> filterList =
        list.stream().filter((str) -> !str.isEmpty()).collect(Collectors.toList());
    filterList.forEach(System.err::println);

    /** Random number,forEach,limit,range */
    Random rand = new Random();
    rand.ints(1, 10).limit(5).forEach(System.out::println);

    /** map */
    List<Integer> intList =
        Arrays.asList(
            45, 2, 5, 9, 7, 8, 36, 4, 1, 5, 2, 5, 252, 6, 23, 5, 2, 5, 2, 566, 3, 6, 25, 2);
    List<Integer> mapList = intList.stream().map(n -> n * n).collect(Collectors.toList());
    mapList.forEach(System.err::println);
    List<Integer> evenList = intList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    evenList.forEach(System.out::println);

    /** filter,sorted list */
    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    // sorted list
    strings.stream().filter(str -> !str.isEmpty()).sorted().forEach(System.out::println);
    // startWith
    strings.stream().filter(str -> str.startsWith("a")).forEach(System.err::println);
    // reduce
    String reduced = strings.stream().reduce("", (acc, item) -> acc + " " + item);
    System.out.println("-->" + reduced);
    // count element in list
    Long count = strings.stream().filter(str -> !str.isEmpty()).count();
    System.err.println("without empty string Count is " + count);

    /** for loop n times */
    IntStream.range(1, 11).forEach(System.out::println);

    /** merge */
    String mergeList = list.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(","));
    System.out.println("Merged String: " + mergeList);

    /** SummaryStatistics */
    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
    System.out.println("Max number in List : " + stats.getMax());
    System.out.println("Min number in List : " + stats.getMin());
    System.out.println("Sum of all numbers : " + stats.getSum());
    System.out.println("Average of all numbers : " + stats.getAverage());

    System.err.println("Max number in List : " + numbers.stream().max(Integer::compare).get());
    System.err.println("Min number in List : " + numbers.stream().min(Integer::compare).get());
    System.err.println("Sum of all numbers : " + numbers.stream().mapToInt(x -> x).sum());
    System.err.println("Count is : " + numbers.stream().count());
  }
}
