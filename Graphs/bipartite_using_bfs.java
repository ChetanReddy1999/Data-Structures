import java.util.*;

public class bipartite_using_bfs {
    public static boolean bipartite(ArrayList<ArrayList<Integer>> g) {
        int v = g.size();
        int col[] = new int[v];
        Arrays.fill(col,-1);

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        col[0]=0;

        while(!q.isEmpty()) {
            int x = q.remove();

            for(Integer j : g.get(x)) {
                if(col[j]==-1) {
                    col[j] = (col[x]+1)%2;
                    q.add(j);
                }
                else if(col[j]==col[x]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean using_dfs(ArrayList<ArrayList<Integer>> g,int col[],int i) {
        for(Integer j : g.get(i)) {
            if(col[j]==-1) {
                col[j] = (col[i]+1)%2;
                using_dfs(g, col, j);
            }
            else if(col[i]==col[j]) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        int v = adj.size();
        int col[] = new int[v];
        Arrays.fill(col,-1);
        col[0]=0;

        System.out.println(using_dfs(adj, col, 0));

        System.out.println(bipartite(adj));
    }
}
