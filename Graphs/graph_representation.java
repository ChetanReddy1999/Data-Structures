import java.util.*;

class graph_representation {
    // Adjacency matrix representation
    public static void create_graph(int g[][],int n) {
        int graph[][] = new int[n][n];
        for(int i=0;i<n;i++) {
            int u = g[i][0];
            int v = g[i][1];
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }


    // Adjacency List Representation
    public static void create_graph2(int g[][],int n) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        for(int i=0;i<n;i++) {
            a.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++) {
            int u = g[i][0];
            int v = g[i][1];
            a.get(v).add(u);
            a.get(u).add(v);
        }

        // Print graph
        for(int i=0;i<n;i++) {
            System.out.println(i+" "+a.get(i));
        }
    }

    public static void main(String args[]) {
        int x[][]={{5,6},{1,2},{1,3},{2,4},{3,4},{3,5},{4,5}};
        create_graph2(x,7);

    }
}