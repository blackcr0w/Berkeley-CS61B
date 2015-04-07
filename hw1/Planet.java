/** Planet.java
*   author: S. K.
*   
*   Implementation of the planet type
*/
public class Planet {
	public static final double G = 6.67E-11;  // Newtons' gravitational constant
	public double x;
	public double y;
	public double xVelocity;
	public double yVelocity;
	public double mass;
	public double xNetForce;
	public double yNetForce;
	public double xAccel;
	public double yAccel;
	public String img;

	public Planet(double x, double y, double xVelocity, double yVelocity, 
		         double mass, String img){
		this.x = x;
		this.y = y;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.mass = mass;
		this.img = img;
	}

	/** Returns the distance between the current planet and 
	*   the input planet
	*
	*   @param: Planet
	*   @return: double
	*/
	public double calcDistance(Planet planet){
		double dx = planet.x - this.x;
		double dy = planet.y - this.y;
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}

	/** Returns the pairwise force between the two planets
	*   Computed according Newton's Universal Law of Gravitation
	*
	*   @param: Planet
	*   @return: double
	*/
	public double calcPairwiseForce(Planet planet){
		return (G * this.mass * planet.mass) / Math.pow(calcDistance(planet), 2); 
	}

	/** Returns the x-component of the PairwiseForce vector
	*
	*   @param: Planet
	*   @return: double
	*/
	public double calcPairwiseForceX(Planet planet){
		double dx = planet.x - this.x;
		return calcPairwiseForce(planet) * dx / calcDistance(planet);
	}

	/** Returns the y-component of the PairwiseForce vector
	*
	*   @param: Planet
	*   @return: double
	*/
	public double calcPairwiseForceY(Planet planet){
		double dy = planet.y - this.y;
		return calcPairwiseForce(planet) * dy / calcDistance(planet);
	}

	/** Sets the next force exerted on the current planet by
	*   all the input planets
	*
	*   @param: array of Planets
	*   @return: void
	*/
	public void  setNetForce(Planet[] planets){
		for (Planet planet : planets){
			if (this == planet){
				continue;
			} else {
				xNetForce += this.calcPairwiseForceX(planet);
				yNetForce += this.calcPairwiseForceY(planet); 
			}
		}
	}

	/** Draws the planet using the Princeton Standard Library
	*
	*   @param: none
	*   @return: void
	*/
	public void draw(){
		StdDraw.picture(x, y, "./images/"+img);
	}

	/** Performs time step iterations with dt marking the number
	*   of time steps.
	*   
	*   @param: double
	*   @return: void
	*/
	public void update(double dt){
		xAccel = xNetForce / mass;
		yAccel = yNetForce / mass;

		xVelocity = xVelocity + dt * xAccel;
		yVelocity = yVelocity + dt * yAccel;

		x = x + dt * xVelocity;
		y = y + dt * yVelocity;
	}
}