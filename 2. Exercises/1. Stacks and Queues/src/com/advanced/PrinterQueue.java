package com.advanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		String fileToPrint = console.nextLine();
		ArrayDeque<String> stackOfFiles = new ArrayDeque<>();

		while (!fileToPrint.equals("print")){

			if(fileToPrint.equals("cancel")){
				if(!stackOfFiles.isEmpty()){
					System.out.printf("Canceled %s%n",stackOfFiles.poll());
				}else{
					System.out.println("Printer is on standby");
				}
			}else {
				stackOfFiles.offer(fileToPrint);
			}
			fileToPrint = console.nextLine();
		}
		stackOfFiles.forEach(System.out::println);



	}

}
