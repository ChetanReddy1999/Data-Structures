import java.util.HashSet;

public class NumberOfDistinctIslands {
    public static String dfs(int i,int j,int g[][],int vis[][],int n,int m, int bi,int bj) {
        int x[] = {-1,0,0,+1};
        int y[] = {0,-1,+1,0};

        String ans = "";

        for(int p=0;p<4;p++) {
            int e = x[p]+i;
            int f = y[p]+j;

            if(e>=0 && e<n && f>=0 && f<m && g[e][f]==1 && vis[e][f]==0) {
                vis[e][f]=1;
                ans = dfs(e,f,g,vis,n,m,bi,bj) + ans;
            }
        }

        return Integer.toString(bi-i) + Integer.toString(bj-j) + ans;
    }
    public static void main(String[] args) {
        int g[][] = {{1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1}};
        int n = g.length;
        int m = g[0].length;
        int vis[][] = new int[n][m];
        HashSet<String> h = new HashSet<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(vis[i][j]==0 && g[i][j]==1) {
                    vis[i][j]=1;
                    String p = dfs(i,j,g,vis,n,m,i,j);
                    h.add(p);
                }
            }
        }
        System.out.println(h);

        System.out.println(h.size());
    }
}
