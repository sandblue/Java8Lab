package com.sarik.learn.data;

import com.sarik.learn.data.model.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class GameService {

    public static Supplier<Game> gameSupplier = () -> new Game("Game Supplier result", 6600, "yoga s", 5.0);

    public static List<Game> getAllGames(){
        List games = new ArrayList();
        games.add(new Game("Elder Scroll Online", 350, "bla bla", 4.0, Arrays.asList("Elswer", "Black Wood"), "RPG"));
        games.add(new Game("Guild War 2", 1500, "foo foo", 4.5, Arrays.asList("Path of fire"), "RPG"));
        games.add(new Game("You gun is ..", 122, "yoga yoga", 2.0, Arrays.asList("Burn"), "ACTION"));
        games.add(new Game("Tale Runner", 600, "yoga yoga", 3.0, Arrays.asList(""), "SPORT"));
        games.add(new Game("Apex", 234, "run and gun", 4.5, Arrays.asList(""), "SHOOTING"));
        return games;
    }

}
