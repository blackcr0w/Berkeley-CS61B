/** CalculatorUI.java
*
*   author: Sergey Kojoian
*   An implementation of a command line
*   user interface for the calculator
*/
public class CalculatorUI{
	public static Calculator calc = new Calculator();

	public static void main(String[] args){
		String[] tokens;
		String equation;
		int val1, val2;
		int result;

		while (true){
			System.out.print("> ");
			equation =  StdIn.readLine();
			tokens = equation.split(" ");
			if (tokens[0].equals("history")){
				recallHistory(tokens);
				continue;
			} else if (tokens[0].equals("dump")){
				calc.printAllHistory();
				continue;
			} else if (tokens[0].equals("clear") && tokens.length == 1){
				calc.clearHistory();
				continue;
			} else if (tokens[0].equals("undo") && tokens.length == 1){
				calc.undoEquation();
				continue;
			}
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
			calc.saveEquation(equation, result);
			System.out.println(result);
		}
	}

	public static void recallHistory(String[] tokens){
		if (tokens.length == 1){
			calc.printAllHistory();
		} else {
			int n = Integer.valueOf(tokens[1]);
			calc.printHistory(n);
		}	
	}
}