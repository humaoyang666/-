package 哈希表;

import java.util.Objects;

public class HashMap {
    private NodeLinkedList[] nodeLinkedLists;
    private int size;
    public HashMap(int size) {
        this.size=size;
        nodeLinkedLists=new NodeLinkedList[size];
        for (int i = 0; i < nodeLinkedLists.length; i++) {
            nodeLinkedLists[i]=new NodeLinkedList();
        }
    }
    public void add(Node node){
        nodeLinkedLists[getIdx(node)].addNode(node);
    }
    public void list(){
        for (NodeLinkedList nodeLinkedList : nodeLinkedLists) {
            nodeLinkedList.list();

        }
    }
    public Node findNodeById(int id){
        return nodeLinkedLists[getIdx(new Node(id))].findNodeById(id);
    }
    private int getIdx(Node node){
        return  node==null? 0 : node.hashCode()%size;
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(10);
        hashMap.add(new Node(1,"胡茂洋"));
        hashMap.add(new Node(2,"胡茂洋"));
        hashMap.add(new Node(7,"胡茂洋"));
        hashMap.add(new Node(11,"胡茂洋"));
        hashMap.add(new Node(13,"胡茂洋"));
        hashMap.list();
        System.out.println(hashMap.findNodeById(1));
        System.out.println(hashMap.findNodeById(9));
    }
}
class Node{
    private int id;
    private String name;
    private Node next;
    public Node(int id, String name) {
        this.id = id;
        this.name = name;
        this.next=null;
    }

    public Node(int id) {
        this.id = id;
    }

    public Node(int id, String name, Node next) {
        this.id = id;
        this.name = name;
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node node = (Node) o;

        if (id != node.id) {
            return false;
        }
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
class NodeLinkedList{
    private Node head;
    public void addNode(Node node){
        if(head==null){
            head=node;
            return;
        }
        Node n=head;
        while (n.getNext()!=null){
            n=n.getNext();
        }
        n.setNext(node);
    }
    public void list(){
        Node n=head;
        while (n!=null){
            System.out.print(n+"\t");
            n=n.getNext();
        }
        System.out.println();
    }
    public Node findNodeById(int id){
        Node node=null;
        Node n=head;
        while (n!=null){
            if(n.getId() == id){
                node=n;
                break;
            }
            n=n.getNext();
        }
        return node;
    }
}