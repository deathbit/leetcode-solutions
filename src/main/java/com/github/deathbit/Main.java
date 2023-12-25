package com.github.deathbit;

public class Main {

    public static void main(String[] args) {
        String s = "123@456@8_2222";
        System.out.println(s.substring(0, s.lastIndexOf("@")));
    }
}
