public class USACO {
    private class Bronze {
	private int R, C, E, N, R_s, C_s, D_s;
	private int[][] grounds;
	private Scanner grid;
	public Bronze(String file) {
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
			board[i][j] = grid.nextInt();
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
	public int solve(
    }
    public String toString() {
	String output = "";
	for(int i = 0; i < R; i++) {
	    for (int j = 0; j < C; j++) {
		output += grounds[i][j] + " ";
	    }
	    output += "\n";
	}
	return output;
    }
    public static int bronze(String filename) {
