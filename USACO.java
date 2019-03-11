import java.util.*;
import java.io.*;
public class USACO {
    private static class Bronzee {
    	private int R, C, E, N, R_s, C_s, D_s;
    	private int[][] grounds;
    	private Scanner grid;
    	public Bronzee(String file) throws FileNotFoundException {
    	    File g = new File(file);
    	    Scanner gridz = new Scanner(g);
    	    grid = gridz;
    	    try {
    		R = grid.nextInt();
    		C = grid.nextInt();
    		E = grid.nextInt();
    		N = grid.nextInt();
    		grounds = new int[R][C];
    		for(int i = 0; i < R; i++) {
    		    for(int j = 0; j < C; j++) {
    			grounds[i][j] = grid.nextInt();
    		    }
    		}
		R_s = grid.nextInt()-1;
    		C_s = grid.nextInt()-1;
    		D_s = grid.nextInt();
    	    } catch (Exception e) {
    		e.printStackTrace();
    	    }
    	}
	public void nextMove() {
	    if (grid.hasNextInt()) {
		R_s = grid.nextInt()-1;
		C_s = grid.nextInt()-1;
		D_s = grid.nextInt();
	    }
	}
	public void solve(int instruction) {
	    if (instruction < N) {
		int max = 0;
		int num = grounds[R_s][C_s];
		for(int i = 0; i < 3; i++) {
		    for(int j = 0; j < 3; j++) {
			if (max < grounds[R_s+i][C_s+j]) {
			    max = grounds[R_s+i][C_s+j];
			}
		    }
		}
		for(int i = 0; i < 3; i++) {
		    for(int j = 0; j < 3; j++) {
			if (max - grounds[R_s+i][C_s+j]<= D_s) {
			    grounds[R_s+i][C_s +j] = max-D_s;
			}
		    }
		}
		nextMove();
		solve(instruction+1);
	    }
	}
	public int volume() {
	    int summation = 0;
	    for(int i = 0; i < grounds.length; i++) {
		for(int j = 0; j < grounds[0].length; j++) {
		    grounds[i][j] = (grounds[i][j]*-1) + E;
		    //System.out.println(toString());
		    if (grounds[i][j] > 0) {
			summation += grounds[i][j];
		    }
		}
	    }
	    return summation*72*72;
	}
       public String toString() {
	    String output = "";
	    for(int i = 0; i < grounds.length; i++) {
		for (int j = 0; j < grounds[0].length; j++) {
		    output += grounds[i][j] + " ";
		}
		output += "\n";
	    }
	    return output;
	}
    }
    public static int bronze(String filename) throws FileNotFoundException {
	Bronzee blank = new Bronzee(filename);
	blank.solve(0);
	return blank.volume();
    }
    public static int silver(String filename) throws FileNotFoundException{
	try {
	int[] possibleX = {0,0,-1,1};
	int[] possibleY = {1,-1,0,0};
	File f = new File(filename);
	Scanner g = new Scanner(f);
	int N = g.nextInt();
	int M = g.nextInt();
	int T = g.nextInt();
	int[][] grid = new int[N][M];
	for(int i = 0; i < N; i++) {
	    String x = g.next();
	    for(int j = 0; j < M; j++) {
		if (x.charAt(j) == '.') {
		    grid[i][j] = 0;
		} else {
		    grid[i][j] = -1;
		}
	    }
	}
	//	System.out.println(toString(grid));
	int R1 = g.nextInt()-1;
	int C1 = g.nextInt()-1;
	int R2 = g.nextInt()-1;
	int C2 = g.nextInt()-1;
	grid[R1][C1] = 1;
	for(int i = 0; i < T; i++) {
	    int[][]gridz = new int[N][M];
	    for(int x = 0; x <  grid.length; x++) {
		for(int y = 0; y < grid[0].length; y++) {
		    if (grid[x][y] == -1) {
			gridz[x][y] = -1;
		    } else {
			int count = 0;
			for(int z = 0; z < 4; z++) {
			    int row = x + possibleX[z];
			    int col = y + possibleY[z];
			    if (check(row,col,grid)) {
				count += grid[row][col];
			    }
			}
			gridz[x][y] = count;
		    }
		}
	    }
	    grid = gridz;
	}
	return grid[R1][C1];
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return 0;
    }
    public static String toString(int[][] grid) {
	String output = "";
	for(int i  = 0; i < grid.length;i++) {
	    for(int j = 0; j< grid[0].length;j++) {
		output += grid[i][j];
	    }
	    output += "\n";
	}
	return output;
    }
	       
    public static boolean check(int row, int col, int[][] grid) {
	if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0) {
	    return true;
	} else {
	    return false;
	}
    }
    public static void main(String[] args)throws FileNotFoundException {
	System.out.println(bronze("makeLake.txt"));
	System.out.println(silver("silverTest.txt"));
    }
}
	
	
