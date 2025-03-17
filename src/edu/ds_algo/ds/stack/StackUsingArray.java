package edu.ds_algo.ds.stack;

import java.util.EmptyStackException;

public class StackUsingArray<T> {

    private final T[] elementsArray;
    private int topElementIndex;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public StackUsingArray(int size) {
        elementsArray = (T[]) new Object[size];
        capacity = size;
        topElementIndex = -1;
    }

    public void push(T item) {
        if (topElementIndex == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        elementsArray[++topElementIndex] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementsArray[topElementIndex--];
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return elementsArray[topElementIndex];
    }

    public boolean isEmpty() {
        return topElementIndex == -1;
    }

    public static void main(String[] args) {
        StackUsingArray<Integer> stackUsingArray = new StackUsingArray<>(5);

        stackUsingArray.push(1);
        stackUsingArray.push(2);
        stackUsingArray.push(3);

        System.out.println("Last element : " + stackUsingArray.peek());

        System.out.println("Popped out: " + stackUsingArray.pop());
        System.out.println("Popped out: " + stackUsingArray.pop());
        System.out.println("Popped out: " + stackUsingArray.pop());
        System.out.println("Popped out: " + stackUsingArray.pop());
    }
}
