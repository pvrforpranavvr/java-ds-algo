package edu.ds_algo.ds.linkedlist;

public class DoublyLinkedList<E> {

    private Node<E> headNode;

    /**
     * If there is no node available in the linked list then headNode become new node. Else find the lastNode
     * of the linkedlist and nextNode of lastNode set as newNode and previousNode of newNode set as lastNode.
     *
     * @param item
     */
    public void add(E item) {

        Node<E> newNode = new Node<>(item);

        if (headNode == null) {
            headNode = newNode;
        } else {

            Node<E> lastNode = headNode;
            while (lastNode.nextNode != null) {

                lastNode = lastNode.nextNode;
            }

            newNode.previousNode = lastNode;
            lastNode.nextNode = newNode;
        }
    }

    E get(int index) {

        Node<E> nodeAtIndex = headNode;

        for (int i = 0; i <= index; i++) {

            if (i == index) {

                break;
            }
            nodeAtIndex = nodeAtIndex.nextNode;
        }

        return nodeAtIndex.item;
    }

    private static class Node<E> {

        private final E item;
        private Node<E> previousNode;
        private Node<E> nextNode;

        public Node(E item) {
            this.item = item;
            this.previousNode = null;
            this.nextNode = null;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);

        System.out.println(doublyLinkedList.get(4));
    }
}
