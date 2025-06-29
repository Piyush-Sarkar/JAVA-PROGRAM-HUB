import java.util.*;
public class BellmanFord {
    static final int INF=99;
    void printSolution(int dist[],int n) {
        int i;
        System.out.println("Vertex\tDistance from Source");
        for(i=0;i<n;++i) {
            if(dist[i]==INF)
                System.out.println(i + "\t\tINF");
            else
                System.out.println(i + "\t\t" +dist[i]);
        }
    }
    //Function to run the Bellman-Ford algorithm
    void bellmanFord(int[][] graph, int V,int src) {
        int dist[] = new int[V];
        int i,u,v;
        for(i=0;i<V;i++)
            dist[i]=INF;
        dist[src]=0;
        for(i=1;i<=V-1;i++) {
            for(u=0;u<V;u++) {
                for(v=0;v<V;v++) {
                    if(graph[u][v]!=INF && dist[u]+graph[u][v]<dist[v])
                        dist[v] = dist[u] +graph[u][v];
                }
            }
        }
        for(u=0;u<V;u++) {
            for(v=0;v<V;v++) {
                if(graph[u][v]!=INF && dist[u]+graph[u][v]<dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }
        printSolution(dist,V);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,j,V,src;
        System.out.print("Enter the number of vertices: ");
        V=sc.nextInt();
        int graph[][] = new int[V][V];
        System.out.println("Enter the adjacncy matrix(use " + INF + " for INF ): ");
        for(i=0;i<V;i++) {
            for(j=0;j<V;j++) 
                graph[i][j]=sc.nextInt();
        }
        System.out.print("Enter the source vertex: ");
        src=sc.nextInt();
        BellmanFord ob=new BellmanFord();
        ob.bellmanFord(graph, V, src);
        sc.close();
    }
}