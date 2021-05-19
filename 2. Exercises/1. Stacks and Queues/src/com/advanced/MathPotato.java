package com.advanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String[] names = console.nextLine().split("\\s+");
		int n = Integer.parseInt(console.nextLine());

		ArrayDeque<String> queueOfNames = new ArrayDeque<>();

		for (String name : names) {
			queueOfNames.offer(name);
		}
		int cycle = 1;
		while (queueOfNames.size() > 1) {
			for (int i = 1; i < n; i++) {
				queueOfNames.offer(queueOfNames.poll());
			}
			if(!isPrime(cycle)){
			System.out.println("Removed " + queueOfNames.poll());
			}else {
				System.out.println("Prime " + queueOfNames.peek());
			}
			cycle++;
		}
		System.out.println("Last is " + queueOfNames.poll());
	}

	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}

