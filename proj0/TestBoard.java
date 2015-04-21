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
	public void testCanSelect(){
		StdDrawPlus.setXscale(0, 8);
		StdDrawPlus.setYscale(0, 8);
		
		// Tests for selection of a square with a piece on it
		Board b = new Board(true);
		Piece p = new Piece(false, b, 0, 0, "pawn");
		b.place(p, 0, 4);
		assertEquals(true, b.canSelect(0, 4));

		b.select(0, 4);
		Piece q = new Piece(false, b, 0, 0, "pawn");
		b.place(q, 0, 3);
		assertEquals(true, b.canSelect(0, 3));

		b.select(0, 4);
		p.moved = true;
		assertEquals(false, b.canSelect(0, 3));

		// Tests for a selection of an empty square
		b = new Board(true);
		assertEquals(false, b.canSelect(0, 0));

		Piece p = new Piece(false, b, 0, 0, "pawn");
		b.place(p, 0, 4);
		assertEquals(false, b.canSelect(0, 0));

		b.select(0, 4);
		assertEquals(false, b.canSelect(0, 2));
		assertEquals(true, b.canSelect(0, 3));

		b.select(0, 4);
		p.moved = true;
		assertEquals(false, b.canSelect(0, 3));

	}

	public static void main(String[] args){
		jh61b.junit.textui.runClasses(TestBoard.class);
	}	
}