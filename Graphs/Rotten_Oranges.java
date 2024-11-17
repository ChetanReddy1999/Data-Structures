import java.util.*;

class Pair {
    int i;
    int j;
    int time;

    Pair(int i,int j,int time) {
        this.i=i;
        this.j=j;
        this.time=time;
    }
}
public class Rotten_Oranges {
    public int totTime = 0;
    public static int dfs(int g[][],int i,int j,int n,int m,int fresh,int time) {

        int delx[] = {-1,0,0,+1};
        int dely[] = {0,-1,+1,0};
        for(int x=0;x<4;x++) {
            int e = delx[x]+i;
            int f = dely[x]+j;

            if(e>=0 && e<n && f>=0 && f<m && g[e][f]==1 && g[e][f]!=2) {
                totTime = Math.max(totTime, time+1;)
                dfs(g,e,f,n,m,fresh-1,time+1);
            }

        }
    }

    public static void rotten_bfs(int g[][]) {
        int n = g.length;
        int m = g[0].length;

        int fresh=0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(g[i][j]==2) {
                    q.add(new Pair(i, j, 0));
                }

                if (g[i][j]==1) {
                    fresh++;
                }
            }
        }

        int time=0;
        while(!q.isEmpty()) {
            Pair p = q.remove();
            int delx[] = {-1,0,0,+1};
            int dely[] = {0,-1,+1,0};
            for(int x=0;x<4;x++) {
                int e = delx[x]+p.i;
                int f = dely[x]+p.j;

                if(e>=0 && e<n && f>=0 && f<m && g[e][f]==1 && g[e][f]!=2) {
                    g[e][f]=2;
                    time = Math.max(time,p.time+1);
                    q.add(new Pair(e,f,p.time+1));
                    fresh--;
                }

            }
        }

        if(fresh!=0) {
            System.out.println(-1);
        }
        else{
            System.out.println(time);
        }
    }
    public static void main(String[] args) {
        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };

        rotten_bfs(arr);
    }
}
