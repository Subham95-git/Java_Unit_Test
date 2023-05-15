package com.subham.tdd;

public class FizzBuzz {


    public static String compute(int i) {

        if(i%3==0 && i%5==0)
            return "FizzBuzz";
        else if(i%5==0)
            return "Buzz";
        else if(i%3==0)
            return "Fizz";
        else
            return String.valueOf(i);
    }
}
