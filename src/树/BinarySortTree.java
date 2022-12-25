package 树;

public class BinarySortTree {
    private BinarySortTreeNode root;

    public BinarySortTree(BinarySortTreeNode root) {
        this.root = root;
    }

    public BinarySortTree() {
        super();
    }
    public BinarySortTreeNode search(int val){
        return  root==null? null:root.searchNode(val);
    }
    public BinarySortTreeNode searchFather(int val){
        return  root==null? null:root.searchFatherNode(val);
    }
    public void deleteNode(int val){
        if(root==null){
            return;
        }
        BinarySortTreeNode targetNode = search(val);
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
            BinarySortTreeNode father = searchFather(val);
            if(father.getLeft()==targetNode){
                father.setLeft(null);
            }else {
                father.setRight(null);
            }
            return;
        }
        //if node hava two childrenNode
        if(targetNode.getLeft() !=null&&targetNode.getRight()!=null){
            BinarySortTreeNode rightTree = targetNode.getRight();
            while (rightTree.getLeft()!=null){
               rightTree=rightTree.getLeft();
            }
            BinarySortTreeNode father = searchFather(rightTree.getId());
            father.setLeft(null);
            targetNode.setId(rightTree.getId());
        }
        //if node hava one childrenNode
        if(targetNode.getLeft() !=null^targetNode.getRight()!=null){
            BinarySortTreeNode father = searchFather(val);
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
    public void add(BinarySortTreeNode node){
        if(root==null){
            root=node;
        }else {
            root.add(node);
        }
    }
    public void order(){
        this.root.infixOrder();
    }
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        int [] arr=new int[]{7,3,10,12,5,1,9,2};
        for (int j : arr) {
            binarySortTree.add(new BinarySortTreeNode(j));
        }
        binarySortTree.order();
        System.out.println("=============================");
        binarySortTree.deleteNode(7);
       // binarySortTree.deleteNode(9);
        binarySortTree.order();
    }
}
class BinarySortTreeNode extends Node{

    public BinarySortTreeNode(int id, Node left, Node right) {
        super(id, left, right);
    }
    public BinarySortTreeNode(int id) {
        super(id);
    }
    public void add(BinarySortTreeNode node){
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
    }

    /**
     * 查找某一节点
     * @param id 查找的值
     * @return 对应节点
     */
    public BinarySortTreeNode searchNode(int id){
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
    public BinarySortTreeNode searchFatherNode(int id){
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
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public BinarySortTreeNode getLeft() {
        return (BinarySortTreeNode)super.getLeft();
    }

    @Override
    public void setLeft(Node left) {
        super.setLeft(left);
    }

    @Override
    public BinarySortTreeNode getRight() {
        return (BinarySortTreeNode) super.getRight();
    }

    @Override
    public void setRight(Node right) {
        super.setRight(right);
    }

    @Override
    public void infixOrder() {
        super.infixOrder();
    }
}