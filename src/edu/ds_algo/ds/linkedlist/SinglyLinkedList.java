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

        for (int currentIndex = 0; currentIndex <= index; currentIndex++) {

            if (nodeAtIndex == null) {

                throw new ArrayIndexOutOfBoundsException();
            }

            if (currentIndex == index) {

                itemAtIndex = nodeAtIndex.item;
                break;
            }
            nodeAtIndex = nodeAtIndex.nextNode;
        }

        return itemAtIndex;
    }

    /**
     * Remove node at the given index.
     *
     * @param index
     */
    void remove(int index) {

        Node<E> currentNode = headNode;
        Node<E> previousNode = headNode;

        for (int currentIndex = 0; currentIndex <= index; currentIndex++) {

            if (currentNode == null) {

                throw new ArrayIndexOutOfBoundsException();
            }

//            If only one node exists.
            if (index == 0 && headNode.nextNode == null) {
                headNode = null;
                break;
            }

            if (index == currentIndex) {

                if (currentIndex == 0) {

                    currentNode = currentNode.nextNode;
                    headNode = currentNode;
                    break;
                } else {

                    previousNode.nextNode = currentNode.nextNode;
                }

            }

            previousNode = currentNode;
            currentNode = currentNode.nextNode;

        }
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

        linkedList.remove(2);

    }
}
