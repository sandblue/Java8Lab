package com.sarik.learn.defaults;

public interface InterfaceD {
    default void methodA(){
        System.out.println("Inside method A"+ InterfaceD.class);
    }
}
