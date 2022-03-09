package com.sarik.learn.functionalInterfaces;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.List;
import java.util.function.Supplier;

public class SupplierLab {

    //   Supplier<OutPut>
    public static Supplier<Game> gameSupplier = () -> {
        return  new Game("Supplier Game", 15600, "", 1.5);
    };

    public static  Supplier<List<Game>> gamesSupplier = () -> GameService.getAllGames();

    public static void main(String[] args) {

        Game game = gameSupplier.get();

        System.out.println("game is : " + game);

        System.out.println("games are : " + gamesSupplier.get());
    }
}
