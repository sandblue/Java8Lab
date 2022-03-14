package com.sarik.learn.streams.terminal;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class StreamsPartitioningLab {

    public static void partitioningBy_1(){

        Predicate<Game> ratingPredicate = (game) -> game.getRating()>=3.8;

        Map<Boolean, List<Game>> gameMap = GameService.getAllGames()
                .stream()
                .collect(partitioningBy(ratingPredicate));

        System.out.println("gameMap : " + gameMap);

    }

    public static void partitioningBy_2(){

        Predicate<Game> ratingPredicate = (game) -> game.getRating()>=3.8;

        Map<Boolean, Set<Game>> gameMap = GameService.getAllGames()
                .stream()
                .collect(partitioningBy(ratingPredicate,toSet()));

        System.out.println("gameMap : " + gameMap);

    }


    public static void partitioningBy_3(){

        Predicate<Game> ratingPredicate = (game) -> game.getRating()>=3.8;

        Map<Boolean,Map<String, List<String>>> gameMap =  GameService.getAllGames()
                .stream()
                .collect(partitioningBy(ratingPredicate,toMap(Game::getName,Game::getDlc)));

        System.out.println("gameMap : " + gameMap);

    }

    public static void main(String[] args) {
        partitioningBy_1();
        partitioningBy_2();
        partitioningBy_3();
    }
}
