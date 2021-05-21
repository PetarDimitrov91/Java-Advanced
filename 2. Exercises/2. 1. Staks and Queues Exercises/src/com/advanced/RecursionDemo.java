package com.advanced;

public class RecursionDemo {
    public static void main(String[] args) {

        // Рекурсия е метод кой вика себе си
        // Пример:

        int n = 5;

        System.out.println(fact(n));
    }

    private static int fact(int n) {
        // Всеки рекурсивен метод трябва да има дъно!
        if (n == 0) {
            return 1; // Дъно
        } else {
            return n * fact(n - 1);
        }
    }
}
