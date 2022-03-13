package com.sarik.learn.streams.shortcircuitable;

import com.sarik.learn.data.GameService;

public class StreamsMatchLab {
    public static boolean allMatch(){

        boolean result = GameService.getAllGames().stream()
                .allMatch(student -> student.getRating()>=2.0);

        return result;
    }

    public static boolean anyMatch(){

        boolean result = GameService.getAllGames().stream()
                .anyMatch(student -> student.getRating()>=3.0);

        return result;
    }

    public static boolean noneMatch(){

        boolean result = GameService.getAllGames().stream()
                .noneMatch(student -> student.getRating()>=4.1);

        return result;
    }

    public static void main(String[] args) {

        System.out.println("Result of allMatch : " + allMatch());
        System.out.println("Result of anyMatch : " + anyMatch());
        System.out.println("Result of noneMatch : " + noneMatch());
    }
}
