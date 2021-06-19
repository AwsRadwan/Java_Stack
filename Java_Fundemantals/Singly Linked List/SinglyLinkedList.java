public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public void remove(){
        if(head == null) {
            System.out.println("it's alredy empty!");
        } else {
            Node runner = head;
            Node temp = runner;
            while(runner.next != null) {
                temp = runner;
                runner = runner.next;
            }
            runner = null;
            temp.next = null;
        }
    }
    public void printValues(){
        Node runner = head;
        int x;
        while(runner != null) {
            x = runner.value;
            System.out.println(x);
            runner = runner.next;
        }
    }
}