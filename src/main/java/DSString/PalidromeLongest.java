package DSString;

/**
 * Input::
 *   String --> bananas
 *   String --> baab
 *   String --> babab
 *   String --> b
 *   String --> ba
 * Output::
 *   String --> anana
 */
public class PalidromeLongest {

    public static void main(String[] args){
        String S = "ba";
        System.out.println(solution1(S));
    }

    /**
     * Have a sliding window from mid to left and right
     * Time --> 0(n*2)
     * Space --> 0(1)
     */
    private static String solution1(String s) {
        int max = 0;
        String p = "";
        for(int i = 0; i < s.length(); i++){
            String len = isPalidrome(s, i ,i);
            String len2 = isPalidrome(s, i, i + 1);
            if(len.length() > max){
                p = len;
                max = len.length();
            }
            if(len2.length() > max){
                p = len2;
                max = len2.length();
            }
        }
        return p;
    }

    private static String isPalidrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
