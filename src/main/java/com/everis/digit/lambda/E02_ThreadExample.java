package com.everis.digit.lambda;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;

import static java.util.concurrent.Executors.newScheduledThreadPool;

public class E02_ThreadExample {

    public static final String MSG_TXT = "msg.txt";

    public static void main(String[] args) {

        final ScheduledExecutorService scheduler = newScheduledThreadPool(2);

        scheduler.scheduleAtFixedRate(() -> System.out.println("Fizz"),
            0l, 3l, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() ->  {
            System.out.println("Buzz");
                try {
                    final String msg = IOUtils.toString(E02_ThreadExample.class.getClassLoader().getResourceAsStream(MSG_TXT));
                    System.out.println(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            },
            0l, 2l, TimeUnit.SECONDS);

    }

}
