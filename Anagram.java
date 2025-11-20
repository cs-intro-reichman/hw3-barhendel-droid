/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String filteredStr1 = preProcess(str1); // ללחיץ
		String filteredStr2 = preProcess(str2); // לחצלי

		if (filteredStr1.length() != filteredStr2.length()) {
			return false;
		}

		for (int i = 0; i < filteredStr1.length(); i++) {
			char ch = filteredStr1.charAt(i);
			if (filteredStr2.indexOf(ch) != -1) {
				int j = filteredStr2.indexOf(ch);
				String subStr1 = str2.substring(0, j);
				String subStr2 = str2.substring(j + 1);
				filteredStr2 = subStr1 + subStr2;
			} else {
				return false;
			}
		}

		return filteredStr2.length() == 0;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String abc = "abcdefghijklmnopqrstuvwxyz";
		String filtered = "";

		String lowerStr = str.toLowerCase();

		for (int i = 0; i < lowerStr.length(); i++) {
			char ch = lowerStr.charAt(i);
			if (abc.indexOf(ch) != -1) {
				filtered += ch;
			}
		}

		return filtered;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newStr = "";

		for (int i = 0; i < str.length(); i++){
			int j =  (int)(Math.random() * str.length());
			char ch = str.charAt(j);
			newStr += ch;

			String subStr1 = str.substring(0, j);
			String subStr2 = str.substring(j + 1);
			str = subStr1 + subStr2;
		}

		return newStr;
	}
}
