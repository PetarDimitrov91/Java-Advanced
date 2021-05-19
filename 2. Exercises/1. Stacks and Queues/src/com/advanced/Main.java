package com.advanced;

public class Main {

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}

	}


	public static boolean isPrime(int n) {
		if (n < 2){
			return false;
		}
		if(n == 2){
			return true;
		}
		if (n%2==0) return false;
		for(int i=3;i*i<=n;i+=2) {
			if(n%i==0)
				return false;
		}
		return true;

	}
}
