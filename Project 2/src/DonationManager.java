/**adds specified object to either a queue or stack
 * 
 * @author gagej
 *
 */
public class DonationManager implements DonationManagerInterface{
	
	Container c = new Container();
	VolunteerLine vo = new VolunteerLine();
	RecipientLine rc = new RecipientLine();

	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 */
	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		if(c.stack.isFull())
			throw new ContainerException("The Container is Full");
		else {
			c.loadContainer(dPackage);
			return true;
				
		}
		
			
	}

	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		if(vo.queue.isFull())
			throw new VolunteerException("Volunteer Queue is full");
		else {
			vo.addNewVolunteer(v);
			return true;
		}
			
	}
	
	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		if(rc.queue.isFull())
			throw new RecipientException("Recipient Queue is full");
		else
			rc.addNewRecipient(r);
		return true;
			
	}

	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @throws VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throws ContainerExcpetion("Contain is empty") if the container is empty
	 * @throws RecipientException("Recipient Queue is empty") if there are no recipients
	 * 
	 */
	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		if(c.stack.isEmpty())
			throw new ContainerException("The Container is Empty");
		if(vo.queue.isEmpty())
			throw new VolunteerException("Volunteer queue is empty");
		if(rc.queue.isEmpty())
			throw new RecipientException("Recicpient queue is empty");
		c.removePackageFromContainer();
		rc.recipientTurn();
		vo.addNewVolunteer(vo.volunteerTurn());
	
		return 0;
	}

	/**
	 * Returns an array of DonationPackages
	 * @return an array of Donation Packages
	 */
	@Override
	public DonationPackage[] managerArrayPackage() {
		return c.toArrayPackage();
	}

	/**
	 * Returns an array of Volunteers
	 * @return an array of Volunteers
	 */
	@Override
	public Volunteer[] managerArrayVolunteer() {
		return vo.toArrayVolunteer();
	}

	/**
	 * Returns an array of Recipients
	 * @return an array of Recipients
	 */
	@Override
	public Recipient[] managerArrayRecipient() {
		return rc.toArrayRecipient();
	}
	
	/**
	 * should print would who is donating what to who
	 */
	public String toString() {
		return vo + " donated a " + c + " to" + rc;
	}
	

}
