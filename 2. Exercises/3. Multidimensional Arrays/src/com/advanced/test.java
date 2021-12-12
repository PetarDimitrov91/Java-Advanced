package com.advanced;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        for (int i = 0; i <n ; i++) {
            printStar(n);
        }
    }

    private static void printStar(int n) {
        for (int i = 0; i <n ; i++) {
            System.out.print("*"+ " ");
        }
        System.out.println();
    }
}
