import java.util.*;

/*************************************

Following is the Point Class structure

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

**************************************/
class Sample{

	int dis,i,j;
	Sample(int dis,int i,int j){
		this.dis = dis;
		this.i = i;
		this.j = j;
	}
}
public class Solution {
	public static int shortestPathBinaryMatrix(int[][] matrix, Point src, Point dest) {
		// Write your code here

		int n = matrix.length,m=matrix[0].length;


		if(src.x==dest.x && src.y==dest.y){
			if(matrix[src.x][src.y]==1) return 0;

			else return -1;
		}
		if(matrix[src.x][src.y]==0 || matrix[dest.x][dest.y]==0) return -1;
	

		


		int[][] dis = new int[n][m];

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
		dis[src.x][src.y] = 0;

		Queue<Sample> queue = new LinkedList<>();

		queue.add(new Sample(0, src.x, src.y));

		int[] xx = {-1,0,1,0};
		int[] yy = {0,1,0,-1};


		while(!queue.isEmpty()){

			int ndis = queue.peek().dis;
			int ii = queue.peek().i;
			int jj = queue.peek().j;
			queue.poll();

			for(int op=0;op<4;op++){
				int a = ii+xx[op];
				int b = jj+yy[op];

				if(a>=0 && b>=0 && a<n && b<m && matrix[a][b]==1 && dis[a][b]>1+ndis){
					dis[a][b] = 1+ndis;
					queue.add(new Sample(1+ndis, a, b));
					if(a==dest.x && b==dest.y) return dis[a][b];
				}
			}


		}
		return -1;


	}
}
