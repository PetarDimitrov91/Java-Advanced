package com.advanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConvertor {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		int number = Integer.parseInt(console.nextLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		if (number == 0) {
			stack.push(number);
			System.out.print(stack.pop());
		}else{
		while (number != 0) {
			stack.push(number % 2);
			number /= 2;
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		}
	}
}
