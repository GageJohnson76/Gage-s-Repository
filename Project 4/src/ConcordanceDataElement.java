import java.util.LinkedList;
/** the data element for ConcordanceData Structure 
 * 
 * @author Gage
 *
 */
public class ConcordanceDataElement implements java.lang.Comparable<ConcordanceDataElement>{
	
	
	private LinkedList<Integer> pageNumbers = new LinkedList<Integer>();
	private String word;
	
	/**Constructor
	 * 
	 * @param word word to be added to the Concordance
	 */
	public ConcordanceDataElement(String word) {
		this.word = word;
		
	}
	

	/**compares toStrings to other DataElements
	 * 
	 * @param o the data element to compare to
	 * @return 1 if it is bigger than o, -1 if smaller and 0 if equal
	 */
	@Override
	public int compareTo(ConcordanceDataElement o) {
		int compareInt = this.toString().compareTo(o.toString());
		if(compareInt > 0)
			return 1;
		if(compareInt < 0)
			return -1;
		
		return 0;
	}
	
	/**returns hash code of the word
	 * 
	 * @return hash code
	 */
	public int hashCode() {
		return word.hashCode();
	}
	
	/**
	 * 
	 * @return linked list of line numbers for that word
	 */
	public java.util.LinkedList<java.lang.Integer> getList(){
		return pageNumbers;
		
	}
	
	/**
	 * 
	 * @return word to be added to concordance
	 */
	public String getWord() {
		return word;
	}
	
	/** adds line number to linked list if not already in it
	 * 
	 * @param lineNum line number to be added to linked list
	 */
	public void addPage(int lineNum) {
		boolean found = false;
		int i = 0;
		int n = pageNumbers.size();
		
		while( found == false &&  i <= n) {
			if(pageNumbers.get(i) == lineNum)
				found = true;
			else
				i++;
		}
		if(found == false)
		pageNumbers.addLast(lineNum);
			
	}
	
	/** returns the word and line numbers its on
	 * 
	 * @return the word and line numbers its on
	 */
	@Override
	public String toString() {
		String lineNums = null;
		
	for(int i = 0 ; i < pageNumbers.size(); i++) {
		lineNums +=  pageNumbers.get(i) + ", ";
	}
		
	return word + ": " + lineNums;
	}

}
