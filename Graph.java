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

    // PRINT THE ADJACENCY LIST OF THE GRAPH
    static void printAdjacencyList(){
        for (Integer integer : graph.keySet()) {
            System.out.print(integer+" connected to"+" : ");
            for (Integer i : graph.get(integer)) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
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

    // TOPOLOGICAL SORTING FROM A GIVEN NODE
    static void topologicalSort(int node,Stack<Integer> s,boolean[] visited){
        
        visited[node] = true;
        for(int i=0; i<graph.get(node).size();i++){
            if(!visited[graph.get(node).get(i)]){
                topologicalSort(graph.get(node).get(i),s,visited);
            }
        }
        s.push(node);
    }

    //DIJIKSTRA's ALGORITHM TO FIND SHORTEST PATH IN GRAPH
    static void dijikstraAlgorithm(boolean[] visited,int[] dist, int src){
        dist[src] = 0;
        for(int i=0;i<graph.size();i++){
            int min=Integer.MAX_VALUE,minindex=-1;
            for(int j=0;j<graph.size();j++){
                if(min>=dist[j]&&!visited[j]){
                    minindex = j;
                    min = dist[j];
                }
            }
            visited[minindex] = true;
            for (int j = 0; j < graph.get(minindex).size(); j++) {
                if(!visited[graph.get(minindex).get(j)] && dist[minindex]!=Integer.MAX_VALUE && dist[minindex]+1<dist[graph.get(minindex).get(j)])
                    dist[graph.get(minindex).get(j)] = dist[minindex]+1;
            }
        }
        for (int i=0;i<dist.length; i++) {
            System.out.println("Distance from "+src+" to node "+i+" is : "+dist[i]);
        }
    }

    public static void main(String[] args) {
        addNode(0);
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(5);
        addEdge(0,4);
        addEdge(0,5);
        addEdge(1,4);
        addEdge(1,3);
        addEdge(2,3);
        addEdge(2,5);
        
        // Printing adjacency list of the graph
        printAdjacencyList();


        Stack<Integer> s = new Stack<Integer>();
        boolean visited[]=new boolean[graph.size()];
        for (int i = 0;i<graph.size();i++)
        if(!visited[i]) topologicalSort(i,s,visited);

        // Printing the topological sort result  -  0 4 1 3 2 5
        System.out.print("Topological Sort of the graph is : ");
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println();

        // Reload the visited array with false
        for(int i=0;i<visited.length;i++) visited[i]=false;

        // Distance array to measure shortest distance from source to every node
        int[] dist = new int[graph.size()];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // Calling Dijikstra's algo function
        dijikstraAlgorithm(visited, dist, 0);

        // Cycle detection
        System.out.println("Is the graph containing any cycle : "+detectCycle(1, -1));
    }
}
