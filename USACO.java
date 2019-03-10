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
    public static int silver(String filename) {
        int[] possibleX = {0,0,-1,1};
	int[] possibleY = {1,-1,0,0};
	File f = new File(filename);
	Scanner g = new Scanner(f);
	int N = g.nextInt();
	int M = g.nextInt();
	int T = g.nextInt();
	int[][] grid = new int[N][M];
	for(int i = 0; i < N; i++) {
	    for(int j = 0; j < M; j++) {
		if (grid.next() == ".") {
		    grid[i][j] = 1;
		} else {
		    grid[i][j] = -1;
		}
	    }
	}
	int count = 0;
	R1 = grid.nextInt();
	C1 = grid.nextInt();
	R2 = grid.nextInt();
	C2 = grid.nextInt();
	for(int i = 0; i < T; i++) {
	    for(int j = 0; j < possibleMoves; j++
	    count += check(R1,C1,grid);
	}
    }
    public int check(int row, int col, int[][] grid) {
	if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] > 0) {
	    return 1;
	} else {
	    return 0;
	}
    }
    public static void main(String[] args)throws FileNotFoundException {
	System.out.println(bronze("makeLake.txt"));
    }
}
	
	
