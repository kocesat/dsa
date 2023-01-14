package com.kocesat.datastructure.linear.array;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
//        System.out.println(numbers.max());
        numbers.print();
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insertAt(99, 5);
//        System.out.println(numbers.max());
//        numbers.reverse();
        numbers.print();

//        int[] otherNumbers = {20, 40, 60, 100};
//        System.out.println(numbers.intersect(otherNumbers));
    }
}
