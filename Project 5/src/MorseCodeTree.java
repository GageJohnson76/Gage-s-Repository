import java.util.ArrayList;
/**
 * Creates and contains the Morse Code tree
 * @author Gage
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	 private TreeNode<String> root;
	
	 
	 /**creates the Morse code tree
	  * 
	  */
	 public MorseCodeTree() {
		 buildTree();
	 }
	 
	 
	 /**retrieves the root
	  * 
	  * @return the root of the tree
	  */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	
	/**sets the root of the tree
	 * 
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
			 root = new TreeNode<String>(newNode);
		
	}

	/**inserts items into tree
	 * @param code the morse code to traverse the tree
	 * @param letter the  data to be added to the tree
	 * @return the current tree
	 */
	@Override
	public MorseCodeTree insert(String code, String letter) {
		addNode(root, code, letter);
		return this;
	}

	/**adds the items into the tree
	 * 
	 * @param root the root of the tree
	 * @param code  the morse code to traverse the tree
	 * @param the data to be added to the tree
	 */
	@Override
	public void addNode(TreeNode<String> current, String code, String letter) {
		
		if(code.length() == 1) {
			if(code.equals(".")) 
				current.left = new TreeNode<String>(letter);
			if(code.equals("-")) {
				current.right = new TreeNode<String>(letter);
				
			}
			return;
			}
			
		
		if(code.length() > 1) {
			if(code.charAt(0) == '.') {	
				String newCode = code.substring(1);
				addNode(current.left, newCode, letter);
			}
			if(code.charAt(0) == '-') {
				String newCode = code.substring(1);
				addNode(current.right, newCode, letter);
			}
		}
		
		
	}

	/**returns the letter in the tree  with the same code
	 * 
	 * @param the code to retrieve the letter
	 * @return the letter
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**retrieves the letter from the tree
	 * 
	 * @param root root of the tree
	 * @param code morse code to retrieve the letter
	 * @return the letter
	 * 
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String letter = null;
		if(code.length() == 1) {
			if(code.equals(".")) { 
				 letter = root.left.data;		 
				
			}
		 if(code.equals("-")) { 
				 letter = root.right.data;
				
			}
		}
		
		 if(code.length() > 1) { 
			if(code.charAt(0) == '.') {
				String newCode = code.substring(1);
				 letter = fetchNode(root.left, newCode);
				 		}
			 if(code.charAt(0) == '-') {
				String newCode = code.substring(1);
				letter = fetchNode(root.right, newCode);
				
				}
		}
		return letter;
				
	}

	/**unsupported operation
	 * @throws UnsupportedOperationException
	 * 
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
		
	}

	/**unsupported operation
	 * @throws UnsupportedOperationException
	 * 
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
		
	}

	/**creates the tree
	 * 
	 */
	@Override
	public void buildTree() {
		TreeNode<String> newRoot = new TreeNode<String>("");
		setRoot(newRoot);
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/** creates an arraylist of the tree in LNR order
	 * @return the tree in an arraylist
	 * 
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> LNRoutput = new ArrayList<String>();
		LNRoutputTraversal(root, LNRoutput);
		return LNRoutput;
	}

	/**creates an arraylist of the tree in LNR order
	 * 
	 * @param root root of the tree
	 * @param list the arraylist to store the tree
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root == null)
			return;
		
		LNRoutputTraversal(root.left, list);
		
		list.add(root.data);
		
		LNRoutputTraversal(root.right, list);
		
		
		
	}

}
