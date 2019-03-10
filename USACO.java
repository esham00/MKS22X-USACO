import java.util.*;
import java.io.*;
public class USACO {
    private class Bronzee {
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
    		R_s = grid.nextInt();
    		C_s = grid.nextInt();
    		D_s = grid.nextInt();
    	    } catch (Exception e) {
    		e.printStackTrace();
    	    }
    	}
	public void nextMove() {
	    if (grid.hasNextLine()) {
		R_s = grid.nextInt();
		C_s = grid.nextInt();
		D_s = grid.nextInt();
	    }
	}
	public void solve(int instruction) {
	    if (instruction < instruction) {
		toString();
		for(int i = 0; i < 3; i++) {
		    grounds[R_s+i][C_s] -= D_s;
		    grounds[R_s+i][C_s+i] -= D_s;
		    grounds[R_s][C_s+i] -= D_s;
		}
		nextMove();
		solve(instruction+1);
	    }
	}
	public int volume() {
	    int summation = 0;
	    for(int i = 0; i < grounds.length; i++) {
		for(int j = 0; j < grounds[0].length; j++) {
		    grounds[i][j] -= E;
		    if (grounds[i][j] > 0) {
			summation += grounds[i][j];
		    }
		}
	    }
	    return summation*R*12*C*12;
	}
	//    public int row() {
	// 	return R_s;
	//     }
	//     public int col() {
	// 	return C_s;
	//     }
	//     public int indent() {
	// 	return D_s;
	//     }
	// }
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
	String b = filename;
	Bronzee a = new Bronzee(b);
	a.solve(0);
	return a.volume();
    }

    public static void main(String[] args)throws FileNotFoundException {
	System.out.println(bronze("makeLake.txt"));
    }
}
	
	
