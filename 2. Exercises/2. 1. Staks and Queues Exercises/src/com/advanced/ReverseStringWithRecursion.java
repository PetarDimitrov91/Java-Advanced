package com.advanced;

public class ReverseStringWithRecursion {
    public static void main(String[] args) {
        String name = "Petar";
        System.out.println(reverseString(name));

    }

    private static String reverseString(String name) {
       if(name.isEmpty()){
           return name;
       }
       return reverseString(name.substring(1)) + name.charAt(0);
    }
}
