/** file: TestPiece.java
*   author: S. Kojoian
*   JUnit tests for the Piece class
*/
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPiece {
	@Test
	public void testPieceConstructor(){
		Piece firePawn = new Piece(true, null, 0, 0, "pawn");
		Piece waterPawn = new Piece(false, null, 0, 0, "pawn");
		Piece waterBomb = new Piece(false, null, 0, 0, "bomb");
		Piece fireShield = new Piece(true, null, 0, 0, "shield");
	}

	@Test
	public void testIsFire(){
		Piece firePawn = new Piece(true, null, 0, 0, "pawn");
		assertEquals(true, firePawn.isFire());

		Piece waterBomb = new Piece(false, null, 0, 0, "bomb");
		assertEquals(false, waterBomb.isFire());
	}

	@Test
	public void testSide(){
		Piece firePawn = new Piece(true, null, 0, 0, "pawn");
		assertEquals(0, firePawn.side());

		Piece waterBomb = new Piece(false, null, 0, 0, "bomb");
		assertEquals(1, waterBomb.side());		
	}

	@Test
	public void testIsKing(){
		Piece firePawn = new Piece(true, null, 0, 0, "pawn");
		assertEquals(false, firePawn.isKing());

		Piece waterBombKing = new Piece(true, null, 0, 0, "bomb");
		waterBombKing.kinged = true;
		assertEquals(true, waterBombKing.isKing());		
	}

	@Test
	public void testIsBomb(){
		Piece firePawn = new Piece(true, null, 0, 0, "pawn");
		assertEquals(false, firePawn.isBomb());

		Piece waterBomb = new Piece(true, null, 0, 0, "bomb");
		assertEquals(true, waterBomb.isBomb());		
	}

	@Test
	public void testIsShield(){
		Piece firePawn = new Piece(true, null, 0, 0, "pawn");
		assertEquals(false, firePawn.isShield());	

		Piece waterShield = new Piece(true, null, 0, 0, "shield");
		assertEquals(true, waterShield.isShield());		
	}

	@Test 
	public void testHasCaptured(){
		Piece firePawn = new Piece(true, null, 0, 0, "pawn");
		firePawn.captured = true;
		assertEquals(true, firePawn.hasCaptured());	
		
		Piece waterShield = new Piece(true, null, 0, 0, "shield");
		assertEquals(false, waterShield.hasCaptured());	
	}

	@Test
	public void testDoneCapturing(){
		Piece firePawn = new Piece(true, null, 0, 0, "pawn");
		firePawn.captured = true;
		assertEquals(true, firePawn.hasCaptured());	
		firePawn.doneCapturing();
		assertEquals(false, firePawn.hasCaptured());		
	}

	public static void main(String[] args){
		jh61b.junit.textui.runClasses(TestPiece.class);
	}
}