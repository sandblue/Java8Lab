package com.sarik.learn.methodreference;

import com.sarik.learn.data.model.Game;

import java.util.function.Supplier;

public class SupplierMethodReferenceLab {
    static Supplier<Game> gameSupplier = Game::new;

    public static void main(String[] args) {

        System.out.println(SupplierMethodReferenceLab.gameSupplier.get());

    }
}
