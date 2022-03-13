package com.sarik.learn.streams;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.model.Game;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class StreamsOperatorLab {

    public static List<Game> filterGame(){

        List<Game> filteredGameList = GameService.getAllGames()
                .stream()
                .filter(student -> student.getRating()>=3.9)
                .collect(toList());

        return filteredGameList;
    }


    public static int performMultiplication(List<Integer> integerList){

        return integerList.stream()
                .reduce(1, (a,b) -> a*b);

    }

    public static Optional<Integer> performMultiplicationWithNoInitialValue(List<Integer> integerList){

        return integerList.stream()
                .reduce( (a,b) -> a*b); // performs multiplication for each element in the stream and returns a new result fo.
    }

    public static String combineGameNames(){

        return GameService.getAllGames().stream()
                .map(Game::getName)
                .distinct()
                .reduce("",(a,b) -> a.concat(b));  // performs multiplication for each element in the stream.
    }

    public static Optional<Game> getHighestRatingGame(){

        Optional<Game> gameOptional =  GameService.getAllGames().stream()
                .reduce((s1,s2)->(s1.getRating()>s2.getRating()) ? s1 : s2);
        return gameOptional;
    }

    public static void labReduce(){
        List<Integer> integerList = Arrays.asList(1,3,5,7);
        //List<Integer> integerList = Arrays.asList();

        System.out.println("Result is : " + performMultiplication(integerList));
        Optional<Integer> result = performMultiplicationWithNoInitialValue(integerList);

        if(result.isPresent()){
            System.out.println("Result is : " +result.get());
        }else{
            System.out.println("Result is : " +0);
        }

        System.out.println(combineGameNames());
        System.out.println(getHighestRatingGame().get());
    }

    public static void labFilter() {
        System.out.println("Filtered game : " + filterGame());
    }


    public static void main(String[] args) {
        labFilter();
        labReduce();

    }
}
