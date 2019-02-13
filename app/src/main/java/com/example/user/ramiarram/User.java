package com.example.user.ramiarram;

public class User {
    private String Name;
    private String Age;
    private String Number;

    public User(String name, String age, String number) {
        Name = name;
        Age = age;
        Number = number;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
