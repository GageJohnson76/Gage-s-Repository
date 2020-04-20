/** throws an exception for an unsupported method
 * 
 * @author Gage
 *
 */
public class UnsupportedOperationException extends RuntimeException{
	
	/**when exception is thrown  displys message
	 * 
	 */
	public UnsupportedOperationException() {
		super("Unsupported Operation called");
	}

}
