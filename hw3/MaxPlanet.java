import java.util.Comparator;
/* Import anything else you need here. */

/**
 * MaxPlanet.java
 */

public class MaxPlanet {

    /** Returns the Planet with the maximum value according to Comparator c. */
    public static Planet maxPlanet(Planet[] planets, Comparator<Planet> c) {
        // REPLACE THIS LINE WITH YOUR SOLUTION
        if (planets == null){
        	return null;
        }

        int indexOfLargestPlanet = 0;
        Planet largestPlanet = planets[indexOfLargestPlanet];

        for (int index = 0; index < planets.length; index++){
        	if (c.compare(planets[indexOfLargestPlanet], planets[index]) < 0){
        		indexOfLargestPlanet = index;
        		largestPlanet = planets[indexOfLargestPlanet]; 
        	}
        }

        return largestPlanet;
    }
}