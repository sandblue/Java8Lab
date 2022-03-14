package com.sarik.learn.streams.terminal;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamsCountingMappingLab {

    public static long count(){
        return  GameService.getAllGames()
                .stream()
                .filter(game -> game.getRating()>=3.9)
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {

        System.out.println(count());

        Set<String> namesSet = GameService.getAllGames()
                .stream()
                .collect(mapping(Game::getName,toSet())); // this avoids the additional map intermediate operation.

        System.out.println("namesSet : " + namesSet);

        List<String> namesList = GameService.getAllGames()
                .stream()
                .collect(mapping(Game::getName,toList())); // this avoids the additional map intermediate operation.

        System.out.println("namesList : " + namesList);

    }
}
