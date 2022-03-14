package com.sarik.learn.streams.terminal;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamsMinByMaxByLab {

    public static Optional<Game> minBy(){

        Optional<Game> gameOptional = GameService.getAllGames().stream()
                .collect(Collectors.minBy(Comparator.comparing(Game::getPrice)));

        return gameOptional;
    }

    public static Optional<Game> maxBy(){

        Optional<Game> gameOptional = GameService.getAllGames().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Game::getPrice)));

        return gameOptional;
    }

    public static  List<Game>  maxByMultipleStudents(){

        List<Game> maxRatingGame = new ArrayList<>();
        Optional<Game> gameOptional = GameService.getAllGames().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Game::getRating)));

        Game maxRating = gameOptional.isPresent() ? gameOptional.get() : null ;
        if(maxRating!=null){

            maxRatingGame = GameService.getAllGames().stream()
                    .filter(game -> maxRating.getRating().equals(game.getRating()))
                    .collect(toList());

            System.out.println("Max Rating Game are : " + maxRatingGame);
        }
        return maxRatingGame;
    }


    public static void main(String[] args) {

        System.out.println(minBy());

        System.out.println(maxBy());

        System.out.println(maxByMultipleStudents());
    }
}
