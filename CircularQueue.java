public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        System.out.println("Front item: " + cq.peek()); // 10
        System.out.println("Dequeued: " + cq.dequeue()); // 10
        System.out.println("Front item after dequeue: " + cq.peek()); // 20
        cq.enqueue(40);
        cq.enqueue(50);
        cq.enqueue(60);
        cq.enqueue(70); // Queue is full
        while (!cq.isEmpty()) {
            System.out.println("Dequeued: " + cq.dequeue());
        }
        cq.dequeue(); // Queue is empty
    }
}
