package DSDynamicProgramming;

import java.util.Arrays;

/**
 * Given an M * N find unique paths from 0,0 to M,N
 * Input:
 *    Array: M * N
 * Output:
 *    int: number of unique paths
 */
public class UniquePaths {

    public static void main(String[] args){
        int row = 3;
        int column = 7;
        int[][] memoize = new int[row][column];
        fillMemoize(memoize);

        System.out.println(recursionUniquePath(row - 1, column - 1, 0, 0));
        System.out.println(memoizeUniquePath(row - 1, column - 1, 0, 0, memoize));
    }

    /**
     * Time: 0(2^m * n)
     * Space: 0(m * n)
     */
    private static int recursionUniquePath(int row, int column, int r, int c){
        if(r > row || c > column){
            return 0;
        }
        if(row == r && column == c){
           return 1;
        }
        return recursionUniquePath(row, column, r + 1, c) + recursionUniquePath(row, column, r, c + 1);
    }

    /**
     * Time: 0(m * n)
     * Space: 0(m * n)
     */
    private static int memoizeUniquePath(int row, int column, int r, int c, int[][] memoize){
        if(r > row || c > column){
            return 0;
        }
        if(memoize[r][c] != Integer.MIN_VALUE){
            return memoize[r][c];
        }
        if(row == r && column == c){
            return 1;
        }
        memoize[r][c] =  memoizeUniquePath(row, column, r + 1, c, memoize) + memoizeUniquePath(row, column, r, c + 1,memoize);
        return memoize[r][c];
    }

    private static void fillMemoize(int[][] memoize) {
        Arrays.stream(memoize).forEach(a -> Arrays.fill(a, Integer.MIN_VALUE));
    }
}
