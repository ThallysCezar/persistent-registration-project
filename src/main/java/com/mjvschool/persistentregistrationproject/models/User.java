package com.mjvschool.persistentregistrationproject.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String fullName;
    private Long age;
    private String profession;

    public User() {
    }

    public User(String fullName, Long age, String profession) {
        this.fullName = fullName;
        this.age = age;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "'" + fullName + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'';
    }

}