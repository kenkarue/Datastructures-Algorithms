package DSString;

import java.util.HashSet;
import java.util.Set;

/**
 * Input:
 *   String: Helloooo
 * Output:
 *   String: Helo
 */
public class RemoveDuplicates {

    public static void main(String[] args){
        String str = "Hellooooo       is      okay";
        System.out.println(solution(str));
    }

    /**
     * Time: 0(n)
     * Space: 0(n)
     */
    private static String solution(String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        Set<Character> chars = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(!chars.contains(str.charAt(i))){
                sb.append(str.charAt(i));
                chars.add(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
