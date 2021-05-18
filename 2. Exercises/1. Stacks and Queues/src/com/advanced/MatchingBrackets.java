package com.advanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		String input = console.nextLine();
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		int startIndex;
		for (int i = 0; i < input.length() ; i++) {
			char currentSymbol = input.charAt(i);
			if (currentSymbol == '('){
				stack.push(i);
			}
			else if(currentSymbol == ')'){
				startIndex = stack.pop();
				String contents = input.substring(startIndex,i + 1);
				System.out.println(contents);
			}
		}
	}
}
