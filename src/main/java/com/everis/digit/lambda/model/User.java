package com.everis.digit.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class User {

    private String name;
    private Sex sex;
    private Integer age;

    boolean isMale() {
        return sex.equals(Sex.M);
    }

    boolean isWomen() {
        return sex.equals(Sex.F);
    }

}
