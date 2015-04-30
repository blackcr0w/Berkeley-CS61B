import java.util.Arrays;

public class starCounter {
	public static String[] starCount(String args[]){
		if (args == null || args.length == 0){
			return null;
		} else {
			String[] newArray = new String[args.length];
			int newArrayIndex = 0;
			int countStars = 0;

			for (int i = 0; i < args.length; i++){
				if (!args[i].equals("star")){
					newArray[newArrayIndex] = args[i];
					newArrayIndex += 1;
				} else {
					countStars += 1;
				}
			}

			if ((countStars & 0x1) == 0){
				return args;
			} else {
				return Arrays.copyOf(newArray, args.length);
			}			
		}


	}

	public static void main(String[] args){

	}
}