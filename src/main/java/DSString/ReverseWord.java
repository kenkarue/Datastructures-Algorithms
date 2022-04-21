package DSString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Input:
 *  String: Hello World
 * Output:
 *  String: World Hello
 */
public class ReverseWord {

    public static void main(String[] args){
        String str = "   Hello   i     World   ";
        System.out.println(solution(str));
        System.out.println(solution1(str));
    }

    private static String solution(String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        String[] words = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i]);
            if(i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static String solution1(String str){
        String[] words = str.split("\\s+");
        List<String> word = Arrays.asList(words);
        Collections.reverse(word);
        return String.join(" ", word);
    }
}
