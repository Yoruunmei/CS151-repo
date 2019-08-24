import java.util.Set;
import java.util.TreeSet;

public class Encoding {
	
	public static Set<String> morseCodes(int m, int n) {
		Set<String> result = new TreeSet<>();
		String morse = "";
		result = recursionMorse(m, n, morse);
		return result;
		
	}
	
	private static Set<String> recursionMorse(int m, int n, String s) {
		Set<String> result = new TreeSet<>();
		String morse = "";
		for (int i = 0; i<m; i++) {
			morse = morse + ".";
		}
		for (int j = 0; j<n; j++) {
			morse = morse + "-";
		}
		
		//base cases
		if (m == 0 && n == 0) {
			result.add(s);
			return result;
		} 
		
			String perm = "";
			for (int i = 0; i < morse.length(); i++) {
				String ch = morse.charAt(i) + "";
				String temp = morse.substring(0, i) + morse.substring(i+1);
				
				int mm = 0;
				int nn = 0;
				for (int j = 0; j < temp.length(); j++) {
					if (temp.charAt(j) == '-') {
						nn++;
					} else {
						mm++;
					}
				}
				String t1 = recursionMorse(mm, nn, ch+s).toString().replace("[", "").replace("]", "");

				result.add(t1);
			
			}
		return result;
	}
}
