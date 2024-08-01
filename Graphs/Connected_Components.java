import java.util.*;
class Grapphy {
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

    public int connected_components() {
        int ans=0;
        int vis[] = new int[v+1];
        for(int i=1;i<=v;i++) {
            if(vis[i]==0) {
                dfs(i,vis);
                ans++;
            } 
        }
        return ans;
    }

    public void dfs(int n,int vis[]) {
        vis[n]=1;
        for(Integer i : l.get(n)) {
            if(vis[i]==0) {
                dfs(i,vis);
            }
        }
    }
}

public class Connected_Components {

    public static void main(String[] args) {
        Grapphy g = new Grapphy(6);
        int x[][]={{5,6},{1,2},{1,3},{2,4},{3,4}};
        for(int i=0;i<5;i++) {
            g.addEdge(x[i][0],x[i][1]);
        }

        System.out.println(g.connected_components());
    }
}
