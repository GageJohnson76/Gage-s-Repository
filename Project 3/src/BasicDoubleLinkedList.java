import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * 
 * @author Gage
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements java.lang.Iterable<T>  {
	
	private Node front;
	private Node back;
	private int size = 0;
	
	public BasicDoubleLinkedList() {
		
	}
	
	/** inner class Node 
	 * 
	 * @author Gage
	 *
	 */
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
	 
	 /**  return the size of the list
	  * 
	  * @return the size of list
	  */
	 public int getSize() {
		 return size;
	 }
	 
	 /** adds an item to the back of the list
	  * 
	  * @param data the item being adding the list
	  * @return the reference to the data 
	  */
	 public  BasicDoubleLinkedList<T> addToEnd(T data) {
		 Node temp = new Node(data, null, back);
		 
		 if( back != null) 
			 back.next  = temp;
		 back = temp;
		 
		 if(front == null)
			 front= temp;
		
		 size++;
		return this;
		 
	 }
	 
	 /** adds an item to the front of the list
	  * 
	  * @param data the item being adding the list
	  * @return the reference to the data 
	  */
	 public  BasicDoubleLinkedList<T> addToFront(T data) {
		 Node temp = new Node (data, front, null);
		 if( front != null)
			 front.prev = temp;
		 front = temp;
		 if(back == null)
			 back = temp;
		 size++;
		return  this;
	 }
	 
	 /**gets the first item in the list
	  * 
	  * @return the first item in the list
	  */
	 public T getFirst() {
		 return front.data;
	 }
	 
	 /** gets the last item in the list 
	  * 
	  * @return the last item in the list 
	  */
	 public T getLast() {
		 return back.data;
	 }
	 
	
	
	 /**
	  *  gets the first item in the list then removes it
	  * @return the data element of the item
	  */
	 public T retrieveFirstElement() {
		 if(size == 0)
			 throw new NoSuchElementException();
		 Node temp = front;
		 front = front.next;
		 front.prev = null;
		 size--;
		 return temp.data;
		 
	 }
	 
	 /** removes a targeted item from the list
	  * 
	  * @param targetData the item that is desired to be removed
	  * @param c comparator
	  * @return the data element if available or null
	  */
	 public  BasicDoubleLinkedList<T> remove(T targetData, java.util.Comparator<T> c ){
		 
		 Node currentNode = front;
		 Node temp = null;
		 boolean found = false;
		 int i = 0;
		 while(found == false && i <= size) {
			 if(c.compare(currentNode.data, targetData) == 0) { 
				 found = true;
			 }
			 else {
				 temp = currentNode;
				 currentNode = currentNode.next;
				
			 }
			 i++;
		 }
		 if(found == true) {
			 if(c.compare(currentNode.data, front.data) == 0) {
				 front = front.next;
			 }
			 
			 if(c.compare(currentNode.data, back.data) == 0) {
				 back = back.prev;
			 }
			temp = currentNode.next;
			
			 return this;
		 }
			 
		 else
			return null;
			
	 }
	 
	 /**
	  *  gets the last item in the list then removes it
	  * @return the data element of the item
	  */
	 public T retrieveLastElement() {
		 if(size == 0)
			 throw new NoSuchElementException();
		 Node temp = back;
		 back = back.prev;
		 back.next = null;
		 size--;
		 return temp.data;
		 
	 }
	 
	 /**sends the list to an arraylist
	  * 
	  * @return an array list of items
	  */
	 public ArrayList<T> toArrayList(){
		 ArrayList<T> arrayList = new ArrayList<T>(size + 1);
		 Node currentNode = front;
		 for(int i  = 0 ; i <= size; i++) {
			 arrayList.add(currentNode.data);
			 currentNode = currentNode.next;
		 }
		 return arrayList;
		 
	 }
	 
	 
	 public ListIterator<T> iterator() throws NoSuchElementException, UnsupportedOperationException{ 
		 return new ListIterator<T>();
	 }
	 
	 
	 /** inner class iterator 
	  * 
	  * @author Gage
	  *
	  * @param <T> data type
	  */
	 public class ListIterator<T> implements Iterator{
		 
	
	 	private Node nextNode = front;
	 	private Node prevNode = back;
		
	 	/** determines if there is an item after this
	 	 * 
	 	 * @return true if there is another item after
	 	 */
	 	@Override
		public boolean hasNext() {
			return (nextNode.next != null);
		}

		/** advances the iterator forward
		 * 
		 * @return the data that the iterator arrived to
		 */
		@Override
		public T next() {
			if(hasNext()) {
			nextNode = nextNode.next;
			return (T) nextNode.data;
			}
			else
				throw new NoSuchElementException();
		}	
		
		/** determines if the is an item before it 
		 * 
		 * @return true if there is an item behind it
		 */
		public boolean hasPrevious() {
			return(prevNode.prev != null);
			
		}
		
		/** moves the iterator back
		 * 
		 * @return the postion where the iterator is
		 */
		public T previous() {
			if(hasPrevious()) {
			prevNode = prevNode.prev;
			return (T) prevNode.data;
			}
			else
				throw new NoSuchElementException();	
		}
		
		/** Unsupported
		 * 
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		/** Unsupported
		 * 
		 */
		public void add() {
			throw new UnsupportedOperationException();
		}
		
		/** Unsupported
		 * @return an error
		 */
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}
		
		/** Unsupported
		 * @return an error
		 */
		public int previousIndex(){
			throw new UnsupportedOperationException();
		}
	 
		
		/** Unsupported
		 * 
		 */
	 	public void set() {
			throw new UnsupportedOperationException();
		}
		
	 
	 }


	
}
