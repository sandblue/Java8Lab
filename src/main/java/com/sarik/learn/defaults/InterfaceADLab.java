package com.sarik.learn.defaults;

public class InterfaceADLab implements InterfaceA,InterfaceD{

    public void  methodA(){
        System.out.println("Inside method A "+InterfaceADLab.class);
    }

    public static void main(String[] args) {
        InterfaceADLab client14 = new InterfaceADLab();
        client14.methodA();

    }

}