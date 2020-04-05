import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**creates a hashtable with all the words from given text and sends it to Data element to create Concordance
 * 
 * @author Gage
 *
 */
public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
		
	private int length;
	private ArrayList<LinkedList<ConcordanceDataElement>> hashTable = new ArrayList<LinkedList<ConcordanceDataElement>>(length);
	
	/**default constructor
	 * 
	 * @param num estimated number of words in text
	 */
	public ConcordanceDataStructure(int num){
		int k = 0;
		int fixed = (int) (num/1.5);
		while(fixed > ((4*k) + 3) && ((4*k)+3) % 4 == 0) {
			 length = 4*k + 3;
			k++;
		}
		
	}

	
	/**constructor used for testing
	 * 
	 * @param term word to be tested
	 * @param size size of hashtable
	 */
	public ConcordanceDataStructure(String term, int size) {
		term = "testing";
		length = size;
		
	}

	/**returns the size of the hashtable
	 * 
	 * @return size of the hashtable
	 */
	@Override
	public int getTableSize() {
		return hashTable.size();	}

	/**returns the words at the specific index of the hashtable
	 * 
	 * @param index  index of hashtable
	 * @return words at the index of the hashtable
	 */
	@Override
	public ArrayList<String> getWords(int index) {
		ArrayList<String> words = new ArrayList<String>(length);
		for(int i = 0; i < hashTable.get(index).size(); i++) {
			words.add(hashTable.get(index).get(i).getWord());
		}
		return words;
	}

	/**returns an arrayList of the  linked list of line numbers at the specified index
	 * 
	 * @param index  index of hashtable
	 * @return an arrayList of the  linked list of line numbers at the specified index
	 */
	@Override
	public ArrayList<LinkedList<Integer>> getPageNumbers(int index) {
			ArrayList<LinkedList<Integer>> pageNums = new ArrayList<LinkedList<Integer>>(length);
			for(int i = 0; i < hashTable.get(index).size(); i++) {
				pageNums.add(hashTable.get(index).get(i).getList());
			}
			return pageNums;
	}

	/**add is to hashtable if it is not in already. if it is add line num to it linked list
	 * 
	 *@param word word to be added
	 *@param lineNum line number to be added
	 */
	@Override
	public void add(String word, int lineNum) {
		ConcordanceDataElement item = new ConcordanceDataElement(word);
		int index = item.hashCode() % length;
		
		if(hashTable.get(index) != null) {
			boolean found = false;
			int i = 0;
			
			while( found == false && i <= hashTable.get(index).size()) {
				if(item.hashCode() == hashTable.get(index).get(i).hashCode()) {
					hashTable.get(index).get(i).addPage(lineNum);
					found = true;
				}
				else
					i++;	
			}
		}
		else {
			hashTable.get(index).add(item);
			item.addPage(lineNum);
			
		}
	}

	/** shows all words with its line number in alphabetical order
	 * 
	 * @return the words and line number in alphabetical order
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> all = new ArrayList<String>(length);
		for(int i = 0; i <= hashTable.size(); i++) {
			for(int j = 0; j <= hashTable.get(i).size();j++) {
				all.add(hashTable.get(i).get(j).toString());
			}
		}
		Collections.sort(all);
		return all;
	}

}
