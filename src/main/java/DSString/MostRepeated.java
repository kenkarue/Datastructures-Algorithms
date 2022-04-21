package DSString;

import java.util.HashMap;
import java.util.Map;

/**
 * Input:
 *   String: Hellllooooo
 * Output:
 *   char: o
 */
public class MostRepeated {

    public static void main(String[] args){
        String str = "Hellllllllooooolllllooooo";
        System.out.println(solution(str));
        System.out.println(solution1(str));
    }

    /**
     * Time: 0(n)
     * Space: 0(n)
     */
    private static Character solution(String str){
        Map<Character, Integer> frequencies = new HashMap<>();
        char mostRepeated = ' ';
        int max = -1;
        for(int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            frequencies.put(currentChar, frequencies.getOrDefault(currentChar, 0) + 1);
            if(frequencies.get(currentChar) > max){
                mostRepeated = currentChar;
                max = frequencies.get(currentChar);
            }
        }
        return mostRepeated;
    }

    private static Character solution1(String str){
        String strLowerCase = str.toLowerCase();
        int[] frequencies = new int[26];
        char mostRepeated = ' ';
        int max = -1;
        for(int i = 0; i < str.length(); i++){
            int value = (strLowerCase.charAt(i) + 'a') % 26;
            frequencies[value]++;
            if(frequencies[value] > max){
                max = frequencies[value];
                mostRepeated = strLowerCase.charAt(i);
            }
        }
        return mostRepeated;
    }
}
