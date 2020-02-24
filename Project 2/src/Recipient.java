/**Recipient object
 * 
 * @author gagej
 *
 */
public class Recipient {
	private String name;
	
	public Recipient(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * display name in GUI
	 */
	public String toString() {
		return getName();
	}

}
