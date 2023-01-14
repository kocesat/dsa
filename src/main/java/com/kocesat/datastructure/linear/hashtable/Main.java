package com.kocesat.datastructure.linear.hashtable;

import com.kocesat.datastructure.linear.hashtable.impl.HashTableImpl;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTableImpl();
        hashTable.put(10, "Esat");
        hashTable.put(5, "Mosh");
        hashTable.put(15, "Addable Mosh");
        hashTable.put(5, "New Mosh");
        hashTable.remove(5);
        System.out.println(hashTable);

//        String str = "a green apple";
//        CharFinder finder = new CharFinder(str);
//        char firstRepeating = finder.firstRepeatingChar();
//        System.out.println(firstRepeating);
//        char firstNonRepeating = finder.firstNonRepeatingChar();
//        System.out.println(firstNonRepeating);
    }
}
