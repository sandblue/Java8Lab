package com.sarik.learn.defaults;

public interface InterfaceB extends InterfaceA {

    default void methodB(){
        System.out.println("Inside method B");
    }

    default void methodA(){
        System.out.println("Inside method A "+ InterfaceB.class);
    }
}
