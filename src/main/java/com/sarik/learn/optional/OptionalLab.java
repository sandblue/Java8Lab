package com.sarik.learn.optional;

import com.sarik.learn.data.GameService;
import com.sarik.learn.data.StudentDataBase;
import com.sarik.learn.data.model.Bike;
import com.sarik.learn.data.model.Game;
import com.sarik.learn.data.model.Student;

import java.util.Optional;

public class OptionalLab {

    public static void main(String[] args) {

        if(getGameNameOptional().isPresent()){
            System.out.println(getGameNameOptional().get());
        }else{
            System.out.println("Name is returned as empty.");
        }

        optionalFlatMap();
        optionalMap();
        optionalFilter();

        ifPresent();

        System.out.println(optionalOrElse());
        System.out.println(optionalOrElseGet());
        System.out.println(optionalOrElseThrow());
    }

    public static String getGameName(){
        //Game game = GameService.gameSupplier.get();
        Game game = null;
        if(game!=null){
            return  game.getName();
        }else{
            return  null;
        }
    }

    public static Optional<String> getGameNameOptional(){

        Optional<Game> gameOptional = Optional.ofNullable(GameService.gameSupplier.get());
        //Optional<Game> gameOptional = Optional.ofNullable(null);

        if(gameOptional.isPresent()){
            // don't get confused this with streams map method. Both are different.
            return  gameOptional.map(Game::getName);
        }
        return Optional.empty();
    }

    public static void optionalFlatMap(){
        Optional<Student> studentOptional =  StudentDataBase.getOptionalStudent();
        if(studentOptional.isPresent()){
            Optional<Bike> bikeOptional= studentOptional.
                    flatMap(Student::getBike); //
            System.out.println("bikeOptional : " + bikeOptional);
        }
    }

    public static void optionalMap(){
        Optional<Student> studentOptional =  StudentDataBase.getOptionalStudent();

        if(studentOptional.isPresent()){
            Optional<String> nameOptional= studentOptional.
                    map(Student::getName); //
            System.out.println("nameOptional : " + nameOptional);
        }
    }

    public static void optionalFilter(){

        Optional<Student> studentOptional = StudentDataBase.getOptionalStudent()
                .filter(student -> student.getGpa()>=4.3);

        studentOptional.ifPresent(student -> System.out.println(student));

    }

    public static void ifPresent(){
        Optional<String> stringOptional = Optional.ofNullable("Hello Optional");

        System.out.println(stringOptional.isPresent());

        stringOptional.ifPresent((s -> System.out.println("value is : " + s)));
    }

    public static String optionalOrElse(){

        //Optional<Student> getOptionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optionalStudent = Optional.ofNullable(null);

        String name =  optionalStudent.map(Student::getName).orElse("Default");

        return name;

    }

    public static String optionalOrElseGet(){

        //Optional<Student> getOptionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optionalStudent = Optional.ofNullable(null);

        String name =  optionalStudent.map(Student::getName).orElseGet(()->"Default");

        return name;

    }

    public static String optionalOrElseThrow(){

        //Optional<Student> getOptionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optionalStudent = Optional.ofNullable(null);

        String name =  optionalStudent.map(Student::getName).orElseThrow(()->new RuntimeException("No Data available"));

        return name;

    }

}
