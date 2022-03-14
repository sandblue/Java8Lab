package com.sarik.learn.streams.terminal;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.stream.Collectors;

public class StreamsJoiningLab {
    public static String joining(){

        return GameService.getAllGames().stream()
                .map(Game::getName)
                .collect(Collectors.joining()); // appends all the strings to produce the output,
    }

    public static String joiningWithDelimiter(){

        return GameService.getAllGames().stream()
                .map(Game::getName)
                .collect(Collectors.joining("-"));
    }

    public static String joiningWithDelimiterWithPrefix(){

        return  GameService.getAllGames().stream()
                .map(Game::getName)
                .collect(Collectors.joining("-","[","]"));
    }

    public static void main(String[] args) {

        System.out.println("Names : "+ joining());
        System.out.println("Names With Delimiter : "+ joiningWithDelimiter());
        System.out.println("Names With Delimiter Prefix and Suffix : "+ joiningWithDelimiterWithPrefix());
    }
}
