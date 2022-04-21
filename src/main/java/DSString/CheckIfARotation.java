package DSString;

/**
 * Input:
 *  String: ABCD and DABC
 *  String: ABCD and ADBC
 * Output:
 *  boolean: true
 *  boolean: false
 */
public class CheckIfARotation {

    public static void main(String[] args){
        String s1 = "ABCD";
        String s2 = null; // rotation 1

        System.out.println(solution(s1, s2));
        System.out.println(solution1(s1, s2));
    }

    /**
     * Time: 0(n)
     * Space: 0(1)
     *
     * Best for large String
     */
    private static boolean solution(String s1, String s2){
        if(s1 == null || s2 == null){
            return false;
        }
        if(s1.length() != s2.length()){
            return false;
        }
        int rotation = 0;
        for(int i = 0; i < s1.length(); i++){
            char str = s1.charAt(i);
            int indexOfStr2 = s2.indexOf(str);
            if(i == 0){
                rotation = Math.abs(indexOfStr2 - i);
                continue;
            }
            int calculatedIndex = ((i + rotation) > s1.length() - 1) ? (i + rotation) % s1.length() : (i + rotation);
            if(calculatedIndex != indexOfStr2){
                return false;
            }
        }
        return true;
    }

    /**
     * Time: 0(n)
     * Space: 0(1)
     */
    private static boolean solution1(String s1, String s2){
        if(s1 == null || s2 == null){
            return false;
        }
        if(s1.length() != s2.length()){
            return false;
        }
        String dupS1 = s1.concat(s1);
        return dupS1.contains(s2);
    }
}
