import java.util.Stack;

public class PalindromeLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);
        System.out.println(isPalindrome(head)); // Output: true
    }

    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static boolean isPalindrome(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node current = head;
        
        // Push all elements of the linked list onto the stack
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }
        
        // Reset current to head to compare with stack elements
        current = head;
        
        // Compare elements from the linked list with those popped from the stack
        while (current != null) {
            if (current.data != stack.pop()) {
                return false; // Not a palindrome
            }
            current = current.next;
        }
        
        return true; // Is a palindrome
    }
}
