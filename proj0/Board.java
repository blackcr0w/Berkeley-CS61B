/** file: Board.java
*   author: S. Kojoian
*   Implementation of a board
*
*   java Board displays a blank 8x8 grid.
*/
public class Board{
	/** Draws an 8x8 blank grid. */
	public Piece[][] pieces;
	public boolean shouldBeEmpty;

	public Board(boolean shouldBeEmpty){
		pieces = new Piece[8][8];
		this.shouldBeEmpty = shouldBeEmpty;
	}

	/** Helper method initializing the piece configuration */
	public void initializeBoard(){
		int j;
		for (int i = 0; i < 8; i++){
			if (i % 2 == 0){
				j = 0;
			} else{
				j = 1;
			}
			for (; j < 8; j+=2){
				switch (j){
					case 0:
						pieces[i][j] = new Piece(true, this, i, j, "pawn");
						break;
					case 1:
						pieces[i][j] = new Piece(true, this, i, j, "shield");
						break;
					case 2:
						pieces[i][j] = new Piece(true, this, i, j, "bomb");
						break;
					case 5:
						pieces[i][j] = new Piece(false, this, i, j, "bomb");
						break;
					case 6:
						pieces[i][j] = new Piece(false, this, i, j, "shield");
						break;
					case 7:
						pieces[i][j] = new Piece(false, this, i, j, "pawn");
						break;
					default:
						break;
				}
			}
		}
	}

	/** Return the piece at (x, y).
	*   null, if no piece, or (x, y) is out of bounds.
	*
	*   @return: Piece
	*/
	public Piece pieceAt(int x, int y){
		if (x >= 8 || x < 0 || y >= 8 || y < 0){
			return null;
		} else {
			return pieces[x][y];
		}
	}

	/** Draws an empty board */
	public void drawGrid(){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if ((i + j) % 2 == 0){
					StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
				} else {
					StdDrawPlus.setPenColor(StdDrawPlus.RED);
				}
				StdDrawPlus.filledSquare(i+0.5, j+0.5, 0.5);
                			StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
			}
		}
	}

	/** Draws the initial piece configuration on the board */
	public void drawPieces(){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
	        			if (pieces[i][j] != null && pieces[i][j].isFire() && pieces[i][j].type.equals("pawn") && pieces[i][j].kinged){
					StdDrawPlus.picture(i + .5, j + .5, "img/pawn-fire-crowned.png", 1, 1);
	        			} else if (pieces[i][j] != null && pieces[i][j].isFire() && pieces[i][j].type.equals("shield") && pieces[i][j].kinged){
					StdDrawPlus.picture(i + .5, j + .5, "img/shield-fire-crowned.png", 1, 1);
				} else if (pieces[i][j] != null && pieces[i][j].isFire() && pieces[i][j].type.equals("bomb") && pieces[i][j].kinged){
					StdDrawPlus.picture(i + .5, j + .5, "img/bomb-fire-crowned.png", 1, 1);
				} else if (pieces[i][j] != null && pieces[i][j].type.equals("pawn") && pieces[i][j].kinged){
					StdDrawPlus.picture(i + .5, j + .5, "img/pawn-water-crowned.png", 1, 1);
				} else if (pieces[i][j] != null && pieces[i][j].type.equals("shield") && pieces[i][j].kinged){
					StdDrawPlus.picture(i + .5, j + .5, "img/shield-water-crowned.png", 1, 1);
				} else if (pieces[i][j] != null && pieces[i][j].type.equals("bomb") && pieces[i][j].kinged){
					StdDrawPlus.picture(i + .5, j + .5, "img/bomb-water-crowned.png", 1, 1);
				} else if (pieces[i][j] != null && pieces[i][j].isFire() && pieces[i][j].type.equals("pawn")) {
	                			StdDrawPlus.picture(i + .5, j + .5, "img/pawn-fire.png", 1, 1);
	           			} else if (pieces[i][j] != null && pieces[i][j].isFire() && pieces[i][j].type.equals("bomb")) {
	            			StdDrawPlus.picture(i + .5, j + .5, "img/bomb-fire.png", 1, 1);
	        			} else if (pieces[i][j] != null && pieces[i][j].isFire() && pieces[i][j].type.equals("shield")) {
	            			StdDrawPlus.picture(i + .5, j + .5, "img/shield-fire.png", 1, 1);
	        			} else if (pieces[i][j] != null && pieces[i][j].type.equals("pawn")) {
	            			StdDrawPlus.picture(i + .5, j + .5, "img/pawn-water.png", 1, 1);
	        			} else if (pieces[i][j] != null && pieces[i][j].type.equals("bomb")) {
	            			StdDrawPlus.picture(i + .5, j + .5, "img/bomb-water.png", 1, 1);
	        			} else if (pieces[i][j] != null && pieces[i][j].type.equals("shield")) {
	            			StdDrawPlus.picture(i + .5, j + .5, "img/shield-water.png", 1, 1);
	        			} else {
	        				continue;
	        			}
	        		}
	        	}
	}

	/** Places piece p on (x, y) on the board. If another piece exists
	*   there, it is replaced by p. If (x, y) is out of bounds, 
	*   method doesn't do anything.
	*/
	public void place(Piece p, int x, int y){
		if (x >= 8 || x < 0 || y >= 8 || y < 0 || p == null){
			return;
		} else {
			p.x = x;
			p.y = y;
			pieces[x][y] = p;
		}		
	}

	public static void main(String[] args){
		StdDrawPlus.setXscale(0, 8);
		StdDrawPlus.setYscale(0, 8);

		Board b = new Board(false);
		b.drawGrid();
		if (!b.shouldBeEmpty){
			b.initializeBoard();
			b.drawPieces();		
		}

	}
}