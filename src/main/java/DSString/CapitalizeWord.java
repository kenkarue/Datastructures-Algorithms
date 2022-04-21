package DSString;

import java.util.Locale;

/**
 * Input:
 *   String: trees are beautiful
 *   String:   trees    are        beautiful
 *
 * Output:
 *   String: Trees Are Beautiful
 *   String: Trees Are Beautiful
 */
public class CapitalizeWord {

    public static void main(String[] args){
        String str = "    trees    are        beautiful   ";
        System.out.println(solution(str));
        System.out.println(solution1(str));
    }

    /**
     * Time: 0(n)
     * Space: 0(1)
     */
    private static String solution(String str){
        if(str == null || str.length() == 0 || str.trim().isEmpty()){
            return "";
        }
        String[] strs = str.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++){
            String current = strs[i];
            sb.append(current.substring(0, 1).toUpperCase()).append(current.substring(1).toLowerCase());
            if(i != strs.length - 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static String solution1(String str){
        if(str == null || str.length() == 0 || str.trim().isEmpty()){
            return "";
        }
        String[] words = str.trim().replaceAll(" +"," ").split("\\s+");
        for(int i = 0; i < words.length; i++){
            words[i] = words[i].substring(0, 1).toUpperCase().concat(words[i].substring(1).toLowerCase());
        }
        return String.join(" ", words);
    }
}
