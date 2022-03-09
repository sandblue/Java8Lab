package com.sarik.learn.functionalInterfaces;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionLab {


    // BiFunction<Input1, Input2, Output>

    static BiFunction<List<Game>, Predicate<Game>,Map<String, Double>> biFunction = (games, gamePredicate)->{

        Map<String,Double> gameRateMap = new HashMap<>();
        games.forEach((game -> {

            if(gamePredicate.test(game)){
                gameRateMap.put(game.getName(),game.getRating());
            }
        }));

        return gameRateMap;

    };

    public static void main(String[] args) {

        System.out.println(biFunction.apply(GameService.getAllGames(), PredicateLab.p1));

    }

}
