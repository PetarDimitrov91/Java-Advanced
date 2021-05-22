package com.advanced;

import java.util.Scanner;

public class TernaryOperator {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int n = Integer.parseInt(console.nextLine());
		int s = Integer.parseInt(console.nextLine());

		String message = "";

		final String sds =n + s > 20
				? "yes"
				: "no";
	}
}
