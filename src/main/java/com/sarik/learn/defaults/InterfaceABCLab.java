package com.sarik.learn.defaults;

public class InterfaceABCLab implements InterfaceA,InterfaceB,InterfaceC {

    public void methodA(){ //overriding the default method in the implementation class.
        System.out.println("Inside method A "+ InterfaceABCLab.class);
    }

    public static void main(String[] args) {

        InterfaceABCLab client123 = new InterfaceABCLab();
        client123.methodA(); // resolves to child Interface Implementation
        client123.methodB();
        client123.methodC();


    }
}
