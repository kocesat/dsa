package com.kocesat.datastructure.linear.hashtable;

public interface HashTable {

    void put(int key, String val);

    String get(int key);

    boolean remove(int key);
}
