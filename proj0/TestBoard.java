/** file: TestPiece.java
*   author: S. Kojoian
*   JUnit tests for the Board class
*/
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBoard{
	@Test
	public void testPieceAt(){
		Board b = new Board(false);
		b.initializeBoard();
		Piece p = b.pieceAt(0, 2);
		assertEquals("bomb", p.type);
		assertEquals(true, p.isFire());

		p = b.pieceAt(0, 0);
		assertEquals("pawn", p.type);
		assertEquals(true, p.isFire());

		p = b.pieceAt(1, 0);
		assertEquals(null, p);

		p = b.pieceAt(24, 12);
		assertEquals(null, p);
	}

	@Test
	public void testPlace(){
		StdDrawPlus.setXscale(0, 8);
		StdDrawPlus.setYscale(0, 8);
		
		Board b = new Board(true);
		Piece p = new Piece(false, b, 0, 0, "pawn");
		b.place(p, 3, 4);
		b.drawGrid();
		b.drawPieces();

	}

	@Test
	public void testRemove(){
		StdDrawPlus.setXscale(0, 8);
		StdDrawPlus.setYscale(0, 8);
		
		Board b = new Board(true);
		Piece p = new Piece(false, b, 0, 0, "pawn");
		b.place(p, 3, 4);
		assertEquals(p, b.pieceAt(3, 4));
		b.remove(3, 4);
		assertEquals(null, b.pieceAt(3, 4));		
	}

	@Test
	public void testCanEndTurn(){
		StdDrawPlus.setXscale(0, 8);
		StdDrawPlus.setYscale(0, 8);
		
		Board b = new Board(true);
		Piece p = new Piece(false, b, 0, 0, "pawn");
		b.place(p, 3, 4);
		assertEquals(false, b.canEndTurn());

		b.pieceMoved = true;
		assertEquals(true, b.canEndTurn());

		b.pieceMoved = false;
		b.pieceSelected = p;
		assertEquals(false, b.canEndTurn());

		b.pieceSelected.captured = true;
		assertEquals(true, b.canEndTurn());
	}

	@Test
	public void testEndTurn(){
		StdDrawPlus.setXscale(0, 8);
		StdDrawPlus.setYscale(0, 8);
		
		Board b = new Board(true);
		Piece p = new Piece(false, b, 0, 0, "pawn");
		b.place(p, 3, 4);
		b.pieceSelected = p;
		assertEquals("fire", b.player);
		assertEquals(p, b.pieceSelected);
		b.pieceMoved = true;
		assertEquals(true, b.pieceMoved);

		b.endTurn();
		assertEquals("water", b.player);
		assertEquals(null, b.pieceSelected);
		assertEquals(false, b.pieceMoved);
	}

	public void testIncorrectPlayerTurn(){
		// to select a fire piece, it must be
		// it must be fire player's turn
		// * turn: fire
		Board b = new Board(true);
		Piece p = new Piece(false, b, 0, 0, "pawn");
		b.place(p, 0, 0);
		// Can't select a water piece on 
		// fire player's turn
		assertEquals(false, b.canSelect(0, 0));
		p.isFire = true;
		assertEquals(true, b.canSelect(0,0));
		b.endTurn();
		// * turn: water
		Piece q = new Piece(false, b, 1, 0, "pawn");
		b.place(q, 1, 0);
		p.isFire = true;
		// Can't select a fire piece on
		// water player's turn
		assertEquals(false, b.canSelect(1, 0));
		p.isFire = false;
		assertEquals(true, b.canSelect(1, 0));		
	}

	public void testSelectSquareWithPiece(){
		// Square with a piece may be selected if:
		// 	- The player has not selected a piece
		// 	- The player has selected a piece, but 
		// 	  hasn't moved it
		Board b = new Board(true);
		Piece p = new Piece(true, b, 0, 0, "pawn");
		Piece q = new Piece(true, b, 1, 0, "bomb");
		b.place(p, 0, 0);		
		b.place(q, 1, 0);
		// No piece is selected
		assertEquals(true, b.canSelect(1, 0));

		// Piece has been selected, but hasn't been moved		
		b.pieceSelected = b.pieces[1][0];
		assertEquals(true, b.canSelect(0, 0));

		// Piece has been selected, and moved
		// Shouldn't be allowed to select another piece		
		b.pieceSelected = b.remove(0, 0);
		b.place(b.pieceSelected, 3, 2);
		b.pieceMoved = true;
		assertEquals(false, b.canSelect(1, 0));
	}

	public void testSelectEmptySquare(){
		// An empty square may be selected if
		// 	- (During this turn) a player has selected
		// 	  a piece which hasn't moved yet and is 
		// 	  selecting an empty slot which is a valid
		//  	  move for the previously selected piece
		// 	- (During this turn) a player has selected 
		// 	  a piece, captured, and has selected another
		// 	  valid capture destination. 
		Board b = new Board(true);
		Piece p = new Piece(true, b, 0, 0, "pawn");
		Piece q = new Piece(true, b, 1, 0, "bomb");
		b.place(p, 0, 0);		
		b.place(q, 1, 0);
		// turn 0:
		// piece selected but not moved
		b.pieceSelected = b.pieces[0][0];
		// selection of an empty slot for a valid move
		assertEquals(true, b.canSelect(0, 1));
		// selection of an empty slot for an invalid move
		assertEquals(false, b.canSelect(0, 6));


		// *************************************************
		Piece firstToCapture = new Piece(false, b, 1, 1, "pawn");
		Piece secondToCapture = new Piece(false, b, 3, 3, "pawn");
		b.place(firstToCapture, 1, 1);
		b.place(secondToCapture, 3, 3);
		// Simulate capturing piece at 1, 1 by the piece at 0, 0
		b.remove(1, 1); 
		Piece moving = b.remove(0, 0);
		b.place(moving, 2, 2);
		b.pieceMoved = true;
		b.moving.captured = true;
		// select another valid capture destination
		assertEquals(true, b.canSelect(4, 4));
		// can't select a non-capture square
		assertEquals(false, b.canSelect(6, 7));
		assertEquals(false, b.canSelect(3, 3));
	}

	@Test
	public void testCanSelect(){
		testIncorrectPlayerTurn();
		testSelectSquareWithPiece();
		testSelectEmptySquare();
	}

	@Test
	public void testValidMove(){
		Board b = new Board(true);
		Piece p = new Piece(true, b, 0, 0, "pawn");
		b.place(p, 0, 0);
		assertEquals(true, b.validMove(0, 0, 1, 1));
		assertEquals(false, b.validMove(0, 0, -1, 0));
		assertEquals(false, b.validMove(0, 0, 0, 8));

		// Non crowned pieces can't move backwards
		Piece q = new Piece(true, b, 3, 2, "pawn");
		b.place(q, 3, 2);
		assertEquals(false, b.validMove(3, 2, 2, 1));
		// Crowned pieces can move backwards 
		q.kinged = true;
		assertEquals(true, b.validMove(3, 2, 2, 1));

		// test capturing positions
		Piece r = new Piece(true, b, 3, 4, "pawn");
		Piece s = new Piece(true, b, 4, 5, "pawn");
		b.place(r, 3, 4);
		b.place(s, 4, 5);
		assertEquals(true, b.validMove(3, 4, 5, 6));
		b.place(b.remove(4, 5), 2, 5);
		assertEquals(true, b.validMove(3, 4, 1, 6));

		// non crowned pieces can't eatch backwards
		b.place(b.remove(2, 5), 2, 3);
		assertEquals(false, b.validMove(3, 4, 1, 2)); 
	}

	@Test
	public void testSelect(){

	}

	public static void main(String[] args){
		jh61b.junit.textui.runClasses(TestBoard.class);
	}	
}