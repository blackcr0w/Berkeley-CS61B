package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void basicTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(5);
        arb.enqueue(3);
        assertEquals(5.0, arb.dequeue(), 1e11);
        assertEquals(3.0, arb.dequeue(), 1e11);
    }

    @Test
    public void testCapacity(){
    	ArrayRingBuffer arb = new ArrayRingBuffer(2);
    	arb.enqueue(5);
    	arb.enqueue(3);
    	// arb.enqueue(4);
    	arb.dequeue();
    	arb.enqueue(4);
    	assertEquals(3.0, arb.dequeue(), 1e11);
    	assertEquals(4.0, arb.dequeue(), 1e11);
    }

    @Test
    public void testThrowableErrors(){
     	ArrayRingBuffer arb = new ArrayRingBuffer(2);
    	arb.enqueue(5);
    	arb.enqueue(3);
	try {
		arb.enqueue(4);
	} catch (RuntimeException e){
		System.out.println("testThrowableErros has caught an error: " + e);
	}
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 