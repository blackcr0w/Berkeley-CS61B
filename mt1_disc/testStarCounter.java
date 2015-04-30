import org.junit.Test;
import static org.junit.Assert.*;

public class testStarCounter {
	@Test
	public void testStarCount(){
		String[] containsStars = {"star", "hello", "map", "star"};
		assertArrayEquals(containsStars, starCounter.starCount(containsStars));

		containsStars = new String[]{"hello", "giant"};
		assertArrayEquals(containsStars, starCounter.starCount(containsStars));

		containsStars = null;
		assertArrayEquals(containsStars, starCounter.starCount(containsStars));

		containsStars = new String[]{"help", "yourself", "star", "child"};
		assertArrayEquals(new String[]{"help", "yourself", "child", null}, starCounter.starCount(containsStars));	

	}

	public static void main(String[] args){
		jh61b.junit.textui.runClasses(testStarCounter.class);		
	}
}