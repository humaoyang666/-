package 树;

import sun.security.util.AuthResources_it;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String s="i like like like java do you like a java";
        byte[] zipString = zipString(s);
        System.out.println(Arrays.toString(zipString));
        System.out.println(Integer.parseInt("01110",2));
        System.out.println(Integer.toBinaryString((byte)14));
    }
    public static byte[] zipString(String s){
        HuffmanCodeNode huffmanCodeNode = bulidHuffmanCodeNode(s);
        Map<Character, String> huffmanCodeMap = buildHuffmanCodeMap(huffmanCodeNode);
        String huffmanCode = bulidHuffmanCode(s, huffmanCodeMap);
        System.out.println(huffmanCode);
        System.out.println(huffmanCodeMap);
        byte[] zip = zip(huffmanCode);
        return zip;
    }
    public static byte[] zip(String huffmanCode){
        byte[] ans = new byte[(huffmanCode.length()+7)/8];

        for (int i = 0,idx=0; i < huffmanCode.length(); i+=8,idx++) {
            if(i+8<huffmanCode.length()){
                ans[idx]= (byte) Integer.parseInt(huffmanCode.substring(i,i+8),2);
            }else {
                ans[idx]= (byte) Integer.parseInt(huffmanCode.substring(i),2);
            }

        }
        return ans;
    }
    public static String bulidHuffmanCode(String s,Map<Character,String> huffmanCodeMap){
        StringBuffer stringBuffer=new StringBuffer();
        for (char c : s.toCharArray()) {
            stringBuffer.append(huffmanCodeMap.get(c));
        }
        return stringBuffer.toString();
    }
    public static Map<Character,String> buildHuffmanCodeMap(HuffmanCodeNode node){
        Map<Character,String> ans=new HashMap<>();
        if(node==null){
            return ans;
        }
        Stack<HuffmanCodeNode> stack=new Stack<>();
        StringBuffer str=new StringBuffer();
        buildHuffmanCodeMap(node,ans,str);
        return ans;
    }
    private static void buildHuffmanCodeMap(HuffmanCodeNode node,Map<Character,String> ans,StringBuffer str){
        if(node==null){
            return;
        }
        if(node.getC()!=0){
            ans.put(node.getC(),str.toString());
        }
        buildHuffmanCodeMap((HuffmanCodeNode) node.getLeft(),ans,str.append("0"));
        str.deleteCharAt(str.length()-1);
        buildHuffmanCodeMap((HuffmanCodeNode) node.getRight(),ans,str.append("1"));
        str.deleteCharAt(str.length()-1);
    }
    public static HuffmanCodeNode bulidHuffmanCodeNode(String s){
        Map<Character,Integer> map=new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Node> nodes = new PriorityQueue<>(Comparator.comparingInt(Node::getId));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            nodes.add(new HuffmanCodeNode(entry.getValue(),entry.getKey()));
        }
        while (nodes.size()>1){
            Node left = nodes.poll();
            Node right = nodes.poll();
            assert right != null;
            Node node = new HuffmanCodeNode(left.getId() + right.getId(), left, right);
            nodes.add(node);
        }
        return (HuffmanCodeNode) nodes.poll();
    }
    public static void preOrder(Node node){
        node.preOrder();
    }
}
class HuffmanCodeNode extends Node{
    private char c;
    public HuffmanCodeNode(int id, Node left, Node right) {
        super(id, left, right);
    }

    public HuffmanCodeNode(int id) {
        super(id);
    }

    public HuffmanCodeNode(int id, char c) {
        super(id);
        this.c = c;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "HuffmanCodeNode{" +
                "c=" + c +
                " "+"id="+super.getId()+'}';
    }
}
