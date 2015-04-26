/** file: Bomb.java
*   author: S. Kojoian
*   An implementation of a bomb piece
*   made to override the default capture behaviour
*/
public class Bomb extends Piece {
	public Bomb(boolean isFire, Board b, int x, int y, String type){
		super(isFire, b, x, y, type);
	}

	/** Performs a capture operation for a bomb piece
	*
	*   @input: int x1, int y1 (start)
	*   @input: int x2, int y2 (end)
	*   @return: void
	*/
	protected void capture(int x1, int y1, int x2, int y2){
		for (int i = x2-1; i <= x2 + 1; i++){
			for (int j = y2 - 1; j <= y2 + 1; j++){
				if (i >= 0 && i < 8 && j >= 0 && j < 8){
					if (this.board.pieces[i][j] != null && 
					   !this.board.pieces[i][j].type.equals("shield")){
						if (this.board.pieces[i][j].isFire()){
							this.board.numFirePieces -= 1;
						} else {
							this.board.numWaterPieces -= 1;
						}

						this.board.remove(i, j);
					}
				}
			}
		}
	}	
}