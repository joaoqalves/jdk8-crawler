package net.joaoqalves.util;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Future {

    /**
     * Transforms a CompletableFuture<List<T>> to a List<CompletableFuture<T>>>,
     * because Java's Futures are not as cool as Scala's. God bless Scala :-)
     */
    public static <T> CompletableFuture<List<T>> sequence(final List<CompletableFuture<T>> futures) {
        return CompletableFuture.supplyAsync(() -> futures.stream().
                map(future -> future.join()).
                collect(Collectors.<T>toList()));
    }

}
