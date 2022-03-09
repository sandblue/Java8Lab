package com.sarik.learn.methodreference;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.function.Consumer;

public class ConsumerMethodReferenceLab {

    /**
     * Class::instancemethod
     */
    static Consumer<Game> c1= System.out::println;


    /**
     * instance::instancemethod
     */
    static Consumer<Game> c2 = (game -> game.printAllDetail());
    static Consumer<Game> c3 = (Game::printAllDetail);

    public static void main(String[] args) {

        GameService.getAllGames().forEach(c1);
        GameService.getAllGames().forEach(c2);
        GameService.getAllGames().forEach(c3);
    }
}
