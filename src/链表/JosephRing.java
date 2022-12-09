package 链表;

import java.util.Scanner;

public class JosephRing {
    public SingleLinkedList.Node head=new SingleLinkedList.Node(-1);
    public SingleLinkedList.Node tail=head;
    public SingleLinkedList.Node pre=head;
    public SingleLinkedList.Node now=head;
    private boolean canAdd=true;
    void add(int val) {
        if(canAdd){
            tail.setNext(new SingleLinkedList.Node(val));
            tail=tail.getNext();
        }else {
            System.out.println("不能添加");
        }

    }
    void remove() {
        pre.setNext(now.getNext());
    }
    void makeAnnular(){
        this.head=head.getNext();
        tail.setNext(head);

        canAdd=false;
    }
    void show(){
    }
}
class JosephRingTest{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        JosephRing josephRing = new JosephRing();
        for (int i=0;i<10;i++){
            josephRing.add(i);
        }
        josephRing.makeAnnular();
        int m=3;
        int i=1;
        josephRing.pre= josephRing.tail;
        josephRing.now= josephRing.head;
        while (josephRing.now!=josephRing.now.getNext()){
            if(i==m){
                i=1;
                josephRing.remove();
                josephRing.now= josephRing.pre.getNext();
            }else {
                i++;
                josephRing.now=josephRing.now.getNext();
                josephRing.pre= josephRing.pre.getNext();
            }
        }
        System.out.println(josephRing.now.getVal());
    }
}