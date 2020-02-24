/**volunteer object 
 * 
 * @author gagej
 *
 */
public class Volunteer {
	
	private  String name;
	
	public Volunteer( String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * display name to GUI
	 */
	public String toString() {
		String name = getName();
		return name;
	}

}
