package 树;
public class ThreadedBinaryTree {
    private ThreadedBinaryTreeNode root;
    private ThreadedBinaryTreeNode pre;
    public ThreadedBinaryTree(ThreadedBinaryTreeNode root) {
        this.root = root;
    }
    public void threadedNode(){
        threadedNode(this.root);
    }
    public void threadedList(){
        ThreadedBinaryTreeNode node=root;
        while (node!=null){
            while (node.isHaveLeftTree()){
                node=node.getLeft();
            }
            System.out.println(node);
            while (!node.isHaveRightTree()){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }
    }
    public void threadedNode(ThreadedBinaryTreeNode node){
        if(node==null){
            return;
        }
        threadedNode(node.getLeft());
        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setHaveLeftTree(false);
        }
        if(pre!=null&&pre.getRight()==null){
            pre.setRight(node);
            pre.setHaveRightTree(false);
        }
        pre=node;
        threadedNode(node.getRight());
    }
    public static void main(String[] args){
        ThreadedBinaryTreeNode root=new ThreadedBinaryTreeNode(1);
        ThreadedBinaryTreeNode node2=new ThreadedBinaryTreeNode(3);
        ThreadedBinaryTreeNode node3=new ThreadedBinaryTreeNode(6);
        ThreadedBinaryTreeNode node4=new ThreadedBinaryTreeNode(8);
        ThreadedBinaryTreeNode node5=new ThreadedBinaryTreeNode(10);
        ThreadedBinaryTreeNode node6=new ThreadedBinaryTreeNode(14);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree tree = new ThreadedBinaryTree(root);
        tree.threadedNode();
        tree.threadedList();
    }
}
class ThreadedBinaryTreeNode extends Node{
    private boolean isHaveLeftTree;
    private boolean isHaveRightTree;
    private ThreadedBinaryTreeNode left;
    private ThreadedBinaryTreeNode right;
    public ThreadedBinaryTreeNode(int id) {
        super(id);
        this.isHaveLeftTree=true;
        this.isHaveRightTree=true;
    }
    public boolean isHaveLeftTree() {
        return isHaveLeftTree;
    }
    public void setHaveLeftTree(boolean haveLeftTree) {
        isHaveLeftTree = haveLeftTree;
    }

    public boolean isHaveRightTree() {
        return isHaveRightTree;
    }

    @Override
    public ThreadedBinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedBinaryTreeNode left) {
        this.left = left;
    }

    @Override
    public ThreadedBinaryTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadedBinaryTreeNode right) {
        this.right = right;
    }

    public void setHaveRightTree(boolean haveRightTree) {
        isHaveRightTree = haveRightTree;
    }
}