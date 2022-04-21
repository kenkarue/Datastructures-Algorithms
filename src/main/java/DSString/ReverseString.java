package DSString;

import java.util.Arrays;
import java.util.Stack;

/**
 * Input:
 *  String: hello
 * Output:
 *  String: olleh
 *
 */
public class ReverseString {

    public static void main(String[] args){
        String str = "hello";
        String str1 = "hello";
        System.out.println(solution(str));
        System.out.println(solution1(str1));
        System.out.println(solution2(str1));
    }

    private static String solution(String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder(); // mutable string
        for(int i = str.length() - 1; i >= 0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    private static String solution1(String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        char[] strArray = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            char temp = strArray[start];
            strArray[start] = strArray[end];
            strArray[end] = temp;
            start++;
            end--;
        }
        return Arrays.toString(strArray);
    }

    private static String solution2(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            s.push(str.charAt(i));
        }
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.toString();
    }
}
