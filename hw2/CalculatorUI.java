/** CalculatorUI.java
*
*   author: Sergey Kojoian
*   An implementation of a command line
*   user interface for the calculator
*/
public class CalculatorUI{
	public static void main(String[] args){
		String[] tokens;
		int val1, val2;
		int result;

		while (true){
			System.out.print("> ");
			tokens = StdIn.readLine().split(" ");
			// Integer.valueOf(String value)
			// is used to get the numeric value.
			// Assumes the structure of the expression
			val1 = Integer.valueOf(tokens[0]);
			val2 = Integer.valueOf(tokens[2]);

			if (tokens[1].equals("+")){
				result = val1 + val2;
			} else if (tokens[1].equals("-")){
				result = val1 - val2;
			} else{
				result = val1 * val2;
			} 
			System.out.println(result);
		}
	}
}