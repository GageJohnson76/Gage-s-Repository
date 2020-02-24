/**
 * 
 * @author gagej
 *
 * @param <T> Container
 */
public class MyStack<T>  implements StackInterface{
	
	private Object[] stack;
	private int size, bottom;
	
	public MyStack(int size) {
		
		bottom = 0;
		this.size = size;
		stack = new Object[size];
	}
	
	public MyStack() {
		
		bottom = 0;
		size = 5;
		stack = new Object[size];
	}
	

	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return(bottom == 0);
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		return(bottom == stack.length);
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() {
		if(bottom == 0)
			throw new ContainerException("Container is Empty");
		System.out.print(bottom);
		T front = (T)stack[bottom-1];
		for(int i = bottom; i > 0; i--)
			stack[i] = stack[i-1];
		
		stack[bottom] = null;
		bottom--;
		
		return front;
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(Object e) {
		
		if(bottom >= size)
			throw new ContainerException("Container is Full");
		
		stack[bottom] = (T) e;
		bottom++;
		
		if(stack[bottom -1] == e)
			return true;
		else
			return false;
	}

	/**
	 * Returns the elements of the Stack in an array, [0] is top of Stack, [1] is next in Stack, etc.
	 * @return an array of the Objects in the Stack
	 */
	@Override
	public Object[] toArray() {
		return stack;
	}

}
