package edu.ds_algo.ds.linkedlist;

public class SinglyLinkedList<E> {

    private Node<E> headNode;

    /**
     * Adds item to lastNode of the linkedList. For that we need to find the lastNode.
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

            lastNode.nextNode = newNode;
        }
    }

    /**
     * @param index
     * @return
     */
    E get(int index) {

        E itemAtIndex = null;
        Node<E> nodeAtIndex = headNode;

        for (int currentPos = 0; currentPos <= index; currentPos++) {

            if (nodeAtIndex == null) {

                throw new ArrayIndexOutOfBoundsException();
            }

            if (currentPos == index) {

                itemAtIndex = nodeAtIndex.item;
                break;
            }
            nodeAtIndex = nodeAtIndex.nextNode;
        }

        return itemAtIndex;
    }

    private static class Node<E> {

        private final E item;
        private Node<E> nextNode;

        public Node(E item) {
            this.item = item;
            this.nextNode = null;
        }
    }

    public static void main(String[] args) {

        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println(linkedList.get(2));
    }
}
