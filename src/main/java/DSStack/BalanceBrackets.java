package DSStack;

import java.util.Stack;

/**
 * Input:
 *   String: "([])(){}(())()()"
 *
 * Output:
 *   Boolean
 */
public class BalanceBrackets {

    public static void main(String[] args){
        String str = "([])(){}(())()()";
        String str1 = ")[]}";
        System.out.println(balancedBrackets(str));
    }

    /**
     * Time: 0(n)
     * Space: 0(n)
     */
    private static boolean balancedBrackets(String str) {
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                s.push(c);
                continue;
            } else if(c == ')' || c == '}' || c == ']'){
                if(s.isEmpty()){
                    return false;
                }
                char st = s.pop();
                if(st == '('){
                    if(c != ')'){
                        return false;
                    }
                } else if(st == '['){
                    if(c != ']'){
                        return false;
                    }
                } else if(st == '{'){
                    if(c != '}'){
                        return false;
                    }
                }
            }
        }
        return s.isEmpty();
    }
}
