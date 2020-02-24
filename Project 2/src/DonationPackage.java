/**object container
 * 
 * @author gagej
 *
 */
public class DonationPackage {
	
	private double weight;
	private String desc;
	
	public DonationPackage(String desc,double weight ) {
		this.weight = weight;
		this.desc = desc;
	
	}

	
	public double getWeight() {
		return weight;
	}

	public String getDescription() {
		return desc;
	}
	
	public Boolean isHeavy() {
		if(getWeight() >= 20) {
			return true;
		}
		else
			return false;
	}

	/**
	 * displays description in GUI
	 */
	public String toString() {
		return getDescription();
	}
}
