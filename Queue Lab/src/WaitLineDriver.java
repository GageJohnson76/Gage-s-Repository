
public class WaitLineDriver {

	public static void main(String[] args) {
	WaitLine line;
	
	line = new WaitLine();
	
	line.simulate(20, 0.5, 5);
	
	line.displayResults();

	}

}
