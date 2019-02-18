package String;

public class longestCommonPrefix {
	
    public String LongestCommonPrefix(String[] strs) {
        
        if(strs.length == 0) return "";
        //find string of least length
        int idxOfMinLength = 0, minLength = Integer.MAX_VALUE;
        for(int i=0; i<strs.length; i++) {
            int lenOfWord = strs[i].length();
            if(lenOfWord == 0) return "";
            if(lenOfWord < minLength)  {
                idxOfMinLength = i;
                minLength = strs[i].length();
            }
        }
        String smallestString = strs[idxOfMinLength];
        // System.out.println("small word: " + smallestString);
        int lenOfMinString = smallestString.length();
        
        while(lenOfMinString > 0) {
            int count = 0;
            for(String word: strs) {
                String subStringOfEachWord = word.substring(0, lenOfMinString);
                String subStringOfSmallestString = smallestString.substring(0, lenOfMinString);
                // System.out.println("substring of small: " + subStringOfSmallestString + 
                                  // " substring of target: " + subStringOfEachWord);
                if(!subStringOfEachWord.equals(subStringOfSmallestString)) break;
                else count++;
            }
            if(count == strs.length) {
                return smallestString.substring(0, lenOfMinString);
            }
            lenOfMinString--;
        }        
        return "";
    }

}
