package 链表;

import java.util.Iterator;

public class SingleLinkedList extends LinkedList{
    private final Node head= new Node(-1);
    static class Node{
        private Node next;
        private int val;

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }
    }
    @Override
    public void add(int val){
        Node n=head;
        while (n.next!=null){
            n=n.next;
        }
        n.next= new Node(val);
    }


    @Override
    void remove(int val) {
        Node n=head;
        while (n.next!=null){
            if(val==n.next.val){
                n.next=n.next.next;
                break;
            }
            n=n.next;
        }
    }

    @Override
    public void forEach(){
        Node n=head;
        while (n.next!=null){
            n=n.next;
            System.out.print(n.val+"\t");
        }
    }
}
class SingleLinkedListTest{
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.forEach();
        System.out.println();
        singleLinkedList.remove(1);
        singleLinkedList.remove(1);
        singleLinkedList.forEach();
    }
}
