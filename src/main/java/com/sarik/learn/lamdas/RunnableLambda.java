package com.sarik.learn.lamdas;

public class RunnableLambda {

    public static void main(String[] args){
        System.out.println("Prior Java 8");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 1");
        }
        };

        new Thread(runnable).start();

        System.out.println("Java8 - Lambda syntax , () -> {} ");

        Runnable runnableLambda = () -> {System.out.println("Inside Lambda 1");};
        Runnable  runnableLambdaMultiple = () -> {
            System.out.println("Inside Lambda 2");
            System.out.println("Inside Lambda 3");
        };

        Runnable runnableSimpleLambda = () -> System.out.println("Inside simple lambda 1");

        new Thread(runnableLambda).start();
        new Thread(runnableLambdaMultiple).start();
        new Thread(runnableSimpleLambda).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 2");
            }
        });

        new Thread(() -> System.out.println("Inside Runnable 1 line lambda")).start();


    }
}
