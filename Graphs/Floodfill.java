import java.util.*;

class Pair{
    int i;
    int j;
    Pair(int i,int j) {
        this.i=i;
        this.j=j;
    }
}

public class Floodfill {
    public static void floodfillBFS(int g[][],int i,int j, int newcolor,int oldcolor) {
        int n = g.length;
        int m = g[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()) {
            Pair p = q.remove();

            g[p.i][p.j] = newcolor;

            int delx[] = {-1,0,0,+1};
            int dely[] = {0,-1,+1,0};

            for(int x=0;x<4;x++) {
                int e = delx[x]+p.i;
                int f = dely[x]+p.j;

                if(e>=0 && e<n && f>=0 && f<m && g[e][f]==oldcolor && g[e][f]!=newcolor) {
                    q.add(new Pair(e, f));
                }

            }
        }
    }

    public static void floodfillDFS(int g[][],int i,int j,int n,int m,int newcolor, int oldcolor) {
        g[i][j] = newcolor;

        int delx[] = {-1,0,0,+1};
        int dely[] = {0,-1,+1,0};
        for(int x=0;x<4;x++) {
            int e = delx[x]+i;
            int f = dely[x]+j;

            if(e>=0 && e<n && f>=0 && f<m && g[e][f]==oldcolor && g[e][f]!=newcolor) {
                floodfillDFS(g, e, f, n, m, newcolor, oldcolor);
            }

        }
    }
    public static void main(String[] args) {
        int[][] image =  {
	        {1,1,1},
	        {1,1,0},
	        {1,0,1}
	    };

        floodfillBFS(image, 1, 1, 2, image[1][1]);

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }

    }
}
