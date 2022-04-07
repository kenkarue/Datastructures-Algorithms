package DSString;

import java.util.Arrays;

/**
 * Input:
 *     char[]: H,e,l,l,o, ,w,o,r,l,d
 * Output:
 *     char[]: w,o,r,l,d, ,H,e,l,l,o
 *  Time: 0(n)
 *  Space: 0(1)
 */
public class ReverseWords {

    public static void main(String[] args){
        char[] s = getArray("Hello World");
        reverseWords(s);
        System.out.println(Arrays.toString(s));
    }

    private static char[] getArray(String t) {
        char[] s = new char[t.length()];
        int i = 0;
        for (; i < t.length(); ++i) {
            s[i] = t.charAt(i);
        }
        return s;
    }

    public static void reverseWords (char[] sentence) {
        swap(sentence, 0, sentence.length - 1);

        int reversePointer = 0;
        for(int i = 0; i < sentence.length; i++){
            if(Character.isWhitespace(sentence[i])){
                swap(sentence, reversePointer, i-1);
                reversePointer = i + 1;
            }
        }
        swap(sentence, reversePointer, sentence.length-1);
    }

    private static void swap(char[] sentence, int start, int end){
        while(start < end){
            char temp = sentence[start];
            sentence[start] = sentence[end];
            sentence[end] = temp;
            start++;
            end--;
        }
    }

}
