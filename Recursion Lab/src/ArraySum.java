
public class ArraySum {
	int sum = 0;
	
	
	public int sumOfArray(Integer array[], int first, int last) {
		
		if(first <= last) {
		sum += array[first];
		sumOfArray(array, (first + 1), last);
		}

		return sum;
	}
}
