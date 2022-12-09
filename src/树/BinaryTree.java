package 树;

/**
 * @author 胡茂洋
 */
public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }
    public void preOrder(){
        this.root.preOrder();
    }
    public void infixOrder(){
        this.root.infixOrder();
    }
    public void postOrder(){
        this.root.postOrder();
    }
    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        BinaryTree binaryTree = new BinaryTree(node1);
        binaryTree.preOrder();
        System.out.println("-----------------------------");
        binaryTree.infixOrder();
        System.out.println("-----------------------------");
        binaryTree.postOrder();
    }
}
class Node {
    private int id;
    private Node left;
    private Node right;

    public Node(int id, Node left, Node right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
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

        return id == node.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    /**
     * 后序遍历
     */
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
}