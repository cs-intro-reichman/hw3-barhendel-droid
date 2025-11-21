
public class Anagram {
    public static void main(String args[]) {

        System.out.println(isAnagram("silent","listen"));  
        System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); 
        System.out.println(isAnagram("Madam Curie","Radium came"));
        System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); 

   
        System.out.println(preProcess("What? No way!!!"));
        

        System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
        

        String str = "1234567";
        Boolean pass = true;

        for (int i = 0; i < 10; i++) {
            String randomAnagram = randomAnagram(str);
            System.out.println(randomAnagram);
            pass = pass && isAnagram(str, randomAnagram);
            if (!pass) break;
        }
        System.out.println(pass ? "test passed" : "test Failed");
    }  

    public static boolean isAnagram(String str1, String str2) {

        String s1 = preProcess(str1);
        String s2 = preProcess(str2);
        

        String s1Clean = "";
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != ' ') s1Clean += s1.charAt(i);
        }
        
        String s2Clean = "";
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) != ' ') s2Clean += s2.charAt(i);
        }


        if (s1Clean.length() != s2Clean.length()) {
            return false;
        }


        for (int i = 0; i < s1Clean.length(); i++) {
            char ch = s1Clean.charAt(i);
            int index = s2Clean.indexOf(ch);
            
            if (index == -1) {
                return false;
            }
            
      
            s2Clean = s2Clean.substring(0, index) + s2Clean.substring(index + 1);
        }

        return true;
    }
   
    public static String preProcess(String str) {
        String filtered = "";
        String lowerStr = str.toLowerCase();
        
  
        String allowed = "abcdefghijklmnopqrstuvwxyz "; 

        for (int i = 0; i < lowerStr.length(); i++) {
            char ch = lowerStr.charAt(i);
            if (allowed.indexOf(ch) != -1) {
                filtered += ch;
            }
        }

        return filtered;
    } 
 
    public static String randomAnagram(String str) {
        String original = str;
        String newStr = "";

      
        while (original.length() > 0) {
       
            int randomIndex = (int)(Math.random() * original.length());
            
         
            newStr += original.charAt(randomIndex);
            
       
            original = original.substring(0, randomIndex) + original.substring(randomIndex + 1);
        }

        return newStr;
    }
}