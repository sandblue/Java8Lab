package com.sarik.learn.streams.terminal;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.stream.Collectors;

public class StreamsSumAvgLab {

    public static int sum(){

        int totalNoOfNotebooks = GameService.getAllGames()
                .stream()
                .collect(Collectors.summingInt(Game::getPrice));

        return totalNoOfNotebooks;
    }

    public static double average(){

        double totalNoOfNotebooks = GameService.getAllGames()
                .stream()
                .collect(Collectors.averagingInt(Game::getPrice));

        return totalNoOfNotebooks;
    }


    public static void main(String[] args) {


        System.out.println("Total price of game : " + sum());

        System.out.println("Average price of game: " + average());
    }
}
