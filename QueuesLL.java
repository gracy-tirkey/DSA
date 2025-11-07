public class QueuesLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedListQueue {
        private Node front;
        private Node rear;
        private int size;

        public LinkedListQueue() {
            this.front = null;
            this.rear = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void enqueue(int item) {
            Node newNode = new Node(item);
            if (rear != null) {
                rear.next = newNode;
            }
            rear = newNode;
            if (front == null) {
                front = newNode;
            }
            size++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int item = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return item;
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return front.data;
        }

        public int getSize() {
            return size;
        }
    }
    public static void main(String[] args) {
        LinkedListQueue llq = new LinkedListQueue();

        llq.enqueue(10);
        llq.enqueue(20);
        llq.enqueue(30);

        System.out.println("Front item is: " + llq.peek()); // 10
        System.out.println("Queue size is: " + llq.getSize()); // 3

        System.out.println("Dequeued item: " + llq.dequeue()); // 10
        System.out.println("Front item is: " + llq.peek()); // 20
        System.out.println("Queue size is: " + llq.getSize()); // 2
    }
}
