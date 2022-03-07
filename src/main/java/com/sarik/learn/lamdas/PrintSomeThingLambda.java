package com.sarik.learn.lamdas;

import com.sarik.learn.myfunctional.PrintSomeThing;

public class PrintSomeThingLambda {

    public static void main(String[] args) {
        PrintSomeThing printSomeThing = (String s) -> System.out.println(s);
        // Can ignore type in args list (s)
        PrintSomeThing printSomeThingWithUpperCase = (s) -> System.out.println(s.toUpperCase());
        //PrintSomeThing printSomeThingMissArg = () -> {}; Can't because it require 1 arg
        printSomeThing.print("input ?");
        printSomeThingWithUpperCase.print("input upper ?");
    }

}
