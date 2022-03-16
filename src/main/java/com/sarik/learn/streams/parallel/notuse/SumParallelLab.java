package com.sarik.learn.streams.parallel.notuse;

import java.util.stream.IntStream;

public class SumParallelLab {
    public static void main(String[] args) {

        Sum sum=new Sum();

        IntStream.rangeClosed(1,1000)
                .parallel()
                .forEach(sum::performSum); //result should equal : 500500

        // but parallel make it false value
        System.out.println(sum.getTotal());

        IntStream.rangeClosed(1,1000)
                .parallel()
                .forEach(sum::performSumSync); //result should equal : 500500

        // synchronized make it right [trade with performance]
        System.out.println(sum.getTotalWithSync());
    }
}
