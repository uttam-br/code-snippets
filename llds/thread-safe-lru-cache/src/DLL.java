package src;

public class DLL {

    private Node head;
    private Node tail;

    public DLL() {
        // head and tail nodes
        this.head = new Node(null, null, null);
        this.tail = new Node(null, null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public class Node {
        Node prev;
        Node next;
        String value;

        Node(Node prev, Node next, String value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    public void moveToHead(Node node) {
        remove(node);
        // move to head
        node.prev = head;
        head.next = node;
    }

    public void remove(Node node) {
        // update prev and next node pointers
        Node prev = node.prev;
        Node next = node.next;
        // remove from position
        prev.next = next;
        next.prev = prev;
    }

    public void add(Node node) {

    }

}
