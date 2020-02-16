

public class LinkedQueue<Customer> implements QueueInterface<Customer> {
	private Node firstNode;
	private Node lastNode;
	
	
	public LinkedQueue() {
		
		firstNode = null;
		lastNode = null;
	}
	

	

	@Override
	public void enqueue(Customer newEntry) {
		Node newNode = new Node(newEntry, null);
		
	if(isEmpty())
		firstNode = newNode;
	else {
		lastNode.setNext(newNode);
	
	}
	
	lastNode = newNode;

	}

	@Override
	public Customer dequeue() {
		Customer front;
		Node previous;
		if(isEmpty())
			throw new EmptyQueueException();
			
		front = getFront();
		previous = firstNode;
		firstNode = firstNode.getNext();
		previous.setData(null);
		
	
		
		return front;
			
			
		
	}

	@Override
	public Customer getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return firstNode.getData();
	}

	@Override
	public boolean isEmpty()
	{
		return (firstNode == null) && (lastNode == null);
	}
	

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		
	}
	
	private class Node{
		private Customer data;
		private Node next;
		
	private Node(Customer dataPortion) {
		this(dataPortion, null);
		}
	
	private Node(Customer dataPortion, Node nextNode) {
		data = dataPortion;
		next = nextNode;
	}

	public Customer getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(Customer data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
		}

}
