package com.sarik.learn.functionalInterfaces;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerLab {

    static Consumer<Game>  c1= game -> System.out.println(game);

    static Consumer<Game>  c2= game -> System.out.print(game.getName().toUpperCase());

    static Consumer<Game>  c3= game -> System.out.println(" Rating : " + game.getRating());


    public static void printName(){

        List<Game> gameList = GameService.getAllGames();

        gameList.forEach(c1);

    }

    public static void printNameAndRating(){
        System.out.println("printNameAndRating : ");
        List<Game> gameList = GameService.getAllGames();
        gameList.forEach(c2.andThen(c3));
    }

    public static void printNameAndRatingUsingCondition(){
        System.out.println("printNameAndRatingUsingCondition : ");
        List<Game> gameList = GameService.getAllGames();
        gameList.forEach((s) -> {
            if( s.getPrice()>=300 && s.getRating()>3){
                c2.andThen(c3).accept(s);
            }
        });
    }

    public static void main(String[] args) {
        Consumer<String> consumer1 = (s) -> System.out.println(s.toUpperCase());
        consumer1.accept("java8");

        printName();
        printNameAndRating();
        printNameAndRatingUsingCondition();
    }

}
