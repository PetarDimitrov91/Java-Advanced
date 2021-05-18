package com.advanced;

import java.util.*;

public class Calculator {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		String[] input = console.nextLine().split("\\s+");
		Deque<String> elements = new ArrayDeque<>();
		Collections.addAll(elements,input);

		while (elements.size() > 1) {
			int first = Integer.parseInt(elements.pop());
			String op = elements.pop();
			int second = Integer.parseInt(elements.pop());

			switch (op) {
				case "+":
					elements.push(String.valueOf(first + second));
					break;
				case "-":
					elements.push(String.valueOf(first - second));
					break;
			}
		}

		System.out.println(elements.pop());


	}
}
