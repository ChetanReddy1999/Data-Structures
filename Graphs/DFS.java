import java.util.*;
class Grapphy{
    int v;
    ArrayList<ArrayList<Integer>> l;
    Grapphy(int v) {
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

    void DFS(int n,int vis[]) {
        System.out.print(n+" ");
        for(Integer i : l.get(n)) {
            if(vis[i]==0) {
                vis[i]=1;
                DFS(i,vis);
            }
        }
    }
}

public class DFS {
    public static void main(String[] args) {
        Grapphy g = new Grapphy(6);
        int x[][]={{5,6},{1,2},{1,3},{2,4},{3,4},{3,5},{4,5}};
        for(int i=0;i<7;i++) {
            g.addEdge(x[i][0],x[i][1]);
        }

        int vis[] = new int[7];
        vis[6]=1;
        g.DFS(6,vis);
    }
}