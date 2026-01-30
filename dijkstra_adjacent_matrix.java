import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class dijkstra_adjacent_matrix {
    public static void main(String args[]){
        Scanner sc  = new Scanner (System.in);
        System.out.println("enter no of node in graph : ");
        int V = sc.nextInt();
        WeightedGraph wg = new WeightedGraph(V);
        int choice ;
        do{
            System.out.println("=== Weighted Graph Menu ===");
            System.out.println("1-> print matrix\n2-> add edges\n3-> BFS traversal");
            System.out.println("4-> DFS traversal\n5-> sortest path(dijkstra)\n6-> Floyd-Warshall\n-1-> exit");
            System.out.println("enter your choice : ");
            choice = sc.nextInt();
            int source;
            switch (choice) {
                case 1:
                    wg.printMatrix();
                    break;
                case 2:
                    System.out.println("enter edges formate(start , end , weight) : ");
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    int w = sc.nextInt();
                    wg.addEdge(u, v, w);
                    break;
                case 3:
                    System.out.println("enter a source node for BFS traversal : ");
                    source = sc.nextInt();
                    System.out.println("BFS Traversal of Graph : ");
                    wg.bfs_traversal(source);
                    break;
                case 4:
                    System.out.println("enter a source node for DFS traversal : ");
                    source = sc.nextInt();
                    System.out.println("DFS Traversal of Graph : ");
                    wg.dfs_traversal(source);
                    break;
                case 5:
                    System.out.println("enter a source node for Dijkstra algo : ");
                    source = sc.nextInt();
                    wg.dijkstra(source);
                    break;
                case 6:
                    wg.floydWarshall();
                    break;
                case 7:
                    System.out.println("enter a source node for Prims MST algo : ");
                    source = sc.nextInt();
                    wg.primsMST(source);
                    break;
                case -1:
                    System.out.println("Exiting the program ! ");
                    break;
                default:
                    break;
            }
        }while(choice!=-1);

        sc.close();
    }
    
}


class WeightedGraph{
    int V;
    int [][] adj;
    static final int INF = (int )1e9; 
    WeightedGraph(int V){
        this.V=V;
        adj = new int[V][V];
        for(int i =0;i<V;i++){
            Arrays.fill(adj[i],INF); // here using Integer.MAX_VALUE is dengerours ( spacialy in dijkstra alago --> during relaxation it exceed integer limit) 
            adj[i][i]=0; // very imp condition for dijkstra algorithms ;
        }
    }
    // fucnction for adding edges 
        void addEdge(int u, int v, int w){
            adj[u][v] = w;
            adj[v][u] = w; // for un directed graph
        }
    // function for Bfs traversal 
        void bfs_traversal(int source){
            boolean[] visited = new boolean[V];
            Queue<Integer> q = new LinkedList<>();
            q.add(source);
            visited[source]=true;
            while (!q.isEmpty()) {
                int node = q.poll();
                System.out.print(node + "  ");
                // checking all neighbours 
                for (int nbr=0 ;nbr<V;nbr++){
                    // note that when we set adj[i][i]=0 in constructor then it will not effect the bfs or dfs traversal --> slef!= INF conditon fail ho jayega aise case me but second condition !visited[nbr] true rahega but koi problem nhi hoga
                    if(adj[node][nbr]!= INF && !visited[nbr]){
                        q.add(nbr);
                        visited[nbr]=true;
                    }
                }
            }
        }
    // function for DFS traversal 
        void dfs_traversal(int source){
            boolean [] visited = new boolean[V];
            dfsUtil(source, visited);
        }
        void dfsUtil(int node, boolean []visited){
            visited[node] =true;
            System.out.print(node +"  ");
            // checking all posible neighbours 
            for (int nbr =0;nbr< V ;nbr++){
                // note that when we set adj[i][i]=0 in constructor then it will not effect the bfs or dfs traversal --> slef!= INF conditon fail ho jayega aise case me but second condition !visited[nbr] true rahega but koi problem nhi hoga
                if(adj[node][nbr]!= INF && !visited[nbr]){
                    dfsUtil(nbr, visited);
                }
            }
        }
    // function for printing matrix 
        void printMatrix(){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(adj[i][j]==INF){
                        System.out.print("∞   ");
                    }
                    else{
                        System.out.print(adj[i][j]+"   ");
                    }
                }
                System.out.println();
            }
        }
    // fucnction for dijkstra algo 
        void dijkstra(int source){
            int [] dist = new int[V];
            boolean [] visited = new boolean[V];
            // fill all node distacne infinite initally 
            Arrays.fill(dist,INF);
            // now set source distance is 0 
            dist[source] = 0;

            for(int count =0;count<V-1;count++){
                // pick minimum distacne node from unvisited node 
                int u =-1; // u point minimum dist node 
                int min = INF; // min point min distance
                for(int i =0;i<V;i++){
                    if(!visited[i] && dist[i]<min){
                        min = dist[i];
                        u=i;
                    }
                }
                if(u==-1){
                    break ; // mean ab koi node nhi mila sabhi add ho gye hai
                }
                visited[u] = true ;// set that node is visited 
                // now relax all the neighbour of u 
                for(int v =0;v<V;v++){
                    /*
                    here we are going to check three condition 
                        1. !visited[nbr/v] --> condition for not visited 
                        2. adj[u][v] != INF ---> exitace of edge b/w u and v
                        3. dist[u] + adj[u][v] < dist[v] --> relaxation condition 
                    */
                    if(!visited[v] && adj[u][v] != INF && dist[u] + adj[u][v] < dist[v]){
                        dist[v] = dist[u] + adj[u][v];
                    }
                }
            }
            // now printing all node shortest distance form source node 
            System.out.println("shortest distance from srouce "+source);
            for(int i =0;i<V;i++){
                if (dist[i] == INF)
                    System.out.println(source +" -> " + i + " = unreachable");
                else
                    System.out.println(source+ " -> " + i + " = " + dist[i]);
            }
        }

    // function for shortest path for all pair of node (Floyd Warshall Algo)
        void floydWarshall(){
            // firstly copy the adj matrix into new dist martix 
            int [][] dist = new int[V][V];
            for(int i =0;i<V;i++){
                for(int j =0;j<V;j++){
                    dist[i][j]=adj[i][j];
                }
            }
            //
            //  Floyd–Warshall
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        // this conditon is used to avoid some unwanted calculation 
                        if (dist[i][k] < INF && dist[k][j] < INF) // this is check becz if any one is INF then min vlaue is also INF and dist[i][j] will unchanged
                        {
                            dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
            // printing the matrix of min cost
            System.out.print("node");
            for(int i =0;i<V;i++){
                System.out.print(i+"  ");
            }
            System.out.println();
            for(int i =0;i<V;i++){
                System.out.print(i+"  ");
                for(int j=0;j<V;j++){
                    if(dist[i][j]!=INF)
                    System.out.print(dist[i][j]+"  ");
                    else
                    System.out.print("∞  ");
                }
                System.out.println();
            }
        }
    // function for prims algo implementation ;
    void primsMST(int start){
        int key[] = new int[V]; // store the cost / or dist
        int parent[] = new int[V]; // sotre the parent node detail
        boolean [] visited = new boolean[V];  // used for visiting status
       /*
        Initilize ---> 
        key ---> infinite;
        parents ---> null;  or 0;
        visited ---> false;
        */
        for(int i =0;i<V ;i++){
            key[i]= INF;
            // parent[i]= 0; // which is alrady assinged;
            // visited[i] = false; // this is also assinged before;
        }
        key[start] =0; // set start vertex key vlaue 0 
        parent[start]=-1; // start vertex parent is -1 ;
        // here we are not using PriorityQueue for finding minimum cost(key) vertex which is not added into mst (not visited)
        for(int count =0 ;count<V-1;count++){
            // pick minimum key vertex which is not visited or not added into mst;
            int u=-1;
            int min = INF;
            for(int i =0;i<V;i++){
                if(!visited[i] && key[i]<min){
                    min = key[i];
                    u =i;
                }
               

            }
            if(u==-1) // detection for disconnected graph
            {
                break; // no more rachable node availabe to add into mst
            }
            // is point per aakar hi node add ho rha hai MST me 
            visited[u]=true; // include u node into mst (first time it will start node --> becz start node ki key value hi minimum hogi)  
            // now updateds key value of neighbours of u
            for(int v =0;v<V;v++){
                /*
                1. !visited[v/nbr] --> condition for not added into mst
                2. adj[u][v] < key[v] --> condtion for jab u node se v node ki distance phle vali key value se kam ho

                    */
                if(!visited[v]&& adj[u][v]<key[v]){
                    key[v]=adj[u][v];
                    parent[v] = u;
                }
            }

        }
        // print MST
        System.out.println("Edge   Weight");
        int totalCost = 0;

        // starting from 1 becz 0 is starting node and uska parent -1 hai and uska cost/ dist 0 hai nad to avoid array index out of bound exception 
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " --- " + i + "    " + adj[i][parent[i]]);
            totalCost += adj[i][parent[i]];
        }

        System.out.println("Total MST cost = " + totalCost);
    }
}

/*

🔥 Dijkstra (Matrix) vs Floyd–Warshall (Matrix)
    |---------------------------|---------------------------------------|---------------------------------------------------------|
    | Feature                   | **Dijkstra (Adjacency Matrix)**       | **Floyd–Warshall**                                      |
    | ------------------------- | ------------------------------------- | ------------------------------------------------------- |
    | **Graph form**            | Adjacency **Matrix**                  | Adjacency **Matrix**                                    |
    | **Shortest path type**    | Single-source → all nodes             | All-pairs shortest path                                 |
    | **Time Complexity**       | `O(V²)`                               | `O(V³)`                                                 |
    | **Space Complexity**      | `O(V)` extra (`dist[]`, `visited[]`)  | `O(V²)`                                                 |
    | **Negative edges**        | ❌ Not allowed                        | ✔ Allowed                                               |
    | **Negative cycle detect** | ❌                                    | ✔ (`dist[i][i] < 0`)                                    |
    | **Main loops (code)**     | 2 nested loops                        | 3 nested loops                                          |
    | **Core update line**      | `dist[v] = min(dist[v], dist[u] + w)` | `dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])` |
    | **INF usage**             | dist[] initialized with INF           | dist[][] initialized with INF                           |
    | **Overflow risk**         | Medium                                | High (needs INF check)                                  |
    | **When to use**           | One source, dense graph               | All pairs, small graph                                  |
    | **Example use case**      | Single city → all cities              | Character conversion                                    |
    |---------------------------|---------------------------------------|---------------------------------------------------------|

🔥 Graph Algorithms (Adjacency Matrix) – WITH Neighbour Condition
    |----------------------------------------|---------------------------------|---------------------------------|----------------------------------|---------------------------------- -----|
    | Algorithm                              | BFS                             | DFS                             | Dijkstra (Matrix)                | Floyd–Warshall                         |
    | -------------------------------------- | ------------------------------- | ------------------------------- | -------------------------------- | -------------------------------------- |
    | **Graph rep.**                         | Adj Matrix                      | Adj Matrix                      | Adj Matrix                       | Adj Matrix                             |
    | **Type**                               | Traversal                       | Traversal                       | Shortest Path                    | Shortest Path                          |
    | **Source**                             | Single                          | Single                          | Single                           | All pairs                              |
    | **Shortest path**                      | ✔ (unweighted)                  | ❌                             | ✔ (weighted)                     | ✔ (weighted)                          |
    | **Negative weight**                    | ❌                              | ❌                             | ❌                               | ✔                                     |
    | **Time**                               | `O(V²)`                         | `O(V²)`                         | `O(V²)`                          | `O(V³)`                                |
    | **Space (extra)**                      | `O(V)`                          | `O(V)`                          | `O(V)`                           | `O(V²)`                                |
    | **INF needed**                         | ❌                              | ❌                             | ✔                                | ✔                                     |
    | **Self dist**                          | 0                               | 0                               | 0                                | 0                                      |
    | **Core DS**                            | Queue                           | Stack / Recursion               | dist[], visited[]                | dist[][]                               |
    | **Neighbour meaning**                  | Edge exists?                    | Edge exists?                    | Edge exists + relax              | i→k & k→j exist                        |
    | **Neighbour condition (🔥 important)** | `adj[u][v] == 1 && !visited[v]` | `adj[u][v] == 1 && !visited[v]` | `adj[u][v] < INF && !visited[v]` | `dist[i][k] < INF && dist[k][j] < INF` |
    |----------------------------------------|---------------------------------|---------------------------------|----------------------------------|---------------------------------- -----|


    */
