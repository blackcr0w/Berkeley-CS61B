import org.junit.Test;
import static org.junit.Assert.*;

public class testNumOnes {
	@Test
	public void testingNumOnes(){
		assertEquals(10, NumOnes.numOnes(10234));
		assertEquals(0, NumOnes.numOnes(0));
		assertEquals(3, NumOnes.numOnes(14));
		assertEquals(18, NumOnes.numOnes(-23423432));
		assertEquals(32, NumOnes.numOnes(-1));
		assertEquals(1, NumOnes.numOnes(1));
	}

	public static void main(String[] args){
		jh61b.junit.textui.runClasses(testNumOnes.class);		
	}
}