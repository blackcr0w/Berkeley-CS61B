/** file: Array.java
*   author: S. Kojoian
*   purpose: Utility funcitons on arrays(dynamic)
*/
public class Array{
	/** Insert value VAL into the array ARRAY, at position POS.
	*   Assume POS is valid.
	*
	*   @param: array
	*   @param: val
	*   @pos:     pos
	*   @return: newArray
	*/
	public static int[] insert(int[] array, int val, int pos){
		// Case 1: the new array will require zeroe padding
		if (pos >= array.length){
			int[] paddedArray = new int[pos+1];
			System.arraycopy(array, 0, paddedArray, 0, array.length);
			// padding with zeros in case POS > array.length
			for (int i = array.length; i < pos; i++){
				paddedArray[i] = 0;
			}
			paddedArray[pos] = val;
			return paddedArray;
		// Case 2: No zeroe padding required
		} else {
			int[] extendedArray = new int[array.length+1];
			System.arraycopy(array, 0, extendedArray, 0, pos);
			extendedArray[pos] = val;
			System.arraycopy(array, pos, extendedArray, pos+1, array.length-pos);
			return extendedArray;
		}
	}
}