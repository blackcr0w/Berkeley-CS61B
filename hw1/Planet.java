/** Planet.java
*   author: S. K.
*   
*   Implementation of the planet type
*/
public class Planet {
	public double x;
	public double y;
	public double xVelocity;
	public double yVelocity;
	public double mass;
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
}