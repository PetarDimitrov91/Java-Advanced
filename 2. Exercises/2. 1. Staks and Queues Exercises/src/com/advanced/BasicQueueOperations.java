package com.advanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

                int[] instructions = Arrays.stream(console.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();
                int[] numbers = Arrays.stream(console.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();

                int elementToPush = instructions[0];
                int elementToPop = instructions[1];
                int elementToCheck = instructions[2];

                ArrayDeque<Integer> queueOfIntegers = new ArrayDeque<>();

                for (int i = 0; i < elementToPush; i++) {
                    queueOfIntegers.offer(numbers[i]);
                }
                for (int i = 0; i < elementToPop; i++) {
                    queueOfIntegers.poll();
                }
                if (queueOfIntegers.contains(elementToCheck)) {
                    System.out.println(queueOfIntegers.contains(elementToCheck));
                } else {
                    System.out.println(smallestNumber(queueOfIntegers));
                }
            }

            private static int smallestNumber(ArrayDeque<Integer> queue) {
                if(queue.isEmpty()){
                    return 0;
                }
                int smallestNumber = Integer.MAX_VALUE;
                for (Integer integer : queue) {
                    if (integer < smallestNumber) {
                        smallestNumber = integer;
                    }
                }
                return smallestNumber;
            }
        }

