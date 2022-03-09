package com.sarik.learn.functionalInterfaces;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerLab {

    static Predicate<Game> p1 = (s) -> s.getRating()>=3.0;

    static Predicate<Game> p2 = (s) -> s.getPrice()>=300;

    BiConsumer<String, Double> gameBiConsumer = (name, rating) -> System.out.println(name + " : " + rating);

    Consumer<Game> gameConsumer = (game) -> {

        if(p1.and(p2).test(game)){
            gameBiConsumer.accept(game.getName(),game.getRating());
        }
    };


    public void printNameandRating(List<Game> games){

        games.forEach(gameConsumer);

    }

    public static void main(String[] args) {

        List<Game> gameList = GameService.getAllGames();

        new PredicateAndConsumerLab().printNameandRating(gameList);

    }
}
