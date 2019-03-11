import java.util.*;
import java.io.*;
public class USACO {
    //class for bronze
    private static class Bronzee {
	//variables
    	private int R, C, E, N, R_s, C_s, D_s;
	//stomping grounds
    	private int[][] grounds;
	//scanner 
    	private Scanner grid;
	//initializing everything
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
	//getting the next move from scanner
	public void nextMove() {
	    if (grid.hasNextInt()) {
		R_s = grid.nextInt()-1;
		C_s = grid.nextInt()-1;
		D_s = grid.nextInt();
	    }
	}
	//solving
	public void solve(int instruction) {
	    //if there's still moves 
	    if (instruction < N) {
		//find the highest ground
		int max = 0;
		for(int i = 0; i < 3; i++) {
		    for(int j = 0; j < 3; j++) {
			if (max < grounds[R_s+i][C_s+j]) {
			    max = grounds[R_s+i][C_s+j];
			}
		    }
		}
		//in the 3 by 3, if the ground within the highest ground by the depth then stomp it down to the max - depth
		for(int i = 0; i < 3; i++) {
		    for(int j = 0; j < 3; j++) {
			if (max - grounds[R_s+i][C_s+j]<= D_s) {
			    grounds[R_s+i][C_s +j] = max-D_s;
			}
		    }
		}
		//get the next set of instructions
		nextMove();
		//proceed until finished all instructions
		solve(instruction+1);
	    }
	}
	//calculating the volume of lake
	public int volume() {
	    int summation = 0;
	    //go through the grounds
	    for(int i = 0; i < grounds.length; i++) {
		for(int j = 0; j < grounds[0].length; j++) {
		    //finding the total depth
		    grounds[i][j] = (grounds[i][j]*-1) + E;
		    //System.out.println(toString());
		    if (grounds[i][j] > 0) {
			summation += grounds[i][j];
		    }
		}
	    }
	    //multiplying it with 72 and 72
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
    //bronze
    public static int bronze(String filename) throws FileNotFoundException {
	//instantiating class
	Bronzee blank = new Bronzee(filename);
	//solving
	blank.solve(0);
	//returning solution
	return blank.volume();
    }
    //silver
    public static int silver(String filename) throws FileNotFoundException{
	try {
	    //possible moves
	    int[] possibleX = {0,0,-1,1};
	    int[] possibleY = {1,-1,0,0};
	    //reading from file
	    File f = new File(filename);
	    Scanner g = new Scanner(f);
	    int N = g.nextInt();
	    int M = g.nextInt();
	    int T = g.nextInt();
	    //making the array
	    int[][] grid = new int[N][M];
	    for(int i = 0; i < N; i++) {
		//basically the line since the dots have no space
		String x = g.next();
		for(int j = 0; j < M; j++) {
		    //. = 0
		    if (x.charAt(j) == '.') {
			grid[i][j] = 0;
		    } else {
			//* = -1 
			grid[i][j] = -1;
		    }
		}
	    }
	    //	System.out.println(toString(grid));
	    //getting the start coordinates
	    int R1 = g.nextInt()-1;
	    int C1 = g.nextInt()-1;
	    //getting the end coordinates
	    int R2 = g.nextInt()-1;
	    int C2 = g.nextInt()-1;
	    //setting the start to be 1
	    grid[R1][C1] = 1;
	    //looping through the amount of time
	    for(int i = 0; i < T; i++) {
		//creating a second grid(temporary)
		int[][]gridz = new int[N][M];
		//going through the grid
		for(int x = 0; x <  grid.length; x++) {
		    for(int y = 0; y < grid[0].length; y++) {
			//place the trees in the temp grid
			if (grid[x][y] == -1) {
			    gridz[x][y] = -1;
			} else {
			    //variable to keep track of the values
			    int count = 0;
			    //going through the possible moves
			    for(int z = 0; z < 4; z++) {
				int row = x + possibleX[z];
				int col = y + possibleY[z];
				//if u can utilize the possible moves add it to the variable
				if (check(row,col,grid)) {
				    count += grid[row][col];
				}
			    }
			    gridz[x][y] = count;
			}
		    }
		}
		//updating grid
		grid = gridz;
		//System.out.println(toString(gridz));
	    }
	    return grid[R2][C2];
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
    //checking to see if you can add at row and col
    public static boolean check(int row, int col, int[][] grid) {
	if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != -1) {
	    return true;
	} else {
	    return false;
	}
    }
    // public static void main(String[] args)throws FileNotFoundException {
    // 	System.out.println(bronze("makeLake.txt"));
    // 	System.out.println(silver("silverTest.txt"));
    // }
}
	
	
