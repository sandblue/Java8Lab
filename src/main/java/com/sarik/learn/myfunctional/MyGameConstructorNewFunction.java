package com.sarik.learn.myfunctional;

@FunctionalInterface
public interface MyGameConstructorNewFunction<N, P, D, R, G> {
    G apply(N var1, P var2, D var3, R var4);
}