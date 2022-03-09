package com.sarik.learn.constructorreference;

import com.sarik.learn.data.model.Game;
import com.sarik.learn.myfunctional.MyGameConstructorNewFunction;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceLab {

    static Supplier<Game> gameSupplier = Game::new;

    static Function<String, Game> gameFunction = Game::new;

    static MyGameConstructorNewFunction<String, Integer, String, Double, Game> myGameConstructorNewFunction = Game::new;

    //Student student = Student::new;

    public static void main(String[] args) {

        System.out.println(gameSupplier.get());

        System.out.println(gameFunction.apply("Function game Krub"));

        System.out.println(myGameConstructorNewFunction.apply("My Function game Krub", 100, "non detail", 3.7));
    }
}
