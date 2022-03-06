package com.sarik.learn.data;

import com.sarik.learn.data.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public static List<Game> getAllGames(){
        List games = new ArrayList();
        games.add(new Game("Elder Scroll Online", 350, "bla bla", 4.0));
        games.add(new Game("Guild War 2", 1500, "foo foo", 4.5));
        games.add(new Game("You gun is ..", 122, "yoga yoga", 2.0));
        games.add(new Game("Tale Runner", 600, "yoga yoga", 3.0));
        return games;
    }

}
