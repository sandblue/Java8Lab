package com.sarik.learn.functionalInterfaces;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;
import com.sarik.learn.myfunctional.MyTriConsumer;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerLab {

    static Consumer<Game>  c1= game -> System.out.println(game);

    static Consumer<Game>  c2= game -> System.out.print(game.getName().toUpperCase());

    static Consumer<Game>  c3= game -> System.out.println(" Rating : " + game.getRating());

    static BiConsumer<Game, Double> c4 = ( game, rating ) ->  { if(game.getRating() > rating) { System.out.println(game); }};

    static BiConsumer<Game, Integer> c5 = ( Game game, Integer price ) -> { if(game.getPrice() > price) { System.out.println(game); }};

    static MyTriConsumer<Game, Double, Integer> c6 =(Game game , Double rating , Integer price) -> {
        if(game.getPrice() > price && game.getRating() > rating){
            System.out.println(game);
        }
    };

    static MyTriConsumer<Game, Double, Integer> c7 =(Game game , Double rating , Integer price) -> {
         System.out.println(game + " rating : " + rating + " price : " + price);
    };

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

    public static void printGameDetailUsingPriceCondition(){
        System.out.println("printGameDetailUsingPriceCondition : ");
        List<Game> gameList = GameService.getAllGames();
        gameList.forEach((s) -> c5.accept(s, 600)) ;
    }

    public static void printGameDetailUsingRatingCondition(){
        System.out.println("printGameDetailUsingRatingCondition : ");
        List<Game> gameList = GameService.getAllGames();
        gameList.forEach((s) -> c4.accept(s, 3.0)) ;
    }

    public static void printGameDetailUsingMyTriConsumer() {
        System.out.println("printGameDetailUsingMyTriConsumer : ");
        List<Game> gameList = GameService.getAllGames();
        gameList.forEach((s) -> c6.andThen(c7).accept(s, 3.0, 400)) ;
    }

    public static void main(String[] args) {
        Consumer<String> consumer1 = (s) -> System.out.println(s.toUpperCase());
        consumer1.accept("java8");

        printName();
        printNameAndRating();
        printNameAndRatingUsingCondition();
        printGameDetailUsingPriceCondition();
        printGameDetailUsingRatingCondition();
        printGameDetailUsingMyTriConsumer();
    }

}
