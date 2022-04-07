package DSDynamicProgramming;

/**
 * Fibonacci:: 1,1,2,3,5,8,13,21,34,55.....
 * Input:
 *    int: n fibonacci number
 * Output:
 *   int: the fibonacci number of n
 */
public class Fibonacci {

    public static void main(String[] args){
        // scenario 1
        int n = 20;
//        System.out.println(fibWithoutMemoization(n));
//
        // scenario 2
        int[] memoize = new int[n+1];
        for(int i = 0; i <= n; i++){
            memoize[i] = Integer.MIN_VALUE;
        }
       System.out.println(fibWithMemoization(n, memoize));

        // scenario 3
        System.out.println(bottomUp(n));
    }

    /**
     * Time: 0(2^n)
     * Space: 0(n)
     */
    private static int fibWithoutMemoization(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fibWithoutMemoization(n - 1) + fibWithoutMemoization(n - 2);
    }

    /**
     * Time: 0(n)
     * Space: 0(n)
     */
    private static int fibWithMemoization(int n, int[] memoize){
        if(memoize[n] != Integer.MIN_VALUE){
            return memoize[n];
        }
        if(n == 1 || n == 2){
            return 1;
        }
        memoize[n] = fibWithMemoization(n-1, memoize) + fibWithMemoization(n-2, memoize);
        return memoize[n];
    }

    /**
     * Time: 0(n)
     * Space: 0(n)
     */
    private static int bottomUp(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        int[] bottomUp = new int[n + 1];
        bottomUp[1] = 1;
        bottomUp[2] = 1;
        int start = 3;
        while(start <= n){
            bottomUp[start] = bottomUp[start - 1] + bottomUp[start - 2];
            start++;
        }
        return bottomUp[n];
    }
}
