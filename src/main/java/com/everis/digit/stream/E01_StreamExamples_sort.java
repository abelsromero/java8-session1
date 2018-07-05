package com.everis.digit.stream;

import com.everis.digit.lambda.model.Sex;
import com.everis.digit.lambda.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E01_StreamExamples_sort {

    public static void main(String[] args) {

        final List<User> users = Arrays.asList(
            new User("John", Sex.M, 42),
            new User("Sarah", Sex.F, 8),
            new User("Dan", Sex.M, 38),
            new User("Jane", Sex.F, 22),
            new User("Timmy", Sex.M, 10)
        );
        users.forEach(System.out::println);

        /**
         * Demo starts here
         */
        final E01_StreamExamples_sort runner = new E01_StreamExamples_sort();

        // Sort ASC (1 - 2)
        System.out.println("> Good old Java");
        System.out.println(runner.oldFilter(users));

//        System.out.println("> With a Stream");
//        System.out.println(runner.lambdaFilter(users));

        System.out.println("> finish!!");
    }


    public List<String> oldFilter(final List<User> users) {

        final List<String> names = new ArrayList<>();
        // beware side effects
        users.sort((u1, u2) -> u2.getAge() - u1.getAge());

        for (User user : users) {
            if (user.getAge() >= 18) {
                final String name = user.getName();
                names.add(name);
            }
        }
        return names;
    }

    // Sort ASC (1 - 2)
//    public List<String> lambdaFilter(final List<User> users) {
//    }


}
