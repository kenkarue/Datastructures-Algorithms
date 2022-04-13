package DSString;

import java.util.HashMap;
import java.util.Map;

/**
 * Input:
 *    String: clementisacap
 * Output:
 *    String: mentisac
 *
 *    Time: 0(n)
 *    Space: 0(n)
 */
public class LongestSubString {

    public static void main(String[] args){
        System.out.println(longestSubstringWithoutDuplication("abacacacaaabacaaaeaaafa"));
    }

    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        if(str.equals("") || str.length() == 0){
            return "";
        }
        String longestSub = "";
        String currentSubstring = "";
        Map<Character, Integer> charPosition = new HashMap<>();
        int startPoint = 0;
        for(int i = 0; i < str.length(); i++) {
            if(charPosition.containsKey(str.charAt(i)) && charPosition.get(str.charAt(i)) >= startPoint){
                startPoint = charPosition.get(str.charAt(i)) + 1;
            }
            currentSubstring = str.substring(startPoint, i + 1);
            charPosition.put(str.charAt(i), i);
            if(longestSub.length() < currentSubstring.length()){
                longestSub = currentSubstring;
            }
        }
        return longestSub;
    }
}
