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

	public static void main(String[] args){
		jh61b.junit.textui.runClasses(TestBoard.class);
	}	
}