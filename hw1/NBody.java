/** File: NBody.java
*   author: S.K.
* 
*   An implementation of the universe
*   simulator.
*/
public class NBody {
	private static boolean DEBUG = true;

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
		double T = Integer.parseInt(args[0]);
		double dt = Integer.parseInt(args[1]);
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
		}
	}
}