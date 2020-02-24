/**creates queue for volunteers
 * 
 * @author gagej
 *
 */
public class VolunteerLine implements VolunteerLineInterface{
	private  int size;
	MyQueue<Volunteer> queue;
	
	public VolunteerLine (int size) {
		this.size = size;
		queue = new MyQueue<Volunteer>(size);
	}
	
	public VolunteerLine () {
		size = 5;
		queue = new MyQueue<Volunteer>(size);
	}
	
	
	
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Queue is full") is queue is full
	 */
	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		try {
			queue.enqueue(v);
			return true;
		}
		catch(VolunteerException e) {
			throw new VolunteerException("Volunteer Queue is full");
		}
		
	}

	/**
	 * removes volunteer from the volunteer queue line
	 * @return Volunteer Object
	 * @throws VolunteerException("Volunteer queue is empty") if queue is empty
	 */
	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		try {
		Volunteer v = (Volunteer) queue.dequeue();
		return v;
		}
		catch(VolunteerException e) {
			throw new VolunteerException("Volunteer Queue is empty");
		}
	}

	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, true otherwise
	 */
	@Override
	public boolean volunteerLineEmpty() {
		return queue.isEmpty();
	}

	/**creates an array for volunteers
	 * @return and array of volunteers
	 */
	@Override
	public Volunteer[] toArrayVolunteer() {
		Object[] temp = queue.toArray();
		Volunteer[] array = new Volunteer[temp.length];
		
		for(int i = 0; i < temp.length; i++) {
			array[i] = (Volunteer) temp[i];
		}
		return array;
	}

}
