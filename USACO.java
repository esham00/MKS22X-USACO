import java.util.*;
import java.io.*;
public class USACO {
    // private class Bronze {
    // 	private   int R, C, E, N, R_s, C_s, D_s;
    // 	private  int[][] grounds;
    // 	private Scanner grid;
    // 	public Bronze(String file) throws FileNotFoundException {
    // 	    File g = new File(file);
    // 	    Scanner gridz = new Scanner(g);
    // 	    grid = gridz;
    // 	    try {
    // 		R = grid.nextInt();
    // 		C = grid.nextInt();
    // 		E = grid.nextInt();
    // 		N = grid.nextInt();
    // 		grounds = new int[R][C];
    // 		for(int i = 0; i < R; i++) {
    // 		    for(int j = 0; j < C; j++) {
    // 			grounds[i][j] = grid.nextInt();
    // 		    }
    // 		}
    // 		R_s = grid.nextInt();
    // 		C_s = grid.nextInt();
    // 		D_s = grid.nextInt();
    // 	    } catch (Exception e) {
    // 		e.printStackTrace();
    // 	    }
    // 	}
    public static void nextMove(int row, int col, int indent ) {
	if (grid.hasNextLine()) {
	    row = grid.nextInt();
	    col = grid.nextInt();
	    indent = grid.nextInt();
	}
    }
    public static  void solve(int row, int col, int indentation, int instruction) {
	if (instruction < N) {
	    for(int i = 0; i < 3; i++) {
		grounds[row+i][col] -= indentation;
		grounds[row+i][col+i] -= indentation;
		grounds[row][col+i] -= indentation;
	    }
	    nextMove(row, col, indentation);
	    solve(row, col, indentation, instruction+1);
	}
    }
    public static  int volume() {
	int summation = 0;
	for(int i = 0; i < grounds.length; i++) {
	    for(int j = 0; j < grounds.length; j++) {
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
    // public String toString() {
    // 	String output = "";
    // 	for(int i = 0; i < R; i++) {
    // 	    for (int j = 0; j < C; j++) {
    // 		output += grounds[i][j] + " ";
    // 	    }
    // 	    output += "\n";
    // 	}
    // 	return output;
    // }
    public static int bronze(String filename) throws FileNotFoundException {
	Bronze solution = new Bronze(filename);
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
	    solve(R_s, C_s, D_s, 0);
	    return volume();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    public static void main(String[] args) {
	System.out.println(bronze("makeLake.txt"));
    }
}
	
	
