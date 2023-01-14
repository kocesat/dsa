package com.kocesat.datastructure.complexity;

public class Main {
    public static void main(String[] args) {

    }

    public static void log(int[] numbers) {
        // Time complexity

        // O(1) constant complexity
        System.out.println(numbers[0]);

        // O(n) linear complexity
        for (int number : numbers) {
            System.out.println(number);
        }

        // O(n^2) quadratic complexity
        for (int first: numbers) { // O(n)
            for (int second : numbers) { // O(n)
                System.out.println("first: " + first + ", second: " + second);
            }
        }

        // O(n^3) qubic complexity
        for (int first: numbers) { // O(n)
            for (int second : numbers) { // O(n)
                for (int third : numbers) { // O(n)
                    System.out.println("first: " + first + ", second: " + second);
                }
            }
        }

        // O(log n) logarithmic complexity
        // binary search algorithm

        // O(2^n) exponential complexity
        // The worst complexity
     }

    // Space Complexity
    // Additional memory consumption
    // Don't count input space
    public static void greet(String[] names) {
        // O(1) space because only one space for variable i created
        for (int i = 0; i < names.length; i++) {
            System.out.println("Hi " + names[i]);
        }

        // O(n) space
        String[] copy = new String[names.length];


    }
}
