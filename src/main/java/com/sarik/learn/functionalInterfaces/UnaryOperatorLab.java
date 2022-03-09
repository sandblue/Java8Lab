package com.sarik.learn.functionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorLab {

    // UnaryOperator<Input and Output>
    static UnaryOperator<String> unaryOperator = (s)->s.concat("Default");

    public static void main(String[] args) {

        System.out.println(unaryOperator.apply("java8"));


    }
}
