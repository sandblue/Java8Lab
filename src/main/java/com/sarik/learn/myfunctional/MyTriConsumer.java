package com.sarik.learn.myfunctional;

import java.util.Objects;

@FunctionalInterface
public interface MyTriConsumer <T, U, V> {
    void accept(T var1, U var2, V var3);

    default MyTriConsumer<T, U, V> andThen(MyTriConsumer<? super T, ? super U, ? super V> after) {
        Objects.requireNonNull(after);
        return (l, r, v) -> {
            this.accept(l, r, v);
            after.accept(l, r, v);
        };
    }
}
