import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ConcordanceDataManager implements ConcordanceDataManagerInterface{

	/**Creates a concordance based off a string
	 * 
	 * @param input string to be created into a concordance
	 * @return The concordance in alphabetical order
	 */
	@Override
	public ArrayList<String> createConcordanceArray(String input) {
		
		String[] lines =  input.toLowerCase().split("/n");
		ConcordanceDataStructure data = new ConcordanceDataStructure(input.split(" ").length);
		
		for(int line = 0; line < lines.length; line++) {
			for(String word : lines[line].split(" ")) {
				if(word.length() < 3 || word.equals("and") || word.equals("the")) {	
				}
				else {
					if(word.contains(".") || word.contains("!") || word.contains(",") || word.contains("?"))
						 word = word.replace(word.charAt(word.length() - 1),' ');
					
				 data.add(word, line + 1);
				}
			}
		
	
		}
		
		return data.showAll();
	}

	/**Creates a concordance based off a file
	 * 
	 * @param input  to be created into a concordance
	 * @param output The concordance in alphabetical order
	 * @return true if successful, false if not
	 * @throws FileNotFoundException if file cannot be found
	 */
	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
		try {
		int lineNum = 0;
		Scanner s = new Scanner(input);
		int wordNum = 0;
		while(s.hasNext()) {
			s.next();
			wordNum++;
		}
		s.close();
		Scanner sw = new Scanner(input);
		
		ConcordanceDataStructure data = new ConcordanceDataStructure(wordNum);
		
		
		while (sw.hasNextLine()) {
			lineNum++;
			
			String word = sw.nextLine();
			String[] words = word.split(" ");
			for(int i = 0; i < words.length; i++) {
			if( words[i].length() < 3 || words[i].equals("the") || words[i].equals("and")) {
			}
			else {
				if(words[i].contains(".") || words[i].contains("!") || words[i].contains(",") || words[i].contains("?"))
					words[i] = words[i].replace(words[i].charAt(words[i].length() - 1),' ');
			data.add(words[i], lineNum);
			}
			}
		
		}
		sw.close();
		PrintWriter pw = new PrintWriter(output);
		pw.print(data.showAll());
		pw.close();
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}

