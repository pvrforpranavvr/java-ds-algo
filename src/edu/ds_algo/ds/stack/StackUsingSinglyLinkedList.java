package edu.ds_algo.ds.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Stack data structure maintains LIFO (Last In First Out) or FILO (First In Last Out)
 *
 * @param <E>
 */
public class StackUsingSinglyLinkedList<E> {

    private Node<E> headNode;

    /**
     * Pushes an item into the top of the stack.
     */
    void push(E item) {

        Node<E> newNode = new Node<>(item);

        newNode.nextNode = headNode;
        headNode = newNode;
    }

    /**
     * Pop out last element and return the value. Once stack is empty throws exception
     *
     * @return
     */
    E pop() {

        if (headNode == null) {

            throw new EmptyStackException();
        }
        E item = headNode.item;
        headNode = headNode.nextNode;

        return item;
    }

    /**
     * Always return last inserted element.
     */
    E peek() {

        return headNode.item;
    }

    /**
     * Generic linked list node consist of data and nextNode
     *
     * @param <E>
     */
    private static class Node<E> {

        private final E item;
        private Node<E> nextNode;

        public Node(E item) {
            this.item = item;
            this.nextNode = null;
        }
    }

    public static void main(String[] args) {

        StackUsingSinglyLinkedList<Integer> stackUsingSinglyLinkedList = new StackUsingSinglyLinkedList<>();

        stackUsingSinglyLinkedList.push(1);
        stackUsingSinglyLinkedList.push(2);
        stackUsingSinglyLinkedList.push(3);

        System.out.println("Last element : " + stackUsingSinglyLinkedList.peek());

        System.out.println(stackUsingSinglyLinkedList.pop());
        System.out.println(stackUsingSinglyLinkedList.pop());
        System.out.println(stackUsingSinglyLinkedList.pop());
        System.out.println(stackUsingSinglyLinkedList.pop());


    }
}
