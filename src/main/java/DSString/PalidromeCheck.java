package DSString;

/**
 * Input:
 *  String: "abcdcba"
 *
 * Output:
 *  boolean: true
 */
public class PalidromeCheck {

    public static void main(String[] args){
        String S = "abccba";
        System.out.println(solution1(S));
    }

    private static boolean solution1(String s) {
        int right = s.length() -1;
        int left = 0;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
