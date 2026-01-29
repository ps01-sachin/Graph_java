import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class adjency_matrix_representation {
    public static void main(String[] args) {
        int V ;
        System.out.println("enter no of nodes : ");
        Scanner sc = new Scanner (System.in);
        V = sc.nextInt();
        int choice ;
        int selectGraph;
        int source ;
        GraphMatrix g = new GraphMatrix(V);
        WeightedGraphMatrix wg = new WeightedGraphMatrix(V);
        DirectGraphMatrix dg = new DirectGraphMatrix(V);
        DirectedWeightedGraphMatrix dwg = new DirectedWeightedGraphMatrix(V);
        do{
            System.out.println("=== Select Graph ===");
            System.out.println("1-> undirect simple Graph\n2-> Undirected weighted Graph\n3->  Directed simple Graph\n4-> Directed Weighted Graph");
            System.out.println("-1-> exit form menu");
            System.out.println("enter your choice : ");
            selectGraph = sc.nextInt();
            switch (selectGraph) {
                case 1:
                    do{
                        
                        System.out.println("=== Undirected SimpleGraph Menu ===");
                       System.out.println("1 -> display Matrix \n2 -> add edges \n3 -> BFS Traversal\n4 -> DFS traversal");
                        System.out.println("-1 -> Exit");
                        System.out.println("enter you choice : ");
                        choice = sc.nextInt();
                        int u;
                        int v;
                        switch (choice) {
                            case 1:
                                System.out.println("Adjency Matrix of graph is : ");
                                System.out.println("------------------------");
                                g.printMatrix();
                                System.out.println("------------------------");
                                break;
                            case 2:
                                System.out.println("enter edges formate (start---end) : ");
                                u = sc.nextInt();
                                v = sc.nextInt();
                                g.addEdge(u, v);
                                break;
                            case 3 :
                                System.out.println("enter source node for BFS traversal form 0 to "+(V-1));
                                source = sc.nextInt();
                                System.out.println("BFS traversal is : ");
                                g.bfs_traversal(source);
                                break;
                            case 4 :
                                System.out.println("enter source node for DFS Traversal form 0 to "+(V-1));
                                source = sc.nextInt();
                                System.out.println("DFS traversal is : ");
                                g.dfs_traversal(source);
                                break;
                            case -1:
                                System.out.println("exiting the menue !");
                                break;
                            default:
                                System.out.println("Invalid choice !");
                                break;
                        }
                    }while(choice!=-1);
                    break;
                case 2:
                    do{
                       
                        System.out.println("=== Undirected Weighted Graph Menu ===");
                        System.out.println("1 -> display Matrix \n2 -> add edges \n3 -> BFS Traversal\n4 -> DFS traversal");
                        System.out.println("-1 -> Exit");
                        System.out.println("enter you choice : ");
                        choice = sc.nextInt();
                        int u;
                        int v;
                        int w;
                        switch (choice) {
                            case 1:
                                System.out.println("Adjency Matrix of Weighted graph is : ");
                                System.out.println("------------------------");
                                wg.printMatrix();
                                System.out.println("------------------------");
                                break;
                            case 2:
                                System.out.println("enter edges formate (start, end , weight) : ");
                                u = sc.nextInt();
                                v = sc.nextInt();
                                w = sc.nextInt();
                                wg.addEdge(u, v, w);
                                break;
                            case 3 :
                                System.out.println("enter source node for BFS traversal form 0 to "+(V-1));
                                source = sc.nextInt();
                                System.out.println("BFS traversal is : ");
                                wg.bfs_traversal(source);
                                break;
                            case 4 :
                                System.out.println("enter source node for DFS Traversal form 0 to "+(V-1));
                                source = sc.nextInt();
                                System.out.println("DFS traversal is : ");
                                wg.dfs_traversal(source);
                                break;
                            case -1:
                                System.out.println("exiting the menue !");
                                break;
                            default:
                                System.out.println("Invalid choice !");
                                break;
                        }
                    }while(choice!=-1);
                    break;
                    
                case 3:
                    do{
                        
                        System.out.println("=== Directed Simple Graph Menu ===");
                        System.out.println("1 -> display Matrix \n2 -> add edges \n3 -> BFS Traversal\n4 -> DFS traversal");
                        System.out.println("-1 -> Exit");
                        System.out.println("enter you choice : ");
                        choice = sc.nextInt();
                        int u;
                        int v;
                        switch (choice) {
                            case 1:
                                System.out.println("Adjency Matrix of graph is : ");
                                System.out.println("------------------------");
                                dg.printMatrix();
                                System.out.println("------------------------");
                                break;
                            case 2:
                                System.out.println("enter edges formate (source--->destination) : ");
                                u = sc.nextInt();
                                v = sc.nextInt();
                                dg.addEdge(u, v);
                                break;
                            case 3 :
                                System.out.println("enter source node for BFS traversal form 0 to "+(V-1));
                                source = sc.nextInt();
                                System.out.println("BFS traversal is : ");
                                dg.bfs_traversal(source);
                                break;
                            case 4 :
                                System.out.println("enter source node for DFS Traversal form 0 to "+(V-1));
                                source = sc.nextInt();
                                System.out.println("DFS traversal is : ");
                                dg.dfs_traversal(source);
                                break;
                            case -1:
                                System.out.println("exiting the menue !");
                                break;
                            default:
                                System.out.println("Invalid choice !");
                                break;
                        }
                    }while(choice!=-1);
                    break;
                case 4:
                    do{
                        
                        System.out.println("=== Directed Weighted Graph Menu ===");
                        System.out.println("1 -> display Matrix \n2 -> add edges \n3 -> BFS Traversal\n4 -> DFS traversal");
                        System.out.println("-1 -> Exit");
                        System.out.println("enter you choice : ");
                        choice = sc.nextInt();
                        int u;
                        int v;
                        int w;
                        switch (choice) {
                            case 1:
                                System.out.println("Adjency Matrix of Weighted graph is : ");
                                System.out.println("------------------------");
                                dwg.printMatrix();
                                System.out.println("------------------------");
                                break;
                            case 2:
                                System.out.println("enter edges formate (source, destination , weight) : ");
                                u = sc.nextInt();
                                v = sc.nextInt();
                                w = sc.nextInt();
                                dwg.addEdge(u, v, w);
                                break;
                            case 3 :
                                System.out.println("enter source node for BFS traversal form 0 to "+(V-1));
                                source = sc.nextInt();
                                System.out.println("BFS traversal is : ");
                                dwg.bfs_traversal(source);
                                break;
                            case 4 :
                                System.out.println("enter source node for DFS Traversal form 0 to "+(V-1));
                                source = sc.nextInt();
                                System.out.println("DFS traversal is : ");
                                dwg.dfs_traversal(source);
                                break;
                            case -1:
                                System.out.println("exiting the menue !");
                                break;
                            default:
                                System.out.println("Invalid choice !");
                                break;
                        }
                    }while(choice!=-1);
                    break;
                case -1:
                    System.out.println("exiting the menu!");
                    break;
                default:
                    System.out.println("Invalid choice !");
                    break;
            }
        }while (selectGraph!=-1);
            
        
        
    }
}
// class for graph representation using adjancy matrix
class GraphMatrix{
    int V ; // V -> no of vertices 
    int [][] adj;
    GraphMatrix(int V){
        this.V = V;
        adj = new int[V][V]; // hear each cell contain 0 
    }
    // function for adding Edges between node u and v
    void addEdge(int u, int v) {
        adj[u][v] =1 ; 
        adj[v][u] =1 ; // for undirected graph 
    }

    // fucntion for printing the matrix 
    void printMatrix(){
        for(int i =0;i<V;i++){
            for(int j =0;j<V ;j++){
                System.out.print(adj[i][j]+"   ");
            }
            System.out.println();
        }
    }

    // function for bfs traversal
    void bfs_traversal(int source){
        boolean [] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.println(node +"  ");
            // cheack all posible neighbours 
            for(int nbr =0 ;nbr <V;nbr++){
                /*
                adj[node][nbr]==1  --> condition for existing of edge ;
                    Or adj[node][nbr]!=0 
                !visited[nbr] --> condition for not visited node ; 
                 
                 */
                if(adj[node][nbr] ==1 && !visited[nbr]){
                    q.add(nbr);
                    visited[nbr]=true;
                }
            }
        }
    }
    // function for DFS traversal 
    void dfs_traversal(int source){
        boolean [] visited =new boolean[V];
        dfsUtil(source , visited);
    }
    void dfsUtil(int node, boolean [] visited){
        visited[node]= true;
        System.out.println(node+"  ");
        //check all neighbours of node 
        for(int nbr=0;nbr<V;nbr++){
            /*
            adj[node][nbr]==1 ---> condition for existing of edge
            !visited[nbr] ---> condition for not visited 
             */
            if(adj[node][nbr]==1 && !visited[nbr]){
                dfsUtil(nbr,visited);
            }
        }
    }
}
// class for Weighted Graph representation using adjency matrix
class WeightedGraphMatrix{
    int V;
    int [][] adj;
    WeightedGraphMatrix(int V){
        this.V = V;
        adj = new int[V][V];
        // In weighted graph which node is not conected wiht any one that wight is infinite 
        // and self ka self ke sathe weight 0 hoga;
        for(int i =0;i<V;i++){
            Arrays.fill(adj[i], Integer.MAX_VALUE);
            adj[i][i]=0; // for dijkstra and floyed warshall algorithms
        }
    }
    // fucntion for adding edges b/w u and v containg weight w
    void addEdge(int u ,int v,int w){
        adj[u][v]= w;
        adj[v][u]=w; // for undirected graph
    }
    // fucntion for printing the matrix 
    void printMatrix(){
        for(int i =0;i<V;i++){
            for(int j =0;j<V ;j++){
                 if (adj[i][j] == Integer.MAX_VALUE)
                    System.out.print("∞   ");
                else
                    System.out.print(adj[i][j] + "  ");
            }
            System.out.println();
        }
    }
    // function for Bfs traversal
    void bfs_traversal(int source){
        boolean [] visited  = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source]=true;
        while (!q.isEmpty()) {
            int node  = q.poll();
            System.out.println(node+"  ");
            //checking for neighbours 
            for(int nbr =0;nbr<V;nbr++){
                /*
                adj[node][nbr] != Integer.MAX_VALUE ---> condition for existance of edge
                !visited[nbr] ---> condition for not visited ;
                 
                 */
                if(adj[node][nbr]!=Integer.MAX_VALUE && !visited[nbr]){
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
    void dfsUtil(int node, boolean[]visited){
        visited[node]=true;
        System.out.println(node + "  ");
        // checking all neighboures 
        for (int nbr =0;nbr <V ;nbr++){
            /*
            adj[node][nbr] != Integer.MAX_VALUE ----> condition for edges exitistance
            !visited[nbr] ---> conditon for not visited  
             */
            if(adj[node][nbr]!=Integer.MAX_VALUE && !visited[nbr]){
                dfsUtil(nbr, visited);

            }
        }
    }
}
// class for directed simple(un weighted) graph matrix ;
class DirectGraphMatrix {
    int V ;
    int [][] adj ;
    DirectGraphMatrix(int V){
        this.V = V;
        adj = new int[V][V];
    }
     // function for adding Edges between node u and v
    void addEdge(int source, int dest) {
        adj[source][dest] =1 ; 
    }

    // fucntion for printing the matrix 
    void printMatrix(){
        for(int i =0;i<V;i++){
            for(int j =0;j<V ;j++){
                System.out.print(adj[i][j]+"   ");
            }
            System.out.println();
        }
    }
    // function for BFS Traversal ;
    void bfs_traversal(int source){
        boolean [] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source]=true;
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node+"  ");
            // checking for all neighbours 
            for(int nbr =0;nbr<V;nbr++){
                /*
                adj[node][nbr] ==1 ---> condition for existance of edge
                !visited[nbr] ---> condition for not visited
                 */
                if(adj[node][nbr] == 1 && !visited[nbr]){
                    q.add(nbr);
                    visited[nbr]=true;
                }
            }
        }

    }
    // function for DFS traversal 
    // same as undirected graph 
     void dfs_traversal(int source){
        boolean [] visited =new boolean[V];
        dfsUtil(source , visited);
    }
    void dfsUtil(int node, boolean [] visited){
        visited[node]= true;
        System.out.println(node+"  ");
        //check all neighbours of node 
        for(int nbr=0;nbr<V;nbr++){
            /*
            adj[node][nbr]==1 ---> condition for existing of edge
            !visited[nbr] ---> condition for not visited 
             */
            if(adj[node][nbr]==1 && !visited[nbr]){
                dfsUtil(nbr,visited);
            }
        }
    }

}
// class for Weighted Directed Graph representation using adjency matrix
class DirectedWeightedGraphMatrix{
    int V;
    int [][] adj;
    DirectedWeightedGraphMatrix(int V){
        this.V = V;
        adj = new int[V][V];
        // In weighted graph which node is not conected wiht any one that wight is infinite 
        // and self ka self ke sathe weight 0 hoga;
        for(int i =0;i<V;i++){
            Arrays.fill(adj[i], Integer.MAX_VALUE);
            adj[i][i]=0; // for dijkstra and floyed warshall algorithms
        }
    }
    // fucntion for adding edges b/w u and v containg weight w
    void addEdge(int source ,int dest,int weight){
        adj[source][dest]= weight;
    }
    // fucntion for printing the matrix 
    void printMatrix(){
        for(int i =0;i<V;i++){
            for(int j =0;j<V ;j++){
                if (adj[i][j] == Integer.MAX_VALUE)
                    System.out.print("∞   ");
                else
                    System.out.print(adj[i][j] + "   ");
            }
            System.out.println();
        }
    }
    // function for BFS Traversal;
    void bfs_traversal(int source){
        boolean [] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source]=true;
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + "  ");
            // check all posible neighbours 
            for (int nbr =0 ;nbr<V;nbr++){
                if(adj[node][nbr]!=Integer.MAX_VALUE && !visited[nbr]) // here we chekc two condition 1-> edge exit ,2 -> not visited
                {
                    visited[nbr]=true;
                    q.add(nbr);
                }
            }
        }
    }
    // function for DFS traversal 
    // same as undirected Weighted graph
     void dfs_traversal(int source){
        boolean [] visited = new boolean[V];
        dfsUtil(source, visited);
    }
    void dfsUtil(int node, boolean[]visited){
        visited[node]=true;
        System.out.println(node + "  ");
        // checking all neighboures 
        for (int nbr =0;nbr <V ;nbr++){
            /*
            adj[node][nbr] != Integer.MAX_VALUE ----> condition for edges exitistance
            !visited[nbr] ---> conditon for not visited  
             */
            if(adj[node][nbr]!=Integer.MAX_VALUE && !visited[nbr]){
                dfsUtil(nbr, visited);

            }
        }
    }
}


/*



BFS / DFS — Time & Space Complexity
        (Adjacency Matrix Representation)
        ✅ MAIN TABLE (IMPORTANT)

        |-----------------------|-----------|-----------------|------------------|
        | Graph Type            | Traversal | Time Complexity | Space Complexity |
        | --------------------- | --------- | --------------- | ---------------- |
        | Undirected Unweighted | BFS       | O(V²)           | O(V)             |
        | Undirected Unweighted | DFS       | O(V²)           | O(V)             |
        | Directed Unweighted   | BFS       | O(V²)           | O(V)             |
        | Directed Unweighted   | DFS       | O(V²)           | O(V)             |
        | Undirected Weighted   | BFS       | O(V²)           | O(V)             |
        | Undirected Weighted   | DFS       | O(V²)           | O(V)             |
        | Directed Weighted     | BFS       | O(V²)           | O(V)             |
        | Directed Weighted     | DFS       | O(V²)           | O(V)             |
        |-----------------------|-----------|-----------------|------------------|


        |------------------|----------|----------------|-----------------|
        | Representation   | Storage  | BFS / DFS Time | BFS / DFS Space |
        | ---------------- | -------- | -------------- | --------------- |
        | Adjacency Matrix | O(V²)    | O(V²)          | O(V)            |
        | Adjacency List   | O(V + E) | O(V + E)       | O(V)            |
        |------------------|----------|----------------|-----------------|


        CONDITIONS FOR NEIGHBOUR CHECKING IN BFS / DFS :

        |-----------------------|----------------|------------------------------------------------------|
        | Graph Type            | Representation | Neighbour Condition                                  |
        | --------------------- | -------------- | -----------------------------------------------------|
        | Undirected Unweighted | Matrix         | `adj[u][v] == 1 && !visited[v]`                      |
        | Directed Unweighted   | Matrix         | `adj[u][v] == 1 && !visited[v]`                      |
        | Undirected Weighted   | Matrix         | `adj[u][v] != INF(Integer.MAX_VALUE) && !visited[v]` |
        | Directed Weighted     | Matrix         | `adj[u][v] != INF(Integer.MAX_VALUE) && !visited[v]` |
        | Any Unweighted        | List           | `if (!visited[nbr])`                                 |
        | Any Weighted          | List           | `if (!visited[e.to])`                                |
        |-----------------------|----------------|------------------------------------------------------|


 */
    

