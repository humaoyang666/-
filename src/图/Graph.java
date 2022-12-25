package 图;

import java.util.*;

public class Graph {
    private List<String> vertexList;
    //邻接矩阵
    private int[][] edges;
    //边的数量
    private int edgeCount;
    //用于遍历
    private boolean []visited;
    public Graph(int n){
        vertexList=new ArrayList<>(n);
        edges=new int[n][n];
        visited=new boolean[n];
    }
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        edgeCount++;
    }
    public int getEdgeCount(){
        return edgeCount;
    }
    public int getVertexCount(){
        return vertexList.size();
    }
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    @Override
    public String toString() {
        return  Arrays.deepToString(edges);
    }
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if(edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    public int getFirstNeighbor(int index,int j){
        for (int i = j; i < vertexList.size(); i++) {
            if(edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    public void bfs(int index){
        Queue<Integer> queue=new LinkedList<>();
        if(!visited[index]){
            queue.offer(index);
            visited[index]=true;
        }
        while (!queue.isEmpty()){
            int i = queue.poll();
            System.out.println(getValueByIndex(i));
            for (int j = 0; j < vertexList.size(); j++) {
                if(edges[i][j]>0&& !visited[j]){
                    queue.offer(j);
                    visited[j]=true;
                }
            }
        }
    }
    public void dfs(int index){

        Stack<Integer> stack=new Stack<>();
        stack.push(index);
        System.out.println(getValueByIndex(index));
        while (!stack.isEmpty()){
            int i = stack.peek();

            visited[i]=true;
            boolean haveNext=false;
            for (int j = 0; j < vertexList.size(); j++) {
                int neighbor = getFirstNeighbor(i, j);
                if(neighbor!=-1&& !visited[neighbor]){
                    stack.push(neighbor);
                    System.out.println(getValueByIndex(neighbor));
                    haveNext=true;
                    break;
                }
            }
            if(!haveNext){
                stack.pop();
            }
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String []vertexValue = new String[]{"a","b","c","d","e"};
        for (String s : vertexValue) {
            graph.insertVertex(s);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        System.out.println(graph);
        graph.dfs(0);
        System.out.println("===================");
        graph.bfs(0);
    }
}
