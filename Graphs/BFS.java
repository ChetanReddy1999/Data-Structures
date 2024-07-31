import java.util.*;

class Graph {
    int v;
    ArrayList<ArrayList<Integer>> l;
    Graph(int v) {
        this.v = v;
        l=new ArrayList<>();
        for(int i=0;i<=v;i++) {
            l.add(new ArrayList<>());
        }
    }

    void addEdge(int u,int v) {
        l.get(u).add(v);
        l.get(v).add(u);
    }

    void bfs(int st) {
        Queue<Integer> q = new LinkedList<>();

        int vis[] = new int[v+1];
         q.add(st);
         vis[st]=1;

         while(!q.isEmpty()) {
            int n = q.remove();
            System.out.print(n+" ");
            for(Integer i : l.get(n)) {
                if(vis[i]==0) {
                    q.add(i);
                    vis[i]=1;
                }
            }
         }
         System.out.println();

    }
}


public class BFS {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        int x[][]={{5,6},{1,2},{1,3},{2,4},{3,4},{3,5},{4,5}};
        for(int i=0;i<7;i++) {
            g.addEdge(x[i][0],x[i][1]);
        }

        g.bfs(6);

    }
}
