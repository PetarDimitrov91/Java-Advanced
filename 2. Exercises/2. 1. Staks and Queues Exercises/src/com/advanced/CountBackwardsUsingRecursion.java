package com.advanced;

public class CountBackwardsUsingRecursion {
    public static void main(String[] args) {
        int n = 100;
        countBacwards(n);
    }

    private static void countBacwards(int n) {
        if(n == 0){
            return;
        }
        n--;
        System.out.println(n);
        countBacwards(n);

    }
}
