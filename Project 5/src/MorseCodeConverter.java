import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**converts the morse code into English
 * 
 * @author Gage
 *
 */
public class MorseCodeConverter {

	
	
	/** converts the morse code string into english
	 * 
	 * @param code the morse code to be converted
	 * @return the string in English
	 */
	public static String convertToEnglish(String code) {
		MorseCodeTree tree = new MorseCodeTree();
		String english = "";
		String[] words = code.split("/ ");
		
		for(int i = 0; i < words.length; i++ ) {
			String[] letters = words[i].split(" ");
			
			for(int j = 0; j < letters.length; j++) {
				english += tree.fetch(letters[j]);
			}
			
			english += " ";
		}
		english= english.substring(0, english.length() - 1);
		return english;
	}
	
	/**converts the file into english
	 * 
	 * @param codeFile the file in morse code
	 * @return the file in english
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		MorseCodeTree tree2 = new MorseCodeTree();
		String english = "";
		String whole = "";
		Scanner s = new Scanner(codeFile);
			while(s.hasNextLine()) {
				whole += s.nextLine();
			}
		s.close();
		
	String[] words = whole.split("/ ");
		
		for(int i = 0; i < words.length; i++ ) {
			String[] letters = words[i].split(" ");
			
			for(int j = 0; j < letters.length; j++) {
				english += tree2.fetch(letters[j]);
			}
			english += " ";
		}
		english = english.substring(0, english.length() - 1);
		return english;
	}
	
	/**  puts the tree in LNR order into a string
	 * 
	 * @return the tree in LNR order
	 */
	public static String printTree() {
		MorseCodeTree tree3 = new MorseCodeTree();
		ArrayList<String> treeArray = new ArrayList<String>();
		String printedTree = "";
		treeArray = tree3.toArrayList();
		 
		 for(int i = 0; i< treeArray.size(); i++) {
			 printedTree += treeArray.get(i) + " ";
		 }
		 
		 return printedTree;
	}
	
	
}
