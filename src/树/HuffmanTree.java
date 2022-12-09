package 树;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanTree {



    public static void main(String[] args) {
        int []arr=new int[]{13,7,8,3,29,6,1};
        Node node = buildHuffmanTree(arr);
        System.out.println(node);
    }
    private static Node buildHuffmanTree(int []arr){
        PriorityQueue<Node> nodes = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getId() - o2.getId();
            }
        });
        for (int i : arr) {
            nodes.add(new Node(i));
        }
        while (nodes.size()>1){
            Node left = nodes.poll();
            Node right = nodes.poll();
            assert right != null;
            Node node = new Node(left.getId() + right.getId(), left, right);
            nodes.add(node);
        }
        return nodes.poll();
    }
}
