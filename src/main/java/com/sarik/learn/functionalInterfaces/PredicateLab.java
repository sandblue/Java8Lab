package com.sarik.learn.functionalInterfaces;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateLab {


    static Predicate<Game> p1 = (s) -> s.getRating()>=3.0;

    static Predicate<Game> p2 = (s) -> s.getPrice()>=400;

    static Function<Integer, Predicate<Integer>> pricePredicate = (toCompare) -> (number) -> number > toCompare;
    static Function<Double,Predicate<Double>>  ratingPredicate = (toCompare) -> (number) -> number > toCompare;


    public static void main(String[] args) {

        List<Game> gameList = GameService.getAllGames();

        gameList.stream()
                .filter(PredicateLab.p1)
                .collect(Collectors.toList());

        gameList.forEach((game -> {
            if(p1.test(game)){
                System.out.println(game);
            }
        }));

        boolean result = pricePredicate.apply(1000).test(1500) && ratingPredicate.apply(3.6).test(3.9);
        System.out.println("Result from Predicate : " + result);

    }

}
