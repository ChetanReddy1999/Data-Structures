import java.util.*;

class Pair {
    int node;
    int parent;

    Pair(int node,int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class undirected_cycle_detection {
    public static boolean cycle_detect(ArrayList<ArrayList<Integer>> l,int n) {
        int vis[] = new int[n+1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,-1));
        vis[1]=1;

        while(!q.isEmpty()) {
            Pair p = q.remove();

            for(Integer i : l.get(p.node)) {
                if(vis[i]==0) {
                    vis[i]=1;
                    q.add(new Pair(i,p.node));
                }

                else if(vis[i]==1 && p.parent!=i) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> l,int node,int parent,int vis[]) {

        for(Integer i : l.get(node)) {
            if(vis[i]==0) {
                vis[i]=1;
                return dfs(l,i,node,vis);
            }
            else if (vis[i]==1 && i!=parent) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        int vis[] = new int[4];
        vis[1]=1;

        System.out.println(dfs(adj,1,-1,vis));
        System.out.println(cycle_detect(adj, 3));
    }
}
