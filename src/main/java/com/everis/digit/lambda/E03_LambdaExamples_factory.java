package com.everis.digit.lambda;

import com.everis.digit.lambda.model.Sex;
import com.everis.digit.lambda.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class E03_LambdaExamples_factory {

    public static void main(String[] args) {

        final Supplier<String> randomName = () -> {
            int nameLength = 5;
            char[] name = new char[nameLength];
            for (int i = 0; i < nameLength; i++)
                name[i] = (char) ('a' + ThreadLocalRandom.current().nextInt(26));
            return String.valueOf(name);
        };

        final Supplier<Integer> randomInt = () -> ThreadLocalRandom.current().nextInt(90);

        final List<User> users = Arrays.asList(
            new User("John", Sex.M, 42),
            new User("Sarah", Sex.F, 8),
            new User("Dan", Sex.M, 38),
            new User("Jane", Sex.F, 22),
            new User("Timmy", Sex.M, 10),
            userFactory(randomName, Sex.M, randomInt),
            userFactory(randomName, Sex.M, randomInt),
            userFactory(() -> "Max", Sex.M, () -> 4),
            userFactory(() -> "Claudia", Sex.F, randomInt)
        );
        users.forEach(System.out::println);

        final E03_LambdaExamples_factory runner = new E03_LambdaExamples_factory();
        runner.oldFilter(users);
        runner.lambdaFilter(users);

        System.out.println("finish!!");
    }


    public List<String> oldFilter(final List<User> users) {

        final List<String> names = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() >= 18) {
                final String name = user.getName();
                names.add(name);
            }
        }
        return names;
    }


    public List<String> lambdaFilter(final List<User> users) {

        return users.stream()
            .filter(user -> user.getAge() >= 18)
            .filter(user -> user.getSex().equals(Sex.M))
            .map(User::getName)
            .collect(Collectors.toList());
    }

    /**
     * Originally we have parameters, but then we pass supplier.
     */
    public static User userFactory(Supplier<String> nameSupplier, Sex sex, Supplier<Integer> ageSupplier) {
        return new User(nameSupplier.get(), sex, ageSupplier.get());
    }

}
