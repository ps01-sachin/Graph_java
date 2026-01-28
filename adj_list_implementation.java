import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class adj_list_implementation {
    public static void main(String[] args) {
        System.out.println("enter no of vertex in graph");
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        
        Graph g = new Graph(V);
        int ch;
        do{
            System.out.println("1-> add edges \n2-> BFS traversal\n3-> DFS traversal\n0-> otherwise");
            System.out.print("enter your choice : ");
            ch =sc.nextInt();
            switch (ch) {
                case 1:
                   
                     System.out.println("enter edges format-- (start, end)");
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    g.addEdge(start,end); 

                    // when V = 5 ;
                    // g.addEdge(0,1);
                    // g.addEdge(0,2);
                    // g.addEdge(1,2);
                    // g.addEdge(1,3);
                    // g.addEdge(1,4);
                    // g.addEdge(2,3);
                    // g.addEdge(3,4);
                    break;
               
                case 2: 
                    System.out.println("enter start node  from 0 to "+ (V-1));
                    int st = sc.nextInt();
                    g.bfs_traversal(st);
                    break;
                case 3 : 
                    System.out.println("enter start node for DFS Traversal from 0 to "+(V-1));
                    int st1 = sc.nextInt();
                    g.dfs_traversal(st1);
                    break;
                case 0: 
                    System.out.println("Edges added successfully!");
                    break;
                default:
                    System.out.println("Invlaid choice ");
                    break;
            }
        }while (ch!=0);
    }
}
// class for Graph 
class Graph{
    int V; // V -> repesent no of nodes/ vertices in graph
    ArrayList<ArrayList<Integer>> adj;
    Graph(int V){
        this.V = V;
        adj = new ArrayList<>();
        // for every node empty list
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    // function for adding edges in graph
    void addEdge(int u ,int v){
        adj.get(u).add(v); // this add all adj of u 
        adj.get(v).add(u); // when graph is undirected
    }
    // function for BFS traversal 
    void bfs_traversal(int start ){
        boolean [] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>(); // here Queue --> interface , LinkedList --> class
        q.offer(start);  // enter first element into queue using offerfunction which insert element at the real 
        visited[start] = true; // set start vertex visited
        while (!q.isEmpty()) {
            int node= q.poll();// deque the vertex from queue
            System.out.print(node + "  ");
            // check for all adj node of polled out node 
            for(int nbr : adj.get(node)){
                if(!visited[nbr]){
                    visited[nbr]= true; // set that node visited
                    q.offer(nbr); // add that nbr node into que
                }
            }
           
        }
        System.out.println();
    }
    // function for DFS traversal 
        // recursive approach; becsue it implement using stack 
    void dfs_traversal(int source){
        boolean [] visited = new boolean[V];
        dfsUtil(source, visited);
    }
    void dfsUtil(int node , boolean[] visited ){
        visited[node]=true;
        System.out.print(node + "  ");
        for (int nbr : adj.get(node)){
            if(!visited[nbr]){
                // again apply dfs at nbr node 
                dfsUtil(nbr, visited);
            }
        }
        
    }
}