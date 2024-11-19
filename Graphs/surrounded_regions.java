public class surrounded_regions {
    public static void dfs(char g[][],int vis[][],int i,int j,int n,int m) {
        int x[] = {-1,0,0,+1};
        int y[] = {0,-1,+1,0};

        for(int e=0;e<4;e++) {
            int ni = x[e]+i;
            int nj = y[e]+j;

            if(ni>=0 && ni<n && nj>=0 && nj<m && g[ni][nj]=='O' && g[ni][nj]==0) {
                vis[ni][nj]=1;
                dfs(g,vis,ni,nj,n,m);
            }
        }
    }
    public static void main(String[] args) {
        char g[][] = {
            {'X', 'X', 'X', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'O', 'O', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'X', 'O', 'O'}};
        int n = g.length;
        int m = g[0].length;

        int vis[][] = new int[n][m];

        for(int i=0;i<n;i++) {
            if(vis[i][0]==0 && g[i][0]=='O') {
                vis[i][0]=1;
                dfs(g,vis,i,0,n,m);
            }
            if(vis[i][m-1]==0 && g[i][m-1]=='O') {
                vis[i][m-1]=1;
                dfs(g,vis,i,m-1,n,m);
            }
        }

        for(int i=0;i<m;i++) {
            if(vis[0][i]==0 && g[0][i]=='O') {
                vis[0][i]=1;
                dfs(g,vis,0,i,n,m);
            }
            if(vis[n-1][i]==0 && g[n-1][i]=='O') {
                vis[n-1][i]=1;
                dfs(g,vis,n-1,i,n,m);
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(vis[i][j]!=1 && g[i][j]=='O') {
                    g[i][j] = 'X';
                } 
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(g[i][j]+" ");
            }
            System.out.println();
        }
    }
}
