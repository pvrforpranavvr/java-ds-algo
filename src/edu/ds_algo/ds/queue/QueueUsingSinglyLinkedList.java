package edu.ds_algo.ds.queue;

/**
 * Queue data structure maintains FIFO (First In First Out) or LILO (Last In Last Out)
 *
 * @param <E>
 */
public class QueueUsingSinglyLinkedList<E> {

    private Node<E> headNode;

    /**
     * Add item to the tail end of the linked list.
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
     * Always return first inserted element.
     *
     * @return
     */
    public E peek() {

        return headNode.item;
    }

    /**
     * Poll first element and remove from the queue.
     *
     * @return
     */
    public E poll() {

        E item = null;
        if (headNode != null) {

            item = headNode.item;
            headNode = headNode.nextNode;
        }
        return item;
    }


    private static class Node<E> {

        private final E item;
        private Node<E> nextNode;

        private Node(E item) {
            this.item = item;
            this.nextNode = null;
        }
    }

    public static void main(String[] args) {

        QueueUsingSinglyLinkedList<Integer> integerQueueUsingSinglyLinkedList = new QueueUsingSinglyLinkedList<>();

        integerQueueUsingSinglyLinkedList.add(1);
        integerQueueUsingSinglyLinkedList.add(2);
        integerQueueUsingSinglyLinkedList.add(3);

        System.out.println("First element: " + integerQueueUsingSinglyLinkedList.peek());
        System.out.println("First element: " + integerQueueUsingSinglyLinkedList.peek());

        System.out.println(integerQueueUsingSinglyLinkedList.poll());
        System.out.println(integerQueueUsingSinglyLinkedList.poll());
        System.out.println(integerQueueUsingSinglyLinkedList.poll());
        System.out.println(integerQueueUsingSinglyLinkedList.poll());
    }
}
