package com.sarik.learn.streams;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamsFlatLab {

    public static List<String> printGameDlc() {

        List<String> gameDlcList = GameService.getAllGames()
                .stream()
                .map(Game::getDlc) //Stream<List<String>>
                .flatMap(List::stream) //<Stream<String>
                .collect(toList());

        return gameDlcList;

    }

    public static List<String> printUniqueGameDlc() {

        List<String> gameDlcList = GameService.getAllGames()
                .stream()
                .map(Game::getDlc)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(toList());

        return gameDlcList;

    }

    public static long getGameDlcCount() {

        long totalActivities = GameService.getAllGames()
                .stream()
                .map(Game::getDlc)
                .flatMap(List::stream)
                .distinct()
                .count();

        return totalActivities;

    }

    public static void main(String[] args) {


        System.out.println("Student Activities : " + printGameDlc());
        System.out.println("Unique Student Activities : " + printUniqueGameDlc());
        System.out.println("Unique Student Activities Count: " + getGameDlcCount());

    }

}
