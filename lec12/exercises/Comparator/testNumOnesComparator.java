import org.junit.Test;
import static org.junit.Assert.*;

public class testNumOnesComparator{
	@Test
	public void testComparator(){
		NumOnes c = new NumOnes();
		assertEquals(-1, c.compare(14, 10234));
		assertEquals(-1, c.compare(0, 14));
		assertEquals(-1, c.compare(-23423432, -1));		
	}

	public static void main(String[] args){
		jh61b.junit.textui.runClasses(testNumOnesComparator.class);		
	}	
}
