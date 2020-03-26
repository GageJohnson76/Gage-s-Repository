

/**  A sorted List of BasicDoubleLinkedList
 * 
 * @author Gage
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	Node front;
	Node back;
	 java.util.Comparator<T> c;
	/** default constructor
	 * 
	 * @param comparator2
	 */
	public SortedDoubleLinkedList(java.util.Comparator<T> comparator2) {
		front = null;
		 back = null;
		c = comparator2;
	}
	
	
	 private class Node {
	        T data;
	        Node next;
	        Node prev;
	 
	        public Node(T data, Node next, Node prev) {
	            this.data = data;
	            this.next = next;
	            this.prev = prev;
	            }
	        
	 }
	
	/** if called throw UnsupportedOperationException
	 *  
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data)
            throws 	UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	/** if called throw UnsupportedOperationException
	 *  
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data)
            throws 	UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	/** adds the data in ascending order
	 * 
	 * @param data the item to be added
	 * @return reference to the object
	 */
	public SortedDoubleLinkedList<T> add(T data){
		Node node2 = new Node(data, null , null);
		if(front == null)
			front = node2;
		else {
			Node currentNode = front;
			Node temp = null;
			boolean placed = false;
			while(placed != true)
			if(c.compare( currentNode.data,  data) <= 0) {
				temp.next = node2;
				node2.next= currentNode;
				placed = true;
			if(c.compare( currentNode.data,  data) > 0) {
				temp = currentNode;
				currentNode = currentNode.next;
			}
			
		}
		
	}
		return this;
	}
    
	/** iterator
	 * 
	 * @return iterator starting at the head 
	 * 
	 */
	@Override
	public ListIterator<T> iterator(){
		return super.iterator();
		
	}
	
	/** removes selected item form the sorted list
	 * 
	 * @param data the item to be removed
	 * @param comparator the comparator 
	 */
	@Override
	public SortedDoubleLinkedList<T> remove(T data, java.util.Comparator<T> comparator){
		return  (SortedDoubleLinkedList<T>) super.remove(data, comparator);
		
	}
	
	
	
	

}
