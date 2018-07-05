package com.everis.digit.lambda;

import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.Executors.newScheduledThreadPool;

public class E02_ThreadExample {

    public static final String MSG_TXT = "msg.txt";

    public static void main(String[] args) {

        final ScheduledExecutorService scheduler = newScheduledThreadPool(2);

        /**
         * Print "Fizz" every 3 seconds
         */

        /**
         * Print "Buzz" every 2 seconds...maybe read file?
         */

    }

}
