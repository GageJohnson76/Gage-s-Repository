
public class fibonacci {
	
	public int fibonacciDynamic(int f) {
		int fibArray[] = new int[f+2];
		fibArray[0] = 0;
		fibArray[1] = 1;
		
		for(int i = 2; i <= f ; i++) {
			fibArray[i] = fibArray[i-1] + fibArray[i-2];
		}
		return fibArray[f];
	}

}
