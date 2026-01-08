package com.hashmapandhashfunction.implementcustomhashmap;

import java.util.*;

class MyHashMap {

    private static class Node {
        int key, value;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int SIZE = 5;
    private LinkedList<Node>[] table;

    MyHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++)
            table[i] = new LinkedList<>();
    }

    private int hash(int key) {
        return key % SIZE;
    }

    void put(int key, int value) {
        int index = hash(key);
        for (Node n : table[index]) {
            if (n.key == key) {
                n.value = value;
                return;
            }
        }
        table[index].add(new Node(key, value));
    }

    Integer get(int key) {
        int index = hash(key);
        for (Node n : table[index]) {
            if (n.key == key)
                return n.value;
        }
        return null;
    }

    void remove(int key) {
        int index = hash(key);
        table[index].removeIf(n -> n.key == key);
    }

}
