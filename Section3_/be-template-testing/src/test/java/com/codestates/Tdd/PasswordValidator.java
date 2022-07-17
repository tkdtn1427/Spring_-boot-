package com.codestates.Tdd;

import java.util.regex.Pattern;

public class PasswordValidator {

    public void validate(String password){
//        boolean containSpecial = password.chars()
//                .anyMatch(ch -> !(Character.isDigit(ch) || Character.isAlphabetic(ch)));
//
//        if(!containSpecial){
//            throw new RuntimeException("Invalid");

        if (!Pattern.matches("(?=.*\\W)(?=\\S+$).+", password)) {
            throw new RuntimeException("Invalid password");
        }
    }
}
