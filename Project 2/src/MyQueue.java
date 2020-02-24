/**creates a queue
 * 
 * @author gagej
 *
 * @param <T> Volunteer or Recipient
 */
public class MyQueue<T> implements QueueInterface<T>{
	
	private Object[] queue;
	private int size , back;
	
	public MyQueue(int size) {
		back = 0;
		this.size = size;
		queue = new Object[size];
		
	}
	
	public MyQueue() {
		back = 0;
		size = 5;
		queue = new Object[size];
		
	}
		
	 
	/**
	 * Determines if the Queue is empty
	 * @return true if empty
	 */
	@Override
	public boolean isEmpty() {
		 return(back == 0);
	
	}

	/**Determines if the queue is full
	 * @return true if full
	 */
	@Override
	public boolean isFull() {
		return(back == queue.length );
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() {
		if(back == 0)
			throw new RecipientException("Recipient queue is Empty");
		
		T first = (T)queue[0];
		for(int i = 0; i < back; i++) {
			queue[i] = queue[i + 1];
		}
		
		queue[back] = null;
		back--;
		return first;
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(Object e) {
		if( back >= size)
			throw new RecipientException(" Recipient queue is full");
		
		queue[back] = (T)e;
		back++;
		
		if(queue[back -1] == e)
			return true;
		else
			return false;
		
	}

	/**
	 * Returns the elements of the Queue in an array, [0] is front of Queue, [1] is next in Queue, etc.
	 * @return an array of the Object elements in the Queue
	 */
	@Override
	public T[] toArray() {
		return (T[]) queue;
	}
	
	
	

}
