import java.util.*;
public class Graph {
    static Map<Integer,LinkedList<Integer>> graph=new TreeMap<Integer,LinkedList<Integer>>();
    
    //ADD NODE TO THE GRAPH
    static void addNode(int n){
        graph.put(n,new LinkedList<Integer>());
    }

    //CONNECT NODES WITH EDGES
    static void addEdge(int u,int v){
        if(graph.containsKey(u))
            graph.get(u).add(v);
        if(graph.containsKey(v))
            graph.get(v).add(u);
    }

    //DEPTH FIRST SEARCH ALGORITHM
    static void DFS(int u,int parent){
        if(graph.get(u).size()<=1){
            System.out.println(u);
            return;
        }
        if(graph.containsKey(u)){
            for(int i=0;i<graph.get(u).size();i++){
                if(graph.get(u).get(i)==parent) continue;
                DFS(graph.get(u).get(i),u);
            }
        }
    }

    //DETECT IF CYCLE IS PRESENT IN THE GRAPH USING DFS
    static ArrayList<Integer> visited = new ArrayList<Integer>();
    static boolean detectCycle(int u,int parent){
        visited.add(u);
        if(graph.containsKey(u)){
            for(int i=0;i<graph.get(u).size();i++){
                if(graph.get(u).get(i)==parent) continue;
                if(visited.contains(graph.get(u).get(i)))
                return true;
                detectCycle(graph.get(u).get(i),u);
            }
        }
        System.out.println("I go from "+parent+" to "+u);
        return false;
    }

    public static void main(String[] args) {
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addEdge(1,2);
        addEdge(2,3);
        addEdge(1,4);
        addEdge(2,4);
        
        System.out.println(detectCycle(1, -1));
    }
}
