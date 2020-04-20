/**
 * basis fo creating the tree
 * @author Gage
 *
 * @param <T>
 */
public class TreeNode<T> {
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	/** creates a node with null children
	 * 
	 * @param dataNode data to be put into the node
	 */
	TreeNode(T dataNode){
		left = null;
		right = null;
		data = dataNode;
	}
	
	/**creates a copy of the node
	 * 
	 * @param node  the node to be copied
	 */
	TreeNode( TreeNode<T> node){
		left = node.left;
		right = node.right;
		data = node.data;
	}
	
	/**returns data of the node
	 * 
	 * @return data of node
	 */
	T getData() {
		return data;
	}
	

}
