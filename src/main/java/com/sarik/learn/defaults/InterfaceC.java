package com.sarik.learn.defaults;

public interface InterfaceC extends InterfaceB, InterfaceA {
    default void methodC(){
        System.out.println("Inside method C");
    }
    default void methodA(){
        System.out.println("Inside method A "+ InterfaceC.class);
    }
}
