/**adds and removes items from container
 * 
 * @author gagej
 *
 */
public class Container implements ContainerInterface{
	private int size;
	MyStack<DonationPackage> stack;
	
	public Container(int size) {
		this.size = size;
		stack = new MyStack<DonationPackage>(size);
	}
	
	public Container() {
		size = 5;
		stack = new MyStack<DonationPackage>(size);
	}
	
	
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage a DonationPackage Object to be stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException("The Container is Full") if the containerSize = containerCount (stack is full)
	 */
	@Override
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		if(stack.isFull())
			throw new ContainerException("Container is full");
			stack.push(dPackage);
		return true;
		
	}

	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws ContainerException("The Container is Empty") if there is no package in the container
	 */
	@Override
	public DonationPackage removePackageFromContainer() throws ContainerException {
		if(stack.isEmpty())
			throw new ContainerException("The Container is Empty");
		
		DonationPackage p = (DonationPackage) stack.pop();
		return p;
	}

	/**creates an array of donation packages
	 * 
	 * @return an array of donation packages
	 */
	@Override
	public DonationPackage[] toArrayPackage() {
		Object[] temp = stack.toArray();
		DonationPackage[] array = new DonationPackage[temp.length];
		for(int i = 0; i < temp.length; i ++)
			array[i] = (DonationPackage) temp[i];
		return array;
	}

}
