import java.util.LinkedList;
import java.util.Queue;

class pair {
    int i;
    int j;
    pair(int i,int j) {
        this.i=i;
        this.j=j;
    }
}

public class number_of_enclaves {
    public static int numEnclaves(int[][] g) {
        int n = g.length;
        int m = g[0].length;

        int vis[][] = new int[n][m];
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(g[i][0]==1){q.add(new pair(i,0));}
            if(g[i][m-1]==1){q.add(new pair(i,m-1));}
            vis[i][0]=1;
            vis[i][m-1]=1;
        }

        for(int j=0;j<m;j++) {
            if(g[0][j]==1){q.add(new pair(0,j));}
            if(g[n-1][j]==1){q.add(new pair(n-1,j));}
            vis[0][j]=1;
            vis[n-1][j]=1;
        }

        while(!q.isEmpty()) {
            pair p = q.remove();

            int x[] = {-1,0,0,+1};
            int y[] = {0,-1,+1,0};

            for(int i=0;i<4;i++) {
                int e = x[i]+p.i;
                int f = y[i]+p.j;

                if(e>=0 && e<n && f>=0 && f<m && g[e][f]==1 && vis[e][f]==0) {
                    q.add(new pair(e,f));
                    vis[e][f]=1;
                }
            }
        }

        int ans=0;
        for(int i=1;i<n-1;i++) {
            for(int j=1;j<m-1;j++) {
                if(vis[i][j]==0 && g[i][j]==1) {
                    ans++;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int grid[][] = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}};
    
            int ans = numEnclaves(grid);
            System.out.println(ans);
    }
}
