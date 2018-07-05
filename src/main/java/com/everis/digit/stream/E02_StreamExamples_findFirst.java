package com.everis.digit.stream;

import com.everis.digit.lambda.model.Sex;
import com.everis.digit.lambda.model.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class E02_StreamExamples_findFirst {

    public static void main(String[] args) {


        final List<User> users = Arrays.asList(
            new User("John", Sex.M, 42),
            new User("Sarah", Sex.F, 8),
            new User("Dan", Sex.M, 38),
            new User("Jane", Sex.F, 22),
            new User("Timmy", Sex.M, 10)
        );
//        users.forEach(System.out::println);

        final E02_StreamExamples_findFirst runner = new E02_StreamExamples_findFirst();

        // sort DESC (2 - 1)
        System.out.println("> Good old Java");
        System.out.println(runner.oldYoungerUser(users));

        System.out.println("> With a Stream");
        System.out.println(runner.lambdaYoungerUser(users));

        System.out.println("> finish!!");
    }

    private User oldYoungerUser(List<User> users) {
        if (users.size() == 0) throw new IllegalArgumentException("Required at least one user");

        User minUser = users.get(0);
        for (User user : users) {
            if (user.getAge() < minUser.getAge()) {
                minUser = user;
            }
        }
        return minUser;
    }


    /**
     * How about limit?
     */
    private User lambdaYoungerUser(List<User> users) {
        return users.stream()
            .filter((User user) -> {
                /**
                 * You can add any normal code in a lambda
                 */
                // System.out.println("Checking: " + user);
                return user.getAge() >= 18;
            })
            .sorted((o1, o2) -> o2.getAge() - o1.getAge())
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Required at least one user"));
    }


    private User streamYoungerUser(List<User> users) {
        return users.stream()
            .sorted(Comparator.comparingInt(User::getAge))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Required at least one user"));
    }

}
