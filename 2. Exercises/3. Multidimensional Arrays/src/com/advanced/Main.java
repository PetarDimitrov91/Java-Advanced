package com.advanced;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		List<Character> list = new ArrayList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');

		boolean c = list.contains('s');
		System.out.println(c);

	}
}
