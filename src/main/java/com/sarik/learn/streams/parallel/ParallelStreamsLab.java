package com.sarik.learn.streams.parallel;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ParallelStreamsLab {
    public static List<String> sequentialStream(){

        long start = System.currentTimeMillis();
        List<String> studentActivities = GameService.getAllGames()
                .stream()
                .map(Game::getDlc) //Stream<List<String>>
                .flatMap(List::stream) //<Stream<String>
                .collect(toList());

        long duration = System.currentTimeMillis()-start;
        System.out.println("Duration in sequential stream : "+ duration);

        return studentActivities;
    }

    public static List<String> parallelStream(){

        long start = System.currentTimeMillis();
        List<String> studentActivities = GameService.getAllGames()
                .parallelStream()
                .map(Game::getDlc) //Stream<List<String>>
                .flatMap(List::stream) //<Stream<String>
                .collect(toList());


        long duration = System.currentTimeMillis()-start;
        System.out.println("Duration in parallel stream : "+ duration);

        return studentActivities;

    }



    public static void main(String[] args) {


        System.out.println("sequentialStream : " + sequentialStream());

        System.out.println("parallelStream : " + parallelStream());


    }
}
