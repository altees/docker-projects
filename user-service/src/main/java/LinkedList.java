


public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;

        }

        Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }


    }



    public void addHead(T value) {
        //Node<T> prev=this.head.prev;
        Node<T> node = new Node(value, this.head, null);
        this.head = node;
        Node<T> pointer = this.head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        this.tail = pointer;
    }


    public void reverse() {
        Node<T> curr = this.tail;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.prev;
        }

    }


    public void get() {
        Node<T> pointer = this.head;
        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
        //System.out.println(pointer.value);


    }

    public void add(T value) {
        Node<T> node = new Node(value);
        if (this.head == null || this.tail == null) {
            //empty list no head and tail present
            this.head = node;
            this.tail = node;
            return;
        }
        Node<T> current = this.head;
        while (current != null) {
            current = current.next;
        }
        current = node;
        this.tail = node;
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        list.get();
        //list.reverse();
        // System.out.println(list.head.value);
        //System.out.println(list.tail.value);
    }

}