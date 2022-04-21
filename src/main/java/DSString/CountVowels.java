package DSString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Input:
 *   String: hello
 * Output:
 *   int: 2
 */
public class CountVowels {

    public static void main(String[] args){
        String str = "hello";
        System.out.println(countVowel(str));
    }

    /**
     * Time: 0(n)
     * Space: 0(n)
     */
    private static int countVowel(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int count = 0;
        String strLower = str.toLowerCase();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        for(int i = 0; i < strLower.length(); i++){
            if(vowels.contains(strLower.charAt(i)))
                count++;
        }
        return count;
    }
}
