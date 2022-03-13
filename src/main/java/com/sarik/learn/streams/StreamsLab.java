package com.sarik.learn.streams;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsLab {

    public static void main(String[] args) {

        Predicate<Game> ratingPredicate = game -> game.getRating() >=3.0;
        Predicate<Game> pricePredicate = game -> game.getPrice() >= 500;


        Map<String, List<String>> gameMap = GameService.getAllGames().stream(). //.parallelStream dont forger.
                filter(pricePredicate) // Stream<Game>
                .collect(Collectors.toMap(Game::getName ,Game::getDlc ));

        System.out.println("GameMap  : " + gameMap);

        List<String> dlcList = GameService.getAllGames().
                stream() // Stream<Game>
                .map(Game::getDlc) //<Stream<List<String>>
                .flatMap(List::stream) //<Stream<String>
                .distinct() // removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        System.out.println("dlcList  : " + dlcList);

        List<String> namesList = GameService.getAllGames().
                stream() // Stream<Game>
                .peek((game -> {
                    System.out.println(game);
                }))
                .map(Game::getName)
                .peek(System.out::println)
                .distinct() // removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        System.out.println("namesList  : " + namesList);
    }

}
