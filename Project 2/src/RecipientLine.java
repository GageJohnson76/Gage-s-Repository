/**creates queue for recipients
 * 
 * @author gagej
 *
 */
public class RecipientLine implements RecipientLineInterface{
	private int size;
	MyQueue<Recipient> queue;
	
	public RecipientLine(int size) {
		this.size = size;
		queue = new MyQueue<Recipient>(size);
	}
	public RecipientLine() {
		size = 5;
		queue = new MyQueue<Recipient>(size);
	}
	
	 

	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 *return true if recipient is queued successfully
	 * @throws RecipientException("The Recipent Queue is Full") if queue is full
	 */
	@Override
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		try {
		queue.enqueue(rc);
		return true;
		}
		catch(RecipientException e) {
			throw new RecipientException("Recipient Queue isFull");
		}
		
	}

	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws RecipientException("The Recipient Queue is empty") if there is no Recipient in the line
	 */
	@Override
	public Recipient recipientTurn() throws RecipientException {
			
		try {
		Recipient r = (Recipient) queue.dequeue();
		return r;
		}
		catch(RecipientException e) {
			throw new RecipientException("Recipient Queue is Empty");
		}
	}

	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	@Override
	public boolean recipientLineEmpty() {
		return queue.isEmpty();
	}

	/**creates an array for recipients
	 * @return array of recipients
	 */
	@Override
	public Recipient[] toArrayRecipient() {
		Object[] temp = queue.toArray();
		Recipient[] array = new Recipient[temp.length];
		
		for(int i = 0; i < temp.length; i++) {
			array[i] = (Recipient) temp[i];
		}
		return array;
	}

}


