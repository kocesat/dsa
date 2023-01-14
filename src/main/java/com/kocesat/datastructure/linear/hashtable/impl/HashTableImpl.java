package com.kocesat.datastructure.linear.hashtable.impl;

import com.kocesat.datastructure.linear.hashtable.HashTable;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTableImpl implements HashTable {
    private class KeyValuePair<K, V> {
        private K key;
        private V value;

        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private LinkedList<KeyValuePair<Integer, String>>[] pairs = new LinkedList[10];

    @Override
    public void put(int key, String val) {
        var pair = getKVPair(key);
        if (pair != null) {
            pair.value = val;
            return;
        }
        getOrCreateBucket(key).add(new KeyValuePair<>(key, val));
    }

    @Override
    public String get(int key) {
        var pair = getKVPair(key);
        return pair == null ? null : pair.getValue();
    }

    @Override
    public boolean remove(int key) {
        var entry = this.getKVPair(key);
        if (entry == null) {
            throw new IllegalStateException();
        }
        return getBucket(key).remove(entry);
    }

    private KeyValuePair<Integer, String> getKVPair(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    private LinkedList<KeyValuePair<Integer, String>> getBucket(int key) {
        return pairs[getHash(key)];
    }

    private int getHash(int key) {
        return key % pairs.length;
    }

    private LinkedList<KeyValuePair<Integer, String>> getOrCreateBucket(int key) {
        var index = this.getHash(key);
        var bucket = getBucket(key);
        if (bucket == null) {
            pairs[index] = new LinkedList<>();
        }
        return pairs[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(pairs);
    }
}
