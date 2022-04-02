package DSArrays;

import java.util.HashMap;
import java.util.Map;

/**
 * First non-repeating character
 * Input:
 *   String: Kennedy
 * Output:
 *   Int: 0
 */
public class FirstNonRepeatingChar {

    public static void main(String[] args){
         String s = "Kennedy";
        //String s = "eroche";
        System.out.println(byHashMap(s));
        System.out.println(byArray(s));
    }

    /**
     * Time: 0(n)
     * Space: 0(n)
     */
    private static int byHashMap(String s){
        Map<Character, Integer> chars = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            chars.put(s.charAt(i), chars.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int j = 0; j < s.length(); j++){
            if(chars.get(s.charAt(j)) == 1){
                return j;
            }
        }
        return -1;
    }

    /**
     * Time: 0(n)
     * Space: 0(n)
     */
    private static int byArray(String s){
        s = s.toLowerCase();
        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++){
            chars[s.charAt(i) - 'a']++;
        }
        for(int j = 0; j < s.length(); j++){
            if(chars[s.charAt(j) - 'a'] == 1){
                return j;
            }
        }
        return -1;
    }
}
