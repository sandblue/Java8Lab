package com.sarik.learn.streams;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamsComparatorLab {
    public static List<Game> sortGamesByName(){

        return  GameService.getAllGames().stream()
                .sorted(Comparator.comparing(Game::getName))
                .collect(toList());
    }

    public static List<Game> sortGameByPrice(){

        return  GameService.getAllGames().stream()
                .sorted(Comparator.comparing(Game::getPrice))
                .collect(toList());
    }

    public static List<Game> sortGameByPriceReversed(){

        return  GameService.getAllGames().stream()
                .sorted(Comparator.comparing(Game::getPrice).reversed())
                .collect(toList());
    }

    public static void main(String[] args) {
        System.out.println("Game sorted by NAME");
        sortGamesByName().forEach(System.out::println);
        System.out.println("Game sorted by Price");
        sortGameByPrice().forEach(System.out::println);

        System.out.println("Game sorted by Price Higher to Lower");
        sortGameByPriceReversed().forEach(System.out::println);

    }
}
