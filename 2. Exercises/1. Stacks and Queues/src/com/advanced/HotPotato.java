package com.advanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		String[] names = console.nextLine().split("\\s+");
		int n = Integer.parseInt(console.nextLine());

		ArrayDeque<String> queueOfNames = new ArrayDeque<>();

		for (String name : names) {
			queueOfNames.offer(name);
		}

		while (queueOfNames.size() > 1) {
			for (int i = 1; i < n; i++) {
				queueOfNames.offer(queueOfNames.poll());
			}
			System.out.println("Removed " + queueOfNames.poll());
		}
		System.out.println("Last is " + queueOfNames.poll());
	}
}
