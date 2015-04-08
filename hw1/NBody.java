/** File: NBody.java
*   author: S.K.
* 
*   An implementation of the universe
*   simulator.
*/
public class NBody {
	private static boolean DEBUG = false;

	/** generate a Planet from a row of the input data
	*
	*   @param: In (input file connected to the data table "filename")
	*   @return: Planet
	*/
	public static Planet getPlanet(In in){
		double xPosition = in.readDouble();
		double yPosition = in.readDouble();
		double xVelocity = in.readDouble();
		double yVelocity = in.readDouble();
		double mass       = in.readDouble();
		String name        = in.readString();

		return new Planet(xPosition, yPosition, xVelocity, yVelocity,
				     mass, name);
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		In input = new In(filename);
		int numPlanets = input.readInt();
		double uRadius = input.readDouble();

		/** DEBUG: Check reading of the input file,
		*                Reading of the number of planets,
		*                Reading of the universe radius.
		*/
		if (DEBUG) {
			System.out.println("Input file: " + filename);
			System.out.println("Number of Planets: " + numPlanets);
			System.out.println("Radius of the Universe: " + uRadius);
			System.out.println("Simulation time: " + T);
			System.out.println("Time step: " + dt);
		}

		// Populate the universe one planet at a time
		Planet planets[] = new Planet[numPlanets];
		for (int index = 0; index < numPlanets; index++){
			planets[index] = getPlanet(input);
		}

		if (DEBUG){
			for (int i = 0; i < numPlanets; i++) {
		    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                   	planets[i].x, planets[i].y, planets[i].xVelocity, planets[i].yVelocity, 
		                   	planets[i].mass, planets[i].img);
			}			
		}

		// Settings of the universe
		StdDraw.setScale(-uRadius, uRadius);
		StdDraw.picture(0, 0, "./images/starfield.jpg");
		for (Planet planet : planets){
			planet.draw();
		}

		// ************************************************************************************
		// ***************************** Running the animation ******************************
		for (double time = 0; time < T; time = time + dt){
			for (Planet planet : planets){
				// System.out.println("Working on planet: " + planet.img);
				planet.setNetForce(planets);
			}

			for (Planet planet : planets){
				// System.out.println("Updating the planet: " + planet.img);
				planet.update(dt);
			}

			StdDraw.picture(0, 0, "./images/starfield.jpg");
			for (Planet planet: planets){
				// System.out.println("Drawing planet: " + planet.img);
				planet.draw();
			}

			StdDraw.show(10);
			// System.out.println("Time iteration ends: " + T);
		}

		// *************************************************************************************
		// **************************** PRINT THE RESULTS ***********************************
		StdOut.printf("%d\n", numPlanets);
		StdOut.printf("%.2e\n", uRadius);
		for (int i = 0; i < numPlanets; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                   planets[i].x, planets[i].y, planets[i].xVelocity, planets[i].yVelocity, 
		                   planets[i].mass, planets[i].img);
		}
	}
}