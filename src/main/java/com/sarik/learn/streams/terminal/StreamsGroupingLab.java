package com.sarik.learn.streams.terminal;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamsGroupingLab {
    public static void groupingByType(){

        Map<String, List<Game>> gameMap =  GameService.getAllGames()
                .stream()
                .collect(groupingBy(Game::getType));

        Stream.of(gameMap).forEach(System.out::println);
    }

    public  static void customizedGroupingBy(){

        Map<String,List<Game>> gameMap =   GameService.getAllGames()
                .stream()
                .collect(groupingBy(game -> game.getRating()>= 3.5 ?  "OUTSTANDING" : "AVERAGE"));

        Stream.of(gameMap).forEach(System.out::println);
    }

    /**
     * Grouping by Two parameters
     */
    public  static void twoLevelGrouping(){

        Map<String,  Map<String,List<Game>>> gameMap =   GameService.getAllGames().stream()
                .collect(groupingBy(Game::getType, groupingBy(game -> game.getRating() >= 3.8 ?  "OUTSTANDING" : "AVERAGE")));

        Stream.of(gameMap).forEach(System.out::println);

    }

    /**
     * Grouping by Two parameters
     */
    public  static void twoLevelGrouping_2(){

        Map<String,Integer> nameGamePriceMap = GameService.getAllGames().stream()
                .collect(groupingBy(Game::getName,
                        summingInt(Game::getPrice)));// second argument can be of any type of collector

        System.out.println(nameGamePriceMap);
    }

    /**
     * Grouping by Two parameters
     */
    public  static void twoLevelGrouping_3(){

        Map<String, Set<Game>> nameGameMap = GameService.getAllGames().stream()
                .collect(groupingBy(Game::getName,
                        toSet()));// second argument can be of any type of collector

        System.out.println(nameGameMap);
    }


    public static void threeArgumentGroupingBy(){

        LinkedHashMap<String,Set<Game>> gameMap = GameService.getAllGames().stream()
                .collect(groupingBy(Game::getName, LinkedHashMap::new,
                        toSet()));

        System.out.println(" gameMap : " + gameMap);
    }


    public  static void calculateTopRateGameInEachType(){

        Map<String, Optional<Game>> gameMapOptional =  GameService.getAllGames().stream()
                .collect(groupingBy(Game::getType,maxBy(Comparator.comparingDouble(Game::getRating))
                ));

        Stream.of(gameMapOptional).forEach(System.out::println);


        Map<String, Game> gameMap =  GameService.getAllGames().stream()
                .collect(groupingBy(Game::getType,
                        collectingAndThen(maxBy(Comparator.comparingDouble(Game::getRating))
                                ,Optional::get
                        )));

        Stream.of(gameMap).forEach(System.out::println);
    }

    public  static void calculateMinRateGameInEachType(){

        Map<String, Optional<Game>> gameMapOptional = GameService.getAllGames().stream()
                .collect(groupingBy(Game::getType,minBy(Comparator.comparingDouble(Game::getRating))
                ));

        Stream.of(gameMapOptional).forEach(System.out::println);


        Map<String, Game> gameMap = GameService.getAllGames().stream()
                .collect(groupingBy(Game::getType,
                        collectingAndThen(minBy(Comparator.comparingDouble(Game::getRating))
                                ,Optional::get
                        )));

        Stream.of(gameMap).forEach(System.out::println);
    }

    public static void main(String[] args) {

        //groupingByType();
        //customizedGroupingBy();
        //twoLevelGrouping();
        //twoLevelGrouping_2();
        //twoLevelGrouping_3();
        calculateTopRateGameInEachType();
        calculateMinRateGameInEachType();
        //threeArgumentGroupingBy();
    }
}
