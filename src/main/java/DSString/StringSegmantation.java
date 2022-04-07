package DSString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Input:
 *    String: applepie
 *    Set   : apple, pear, pie, pier, pineapple
 * Output:
 *    boolean: applepie: true
 *    boolean: applepeer: false
 *
 *  Time: 0(n)
 *  Space: 0(1)
 */
public class StringSegmantation {

    public static void main(String[] args){
        Set<String> dictionary = new HashSet<>(Arrays.asList("apple","pear","pie","pier","pineapple"));
        String str = "applepie";
        String str1 = "applepeer";
        System.out.println(canBeSegmentated(str, dictionary));
        System.out.println(canBeSegmentated(str1, dictionary));
    }

    private static boolean canBeSegmentated(String str, Set<String> dictionary){
        for(int i = 1; i < str.length(); i++){
            if(dictionary.contains(str.substring(0,i)) && dictionary.contains(str.substring(i))){
                return true;
            }
        }
        return false;
    }
}
