package DSString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Input:
 *    String Array: containing words
 *  Output:
 *    char Array: characters need to form all the words
 *
 *   Time: 0(n * l) -> Refers to the length of the words
 *   Space: 0(n) -> Hashmap inclusion
 */
public class MinCharForWords {

    public static void main(String[] args){
        String[] words = new String[]{"this", "that", "did", "deed", "them!", "a"};
        System.out.println(Arrays.toString(minimumCharactersForWords(words)));

    }

    public static char[] minimumCharactersForWords(String[] words) {
        // Write your code here.
        int count = 0;
        Map<Character, Integer> occurrence = new HashMap<>();
        for(String word: words){
            char[] wordArr = word.toCharArray();
            Map<Character, Integer> perWord = new HashMap<>();
            for(char c: wordArr){
                perWord.put(c, perWord.getOrDefault(c, 0) + 1);
                if(!occurrence.containsKey(c)){
                    count++;
                    occurrence.put(c, perWord.get(c));
                }
                if(occurrence.get(c) < perWord.get(c)){
                    count++;
                    occurrence.put(c, perWord.get(c));
                }
            }
        }
        char[] wordChar = new char[count];
        for(Map.Entry<Character, Integer> c : occurrence.entrySet()){
            char key = c.getKey();
            int noOfTimes = c.getValue();
            while(noOfTimes > 0){
                count--;
                noOfTimes--;
                wordChar[count] = key;
            }
        }
        return wordChar;
    }
}
