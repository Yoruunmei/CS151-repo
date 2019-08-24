import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Strings {
	
	public static String uniqueLetters(String str) {
		//System.out.println(str.length());
		int strLength = str.length();
		char[] s = str.toCharArray();
		ArrayList<Character> uniqueChars = new ArrayList<Character>();
		ArrayList<Character> notUn = new ArrayList<Character>();
		for (int i = 0; i < strLength; i++) {
	        if (!uniqueChars.contains(s[i])) { 
	        	uniqueChars.add(s[i]);
	        } else {
	        	notUn.add(s[i]);
	        }
	    }
		uniqueChars.removeAll(notUn);
		String uChars = uniqueChars.stream().map(Object::toString).collect(Collectors.joining(""));
		return uChars;
	}
	
}
