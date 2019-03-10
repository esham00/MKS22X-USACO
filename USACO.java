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
		// System.out.println(grid.nextInt());
		// System.out.println(grid.nextInt());
		// System.out.println(grid.nextInt());
		R_s = grid.nextInt()-1;
		C_s = grid.nextInt()-1;
		D_s = grid.nextInt();
		// System.out.println(R_s);
		// System.out.println(C_s);
		// System.out.println(D_s);
	    }
	}
	public void solve(int instruction) {
	    if (instruction < N) {
		for(int i = 0; i < 3; i++) {
		    for(int j = 0; j < 3; j++) {
			grounds[R_s+i][C_s+j] -= D_s;
		    }
		}
		System.out.println(toString());
		nextMove();
		solve(instruction+1);
	    }
	}
	public int volume() {
	    int summation = 0;
	    for(int i = 0; i < grounds.length; i++) {
		for(int j = 0; j < grounds[0].length; j++) {
		    grounds[i][j] = grounds[i][j]*-1 + E;
		    if (grounds[i][j] > 0) {
			summation += grounds[i][j];
		    }
		}
	    }
	    return summation*72*72;
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
	Bronzee blank = new Bronzee(filename);
	blank.solve(0);
	return blank.volume();
    }

    public static void main(String[] args)throws FileNotFoundException {
	System.out.println(bronze("makeLake.txt"));
    }
}
	
	
