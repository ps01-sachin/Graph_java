import java.util.*;

public class wt_graph_imple_by_adj_list {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of vertex in graph");
        int V = sc.nextInt();
        WeightedGraph wg = new WeightedGraph(V);
        int ch;
        int start ;
        int end ;
        int weight;
        do{
            System.out.println("1-> add Edges\n2-> BFS traversal\n3-> DFS traversal\n4-> Disjakstra \n0-> otherwise");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("enter edge formate (start , end , weight) ");
                    start = sc.nextInt();
                    end = sc.nextInt();
                    weight = sc.nextInt();
                    wg.addEdge(start, end, weight);
                    break;
                case 2:
                    System.out.println("enter start node  from 0 to "+ (V-1));
                    int st = sc.nextInt();
                    wg.bfs_traversal(st);
                    break;
                case 3:
                    System.out.println("enter start node  from 0 to "+ (V-1));
                    int st1 = sc.nextInt();
                    wg.dfs_traversal(st1);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("enter source vertex for dijkstra algo: ");
                    int source = sc.nextInt();
                    int []arr =wg.cost_dijkstra(source);
                    System.out.println("sortest dist/cost for each vertex are : ");
                    for(int i =0;i<V;i++){
                        if (arr[i] == Integer.MAX_VALUE) {
                            System.out.println("No path from " + source + " to " + i);
                        } else {
                            System.out.println("Shortest distance from " + source + " to " + i + " = " + arr[i]);
                        }              
                    }
                    break;
                
                case 5:
                    
                    break;
                

                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }while (ch!=0);
        
    }
    

}
class WeightedGraph{
    int V;
    ArrayList<ArrayList<Edge>> adj;
    WeightedGraph(int V){
        this.V = V;
        adj = new ArrayList<>();
         // for every node empty list
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
// function for add edges into graph
    void addEdge(int u, int v , int w){
        adj.get(u).add(new Edge(v,w));
        //adj.get(v).add(new Edge(u, w)); // for undiredt graph
    }

// function for BFS traversal
    void bfs_traversal(int start){
        boolean [] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node+"  ");
            
            for(Edge e : adj.get(node))// note that yha per node ka access edge class ke thourgh ho rha hai
            {
                if(!visited[e.to]){
                    visited[e.to]=true;
                    q.offer(e.to);
                }
            }
        }
        System.out.println();
    }
// function for DFS traversal 
    void dfs_traversal(int source){
        boolean [] visited = new boolean[V];
        dfsUtil(source,visited);
    }
    void dfsUtil(int node, boolean [] visited){
        visited[node]=true;
        System.out.print(node + "  ");
        for(Edge e : adj.get(node)){
            if(!visited[e.to]){
                dfsUtil(e.to, visited);
            }
        }
    }
// fucnction for Dijkstra Algorithms 
    int [] cost_dijkstra(int source){
        int [] dist = new int [V]; // matrix for store cost of each vertex
        Arrays.fill(dist, Integer.MAX_VALUE); // initially all vertex cost is maximum tends to infinite
        dist[source]=0; // initilize source cost equals to 0
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(a-> a.dist));
        // here priority queue implemented on tha bases of distance of pairs
        pq.add(new Pair(source,0));// adding source vertex into priority queue by creating its pair
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if(cur.dist>dist[cur.node]) // this is used to fast up the algorithms
            {
                continue; // skip outdated entry; 
                // cur.dist --> stored cast from soruce node to that node
                // dist[cur.node] --> updated distance which is stored into dist[] matrix 
            }

            for(Edge e : adj.get(cur.node)){
                if(cur.dist + e.weight < dist[e.to]){
                    dist[e.to]=cur.dist+e.weight;
                    pq.add(new Pair(e.to, dist[e.to]));
                }
            }
        }
        return dist;
    }
}
class Edge{
    int to ; // desination node
    int weight; // weight(cost)
    Edge (int to , int weight){
        this.to = to;
        this.weight = weight;
    }
}
class Pair{
    int node, dist; // here we crate pair of node and its distance from sorurce(current) node
    Pair(int node, int dist){
        this.node = node ;
        this.dist = dist;
    }
}
