import java.util.*;
import java.io.*;


  class Pair {
	
	  int X;
	  int Y;
	
	   Pair(int X, int Y){
	      this.X = X;
		  this.Y = Y;
	 }
 }

public class Main {
	static int R; // 행
	static int C; // 열
	static char[][] maze; // 미로
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Pair> fireQ = new LinkedList<>(); 
	static Queue<Pair> jQ = new LinkedList<>(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		maze = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine(); 
			for(int j=0; j<C; j++) {
				maze[i][j] = s.charAt(j);
				
				if(maze[i][j] == 'F') {
					fireQ.add(new Pair(i, j)); 
				}
				if(maze[i][j] == 'J') {
					jQ.add(new Pair(i, j)); 
				}
			}
		}
		
		int count = 0;
		
		while(true) {
			count++;
			int fs = fireQ.size(); 
			
			while(fs>0) { 
				fs--;
				
				Pair pos = fireQ.poll();
				
				for(int i=0; i<4; i++) {
					
				int plusX = pos.X + dx[i];
				int plusY = pos.Y + dy[i];
				
				  if(plusX >= 0 && plusX < R && plusY >= 0 && plusY < C) { 
					  if(maze[plusX][plusY] == 'J' || maze[plusX][plusY] == '.') { 
						  fireQ.add(new Pair(plusX, plusY));
						  maze[plusX][plusY] = 'F';
					  }
				  }
				}
			}
			
			int js = jQ.size();
			while(js>0) {
				js--;
				Pair pos = jQ.poll();
				
				for(int i=0; i<4; i++) {
					
					int plusX = pos.X + dx[i];
					int plusY = pos.Y + dy[i];
					if(plusX < 0 || plusX >= R || plusY < 0 || plusY >= C) {
						System.out.println(count);
						return;
					}
					
					if(maze[plusX][plusY] == '.') {
						jQ.add(new Pair(plusX, plusY));
						maze[plusX][plusY] = 'F'; 
					}
				}
			}
			
			if(jQ.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}
	}
}