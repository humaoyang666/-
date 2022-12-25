package 树;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class AVLTree{
    private AVLTreeNode root;

    public AVLTree(AVLTreeNode root) {
        this.root = root;
    }

    public AVLTree() {
    }
    public AVLTreeNode search(int val){
        return  root==null? null:root.searchNode(val);
    }
    public AVLTreeNode searchFather(int val){
        return  root==null? null:root.searchFatherNode(val);
    }
    public void deleteNode(int val){
        if(root==null){
            return;
        }
        AVLTreeNode targetNode = search(val);
        if(targetNode==null){
            return;
        }
        //if is rootNode and tree only have rootNode
        if(root==targetNode&&root.getLeft()==null&&root.getRight()==null){
            root=null;
            return;
        }
        //if is leafNode
        if(targetNode.getLeft()==null&&targetNode.getRight()==null){
            AVLTreeNode father = searchFather(val);
            if(father.getLeft()==targetNode){
                father.setLeft(null);
            }else {
                father.setRight(null);
            }
            return;
        }
        //if node hava two childrenNode
        if(targetNode.getLeft() !=null&&targetNode.getRight()!=null){
            AVLTreeNode rightTree = targetNode.getRight();
            while (rightTree.getLeft()!=null){
                rightTree=rightTree.getLeft();
            }
            AVLTreeNode father = searchFather(rightTree.getId());
            father.setLeft(null);
            targetNode.setId(rightTree.getId());
        }
        //if node hava one childrenNode
        if(targetNode.getLeft() !=null^targetNode.getRight()!=null){
            AVLTreeNode father = searchFather(val);
            if(targetNode.getLeft()!=null){
                if(father.getLeft()==targetNode){
                    father.setLeft(targetNode.getLeft());
                }else {
                    father.setRight(targetNode.getLeft());
                }
            }else {
                if(father.getLeft()==targetNode){
                    father.setLeft(targetNode.getRight());
                }else {
                    father.setRight(targetNode.getRight());
                }
            }
        }
    }
    public void add(Node node){
        if(root==null){
            root= (AVLTreeNode) node;
        }else {
            root.add((AVLTreeNode) node);
        }
    }
    public void order(){
        this.root.infixOrder();
    }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        //int []arr=new int[]{4,3,6,5,7,8};
        int []arr=new int[]{10,11,7,6,8,9};
        for (int i : arr) {
            tree.add(new AVLTreeNode(i));
        }
        tree.order();
        System.out.println(tree.root.getHeight());
        System.out.println("左子树高度"+tree.root.getLeftHeight());
        System.out.println("右子树高度"+tree.root.getRightHeight());
    }
}
class AVLTreeNode extends Node{
    public void leftRotate(){
        AVLTreeNode newNode = new AVLTreeNode(this.getId());
        newNode.setLeft(this.getLeft());
        newNode.setRight(this.getRight().getLeft());
        this.setId(this.getRight().getId());
        this.setRight(this.getRight().getRight());
        this.setLeft(newNode);
    }
    public void rightRotate(){
        AVLTreeNode newNode = new AVLTreeNode(this.getId());
        newNode.setLeft(this.getLeft().getRight());
        newNode.setRight(this.getRight());
        this.setId(this.getLeft().getId());
        this.setLeft(this.getLeft().getLeft());
        this.setRight(newNode);

    }
    public AVLTreeNode(int id, Node left, Node right) {
        super(id, left, right);
    }

    public AVLTreeNode(int id) {
        super(id);
    }
    public void add(AVLTreeNode node){
        if(node==null){
            return;
        }
        if (node.getId()<this.getId()){
            if(this.getLeft()==null){
                this.setLeft(node);
            }else {
                this.getLeft().add(node);
            }
        }else{
            if (this.getRight()==null){
                this.setRight(node);
            }else {
                this.getRight().add(node);
            }
        }
        if(getRightHeight()-getLeftHeight()>1) {
            if(this.getRight()!=null&&this.getRight().getLeftHeight()>this.getRight().getRightHeight()){
                this.getRight().rightRotate();
            }
            leftRotate();
        }else if(getRightHeight()-getLeftHeight()<-1){
            if(this.getLeft()!=null&&this.getLeft().getLeftHeight()<this.getLeft().getRightHeight()){
                this.getLeft().leftRotate();
            }
            rightRotate();
        }
    }

    /**
     * 查找某一节点
     * @param id 查找的值
     * @return 对应节点
     */
    public AVLTreeNode searchNode(int id){
        if(id==this.getId()){
            return this;
        }
        if(id<this.getId()&&this.getLeft()!=null){
            return this.getLeft().searchNode(id);
        }else if(id>this.getId()&&this.getRight()!=null){
            return this.getRight().searchNode(id);
        }
        return null;
    }

    /**
     * 查找某一节点的父节点
     * @param id 查找的值
     * @return 对应父节点
     */
    public AVLTreeNode searchFatherNode(int id){
        if((this.getLeft()!=null && id == this.getLeft().getId())||(this.getRight()!=null && this.getRight().getId()==id)){
            return this;
        }
        if(id<this.getId()&&this.getLeft()!=null){
            return this.getLeft().searchFatherNode(id);
        }else if(id>this.getId()&&this.getRight()!=null){
            return this.getRight().searchFatherNode(id);
        }
        return null;
    }
    public int getHeight(Node node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(getHeight(node.getLeft()),getHeight(node.getRight()));
    }
    public int getHeight(){
        return getHeight(this);
    }
    public int getLeftHeight(){
        return this.getHeight(this.getLeft());
    }
    public int getRightHeight(){
        return this.getHeight(this.getRight());
    }

    @Override
    public AVLTreeNode getLeft() {
        return (AVLTreeNode) super.getLeft();
    }

    @Override
    public void setLeft(Node left) {
        super.setLeft(left);
    }

    @Override
    public AVLTreeNode getRight() {
        return (AVLTreeNode)super.getRight();
    }

    @Override
    public void setRight(Node right) {
        super.setRight(right);
    }
}
