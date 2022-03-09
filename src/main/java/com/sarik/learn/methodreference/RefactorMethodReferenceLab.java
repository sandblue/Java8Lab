package com.sarik.learn.methodreference;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class RefactorMethodReferenceLab {
    static Predicate<Game> predicateUsingLambda = (s) -> s.getRating()>=3;

    static Predicate<Game> predicateUsingMetRef = RefactorMethodReferenceLab::greaterThan;


    static BiPredicate<Game,Integer> predicateUsingMethodReference = RefactorMethodReferenceLab::greaterThan;

    static public  boolean greaterThan(Game game){

        return game.getRating() >3;
    }

    static public  boolean greaterThan(Game game,Integer price){

        return game.getPrice() >price;
    }

    public static void main(String[] args) {

        System.out.println(predicateUsingLambda.test(GameService.gameSupplier.get()));
        System.out.println(predicateUsingMetRef.test(GameService.gameSupplier.get()));
        System.out.println(predicateUsingMethodReference.test(GameService.gameSupplier.get(),16000));

    }
}
