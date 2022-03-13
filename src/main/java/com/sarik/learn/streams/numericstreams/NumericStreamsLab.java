package com.sarik.learn.streams.numericstreams;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

public class NumericStreamsLab {

    public static void main(String[] args) {
        range();
        aggregate();
        boxingAndUnbox();
        mapTo();
    }

    public static void aggregate(){
        int sum = IntStream.rangeClosed(1,50).sum();
        System.out.println("Sum : "+ sum);

        OptionalInt max = IntStream.rangeClosed(1,50).max();
        System.out.println(max.isPresent());
        System.out.println(max.getAsInt());

        OptionalLong min = LongStream.rangeClosed(1,50).min();
        System.out.println(min.getAsLong());

        OptionalDouble avg = IntStream.rangeClosed(1,50).average();
        System.out.println(avg.getAsDouble());

    }

    public static void range(){
        IntStream intStream = IntStream.range(1,50);
        System.out.println("Total number of elements : " + intStream.count());
        //intStream.forEach(System.out::print); // stream closed error
        IntStream.range(1,50).forEach(value -> System.out.print(value+","));
        System.out.println();
        IntStream.rangeClosed(1,50).forEach(value -> System.out.print(value+","));
        System.out.println();
        System.out.println("Total no of elements using rangeClosed :" +IntStream.rangeClosed(1,50).count());

        LongStream.rangeClosed(1,50).forEach(value -> System.out.print(value+","));

        //asDoubleStream
        System.out.println();
        LongStream.rangeClosed(1,50).asDoubleStream().forEach(value -> System.out.print(value+","));
    }

    public static void boxingAndUnbox(){
        System.out.println("Converting PrimitiveStream to List : "+ boxing());

        List<Integer> integers = boxing();

        System.out.println("Sum using Unboding : "  + unBoxing(integers));
    }

    public static List<Integer> boxing() {

        return IntStream.rangeClosed(1,25)
                .boxed() //Stream<Integer>
                //all the elements will be passed one by one to get to the result as the collection.
                .collect(toList());

    }

    public static int unBoxing(List<Integer> integerList) {

        int sum =  integerList.stream()
                .mapToInt(Integer::intValue).sum();
        return sum;

    }

    public static void mapTo(){
        System.out.println("mapToObj : " + mapToObj());

        System.out.println("mapToDouble() : " + mapToDouble());

        System.out.println("mapToLong() : " + mapToLong());

    }


    public static List<Integer> mapToObj(){

        List<Integer> integerList = IntStream.rangeClosed(1,5)
                .mapToObj((i)-> {
                    return new Integer(i);
                })
                .collect(toList());

        return integerList;

    }

    public static double mapToDouble(){

        return   IntStream.rangeClosed(1,5)
                .mapToDouble((i) ->  i)
                .sum();

    }

    public static long mapToLong(){

        return   IntStream.rangeClosed(1,5)
                .mapToLong((i) ->  i)
                .sum();

    }
}

