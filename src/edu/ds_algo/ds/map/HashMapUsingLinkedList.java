package edu.ds_algo.ds.map;

public class HashMapUsingLinkedList<K, V> {

    private Node<K, V>[] bucket;
    private int capacity = 16;

    public HashMapUsingLinkedList() {
        bucket = new Node[capacity];
    }

    public HashMapUsingLinkedList(int capacity) {

        if (capacity > 0) {
            this.capacity = capacity;
            bucket = new Node[capacity];
        } else {

            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
    }

    public void put(K key, V value) {

        Node<K, V> newNode = new Node<>(key, value, null);
        int index = getIndex(key);
        if (bucket[index] == null) {

            bucket[index] = newNode;
        } else {

            Node<K, V> currentNodeAtIndex = bucket[index];

            while (currentNodeAtIndex.next != null) {

                if (currentNodeAtIndex.key.equals(key)) {

                    currentNodeAtIndex.value = value;
                    break;
                }
                currentNodeAtIndex = currentNodeAtIndex.next;
            }

            currentNodeAtIndex.next = newNode;
        }
    }

    int getIndex(K key) {

        return key.hashCode() % (capacity - 1);
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node() {
        }

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        HashMapUsingLinkedList<String, String> customHashMap = new HashMapUsingLinkedList<>(16);

        customHashMap.put("abc", "test");
        customHashMap.put("bac", "test");
        customHashMap.put("def", "test");
        customHashMap.put("abc", "def");
        customHashMap.put("abc", "def");

    }
}
