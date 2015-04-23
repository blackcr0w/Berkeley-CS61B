/** file: Board.java
*   author: S. Kojoian
*   Implementation of a board
*
*   java Board displays a blank 8x8 grid.
*/
public class Board{
	/** Draws an 8x8 blank grid. */
	public String player;
	public Piece[][] pieces;
	public boolean shouldBeEmpty;
	// Fields for a possible implementation of piece selection
	public Piece pieceSelected; 
	public boolean pieceMoved;

	public Board(boolean shouldBeEmpty){
		pieces = new Piece[8][8];
		this.shouldBeEmpty = shouldBeEmpty;
		player = "fire";
		pieceMoved = false;
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

	/** Removes this piece from the board and returns it.
	*   If piece doesn't exist, or if (x,y) is out of bounds, return null. 
	*
	*   @input: int x, int y
	*   @return: Piece  (null if piece doesn't exist)
	*/
	public Piece remove(int x, int y){
		if (x >= 8 || x < 0 || y >= 8 || y < 0 || pieces[x][y] == null){
			return null;
		} else {
			Piece piece = pieces[x][y];
			pieces[x][y] = null;
			return piece;
		}		
	}

	/** Returns true if the square clicked on is a valid move
	*    for the selected piece
	*    
	*    // TODO: Implement the method
	*
	*    @param: int xi, int yi
	*    @param: int xf, int yf
	*    @return: boolean
	*/
	public boolean validMove(int xi, int yi, int xf, int yf){
		return false;
	}

	/** Returns true if the square clicked may be selected.
	*   False, otherwise.
	*
	*   @param: int x, int y
	*   @return: boolean
	*
	*   	    // TODO: Implement boolean validMove(int x1, int y1, int x2, int y2),
	*	    // write a test
	*/
	// public boolean canSelect(int x, int y){
	// 	if (pieces[x][y] != null){
	// 		if (player != pieces[x][y].type){
	// 			return false;
	// 		}

	// 		if (pieceSelected == null || !pieceMoved){
	// 			return true;
	// 		} else {
	// 			return false;
	// 		}
	// 	} else if (pieceSelected != null && !pieceMoved){
	// 		if (validMove(pieceSelected.x, pieceSelected.y, x, y)){
	// 				return true;
	// 		} else {
	// 			return false;
	// 		}
	// 	} else if (pieceSelected != null && pieceSelected.captured){
	// 		if (validMove(pieceSelected.x, pieceSelected.y, x, y)){
	// 				return true;
	// 		} else {
	// 			return false;
	// 		}			
	// 	}
	// }

	/** Selects the piece on the board
	*    if all the necessary conditions are met.
	*
	*    @param: int x, int y
	*    @return: void
	*
	*	// TODO: write a test, 
	*	// Assume canSelect returns True
	*/
	public void select(int x, int y){
		if (pieces[x][y] != null){
			pieceSelected = pieces[x][y];
		} else {
			pieceSelected.move(x, y);
			pieceMoved = true;
		}
	}

	/** Returns true if turn may be ended.
	*   False, otherwise.
	*/
	public boolean canEndTurn(){
		if (pieceSelected != null && pieceSelected.captured){
			return true;
		} else if (pieceMoved){
			return true;
		} else {
			return false;
		}
	}

	/** Ends the turn  if canEndTurn returns true. */
	public void endTurn(){
		pieceSelected = null;
		pieceMoved = false;
		player = player == "fire" ? "water" : "fire";
	}

	/** Returns the winner of the game. 
	*	// TODO: write a test,
	*	//	   implement the method
	*/
	public String winner(){
		return "";
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