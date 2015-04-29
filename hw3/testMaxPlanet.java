import org.junit.Test;
import static org.junit.Assert.*;

public class testMaxPlanet {
	@Test
	public void testLargestPlanet(){
		Planet planet1 = new Planet(0, 0, 0, 0, 5, null, 10);
		Planet planet2 = new Planet(0, 0, 0, 0, 4, null, 11);
		Planet[] planets = new Planet[]{planet1, planet2};

		MassComparator m = new MassComparator();
		RadiusComparator r = new RadiusComparator();

		assertEquals(planet1, MaxPlanet.maxPlanet(planets, m));
		assertEquals(planet2, MaxPlanet.maxPlanet(planets, r));
	}
	public static void main(String[] args){
		jh61b.junit.textui.runClasses(testMaxPlanet.class);		
	}
}