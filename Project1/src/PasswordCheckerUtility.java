import java.util.ArrayList;
/** Determines if a password is valid or not
 * 
 * @author gagej
 *
 */
public class PasswordCheckerUtility {
	
	
	public void PasswordCheckerUtility() {
		
	};
	
	/**Determines if the password is weak but , acceptable
	 * 
	 * @param password the password to be tested
	 * @return if true the password is weak if false the password is not weak
	 */
	public static boolean isWeakPassword(String password) {
		if(password.length() >= 6 && password.length() <= 9) {	
			return true;
		}
		else
			return false;
	}
	
	/**
	 * 
	 * @param password the password to be tested
	 * @return if the pass word is valid
	 * @throws LengthException if the password is less than 6 characters 
	 * @throws NoDigitException if the password has no digits in it
	 * @throws NoUpperAlphaException if the password has no upper case letters
	 * @throws NoLowerAlphaException if the password has no lower letters
	 * @throws InvalidSequenceException if the password has the same character in a row more than two times
	 */
	public static boolean isValidPassword(String password) throws LengthException,
    NoDigitException,
    NoUpperAlphaException,
    NoLowerAlphaException,
    InvalidSequenceException{
		
		
		
		if(password.length() < 6)
			throw new LengthException();
			
	
		if(hasUpper(password) == false)
			throw new NoUpperAlphaException();
		
		if(hasLower(password) == false)
			throw new  NoLowerAlphaException();
		
		if(hasDigit(password) == false)
			throw new NoDigitException();
		
		if(hasTriple(password) == false)
			throw new InvalidSequenceException();
		 
		return true;
		
	}
	
	
/**determines if password has an upper case
 * 	
 * @param password the password to be examined
 * @return true if password has an upper or false if it doesn't
 */
public static boolean hasUpper(String password) {
	int index = 0;
	char[] upperCaseCheck = password.toCharArray();
	 for(int i = 0; i < password.length(); i++) {
		 if(Character.isUpperCase(upperCaseCheck[i])) {
			 index++; 
		 }
	 }	
	if(index == 0) 
		return false;
		
	
	return true;
}

/** Determines if password has a lower case
 * 
 * @param password the password to be examined
 * @return true if password has a lower case or false if it doesn't
 */
public static boolean hasLower(String password) {
	int index = 0;
	char[] lowerCaseCheck = password.toCharArray();
	 for(int i = 0; i < password.length(); i++) {
		 if(Character.isLowerCase(lowerCaseCheck[i])) {
			 index++; 
		 }
	 }	
	if(index == 0) 
		return false;
		
	return true;
}
	
/** Determines if password has a digit
 * 
 * @param password the password to be examined
 * @return true if password has a digit or false if it doesn't
 */
public static boolean hasDigit(String password)  {
	int index = 0;
	char[] digitCheck = password.toCharArray();
	 for(int i = 0; i < password.length(); i++) {
		 if(Character.isDigit(digitCheck[i])) {
			 index++; 
		 }
	 }
	if(index == 0) 
		return false;
	
	return true;
}

/** Determines if password has 3 same characters in a row
 * 
 * @param password the password to be examined
 * @return true if password does not  or false if it does
 */
public static boolean hasTriple(String password) {
	
	
	char[] tripleCheck = password.toCharArray();
	 for(int i = 0; i < password.length() - 2; i++) {
		 if(tripleCheck[i] == tripleCheck[i + 1] && tripleCheck[i] == tripleCheck[i + 2])
			 return false;
		
	 }
	 
	 return true;
	
	
}


/** finds the invalid paasswords and adds it to an arraylist 
 * 
 * @param passwords arraylist of passwords given
 * @return an arraylist of the invalid passwords plus their exceptions
 */
public static ArrayList<String> invalidPasswords(ArrayList<String> passwords){
	ArrayList invalidPasswords = new ArrayList();
	
		
	
	for(int i = 0 ; i < passwords.size(); i++) {
		try {
		if(isValidPassword(passwords.get(i))== true);
				}
	
	catch(LengthException e) {
		invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
	}
	
	catch(NoUpperAlphaException e) {
		invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
	}
	
	catch(NoLowerAlphaException e) {
			invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
		}
	
	catch(NoDigitException e) {
			invalidPasswords.add(passwords.get(i) + " " +  e.getMessage());
		}
		
	catch(InvalidSequenceException e) {
			invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
		}
	catch(Exception e) {
		invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
	}
		
	
	
}
	return invalidPasswords;
	
}
	

}
