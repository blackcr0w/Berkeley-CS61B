/** file: Piece.java
*   author: S. Kojoian
*   Implementation of a piece
*/
public class Piece {
	// Fields are protected for testing purposes.
	// Set to private at the end of all testing.
	protected boolean isFire; 	// true - fire piece; false - water piece
	protected boolean kinged;	// reached final line
	protected boolean captured;		// initializes to false since the piece hasn't
						// at its creation
	protected Board board;
	protected int x;			// x coordinate
	protected int y;			// y coordinate
	protected String type;		// pawn/shield/bomb

	// Some new fields for canSelect and select methods
	// protected boolean moved;
	// protected boolean selected;

	/** CONSTRUCTOR 
	*   @param: boolean (is water/fire piece)
	*   @param: Board
	*   @param: int x, int y - the initial coordinates of this piece
	*   @param: String type - pawn/shield/bomb
	*   @return: Piece object
	*/
	public Piece(boolean isFire, Board b, int x, int y, String type){
		this.isFire = isFire;
		this.kinged = false;
		this.board = b;
		this.x = x;
		this.y = y;
		this.type = type;
		this.captured = false;
		// this.moved = false;
		// this.selected = false;
	}

	/** Returns true if this piece is a fire piece.
	*   False otherwise.
	*
	*  @return: Boolean
	*/
	public boolean isFire(){
		return isFire;
	}

	/** Returns 0 if this piece is a fire piece.
	*   1 otherwise.
	*
	*   @return: int
	*/
	public int side(){
		return isFire() ? 0 : 1;
	}

	/** Returns true if this piece has been Kinged.
	*   False otherwise.
	*
	*   @return: Boolean
	*/
	public boolean isKing(){
		return kinged;
	}

	/** Returns true if this piece is a Bomb.
	*   False otherwise.
	*
	*   @return: Boolean
	*/
	public boolean isBomb(){
		return getType() == "bomb";
	}

	/** Returns true if this piece is a Shield.
	*   False otherwise.
	*
	*   @return: Boolean
	*/
	public boolean isShield(){
		return getType() == "shield";
	}

	/** Helper method that returns the type
	*   of this piece.
	*
	*   @return: String type
	*/
	private String getType(){
		return type;
	}

	/** Returns true if this piece captured this
	*    turn. False otherwise.
	*
	*    @return: Boolean
	*/
	public boolean hasCaptured(){
		return captured;
	}

	/** Sets captured to false before current player's
	*   turn is over.
	*/
	public void doneCapturing(){
		captured = false;
	}

	/** TODO: 
	*   Moves this piece to (x, y) capturing interdemiate piece.
	*   Assumes movement to (x, y) is valid.
	*/
	public void move(int x, int y){
		boolean willCapture = false;
		int xToCapture = (this.x + x) / 2;
		int yToCapture = (this.y + y) / 2;
		if ((xToCapture != this.x && yToCapture != this.y) &&
		   (xToCapture != x && yToCapture != y)){
		   	willCapture = true;
		}

		Piece removed = this.board.remove(this.x, this.y);
		this.board.place(removed, x, y);

		if (willCapture){
			this.board.remove(xToCapture, yToCapture);
			this.captured = true;	
		}

		// Crowns appropriate pieces
		if ((this.y == 0 && !isFire()) ||
		    (this.y == 7 && isFire())){
			this.kinged = true;
		}		
	}
}