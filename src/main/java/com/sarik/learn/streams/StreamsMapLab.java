package com.sarik.learn.streams;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamsMapLab {

    private static List<String> namesUpperCase(List<Game> names){
        List<String> namesUpperCase = names.stream() //Stream<Game>
                .map(Game::getName) //Stream<String>
                .map(String::toUpperCase) // Stream<String> -> UpperCase
                .collect(toList()); // returns List // terminal operation
        return namesUpperCase;
    }

    private static Set<String> namesSetUpperCase(List<Game> students){
        Set<String> namesUpperCase = students.stream() //Stream<Game>
                .map(Game::getName) //Stream<String>
                .map(String::toUpperCase) // Stream<String> -> UpperCase
                .collect(toSet()); // returns List // terminal operation
        return namesUpperCase;
    }

    private static Map<String, Integer> namesLengthMap(ArrayList<String> names){

        Map<String, Integer> namesLengthMap = names.stream()//Stream<String>
                .collect(toMap(String::toString,String::length)); // returns Map

        return namesLengthMap;
    }


    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("adam");
        names.add("dan");
        names.add("jenny");

        System.out.println("namesUpperCase List : " + namesUpperCase(GameService.getAllGames()));
        System.out.println("namesUpperCase Set : " + namesSetUpperCase(GameService.getAllGames()));
        System.out.println("namesLengthMap : " + namesLengthMap(names));

    }
}
