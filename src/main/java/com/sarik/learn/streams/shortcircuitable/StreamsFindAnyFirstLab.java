package com.sarik.learn.streams.shortcircuitable;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.Optional;

public class StreamsFindAnyFirstLab {
    public static Optional<Game> findAny(){

        return GameService.getAllGames().stream()
                .filter(student -> student.getRating()>=3.8)
                .findAny();
    }

    public static Optional<Game> findFirst(){

        return  GameService.getAllGames().stream()
                .filter(student -> student.getRating()>=3.8)
                .findFirst();
    }

    public static void main(String[] args) {

        Optional<Game> findAnyGame = findAny();
        if(findAnyGame.isPresent()){
            System.out.println("Game is :" + findAnyGame.get());
        }else{
            System.out.println("No Game Found");
        }

        Optional<Game> findFirst = findFirst();
        if(findFirst.isPresent()){
            System.out.println("Game is :" + findFirst.get());
        }else{
            System.out.println("No Game Found");
        }
        //it will make a lot of different during parallel stream

    }
}
