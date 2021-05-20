package com.advanced;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		int elementToPush = console.nextInt();
		int elementToPop = console.nextInt();
		int elementToCheck = console.nextInt();

		ArrayDeque<Integer> stackOfIntegers = new ArrayDeque<>();

		for (int i = 0; i < elementToPush; i++) {
			stackOfIntegers.push(console.nextInt());
		}
		for (int i = 0; i < elementToPop; i++) {
			stackOfIntegers.pop();
		}
		if (stackOfIntegers.contains(elementToCheck)) {
			System.out.println(stackOfIntegers.contains(elementToCheck));
		} else {
			if(stackOfIntegers.isEmpty()){
				System.out.println(0);
			}else {
			System.out.println(Collections.min(stackOfIntegers));
			}
		}
	}
}

