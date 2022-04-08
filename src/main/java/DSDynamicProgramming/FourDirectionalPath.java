package DSDynamicProgramming;

/**
 * Input:
 *    Array: 0 represents where to walk, 1 starting point, -2 obstacles
 * Output:
 *   int: number of paths to go through all the cells and reach the target
 */
public class FourDirectionalPath {


    static int start = -1;
    static int end = -1;
    static int noObstacles = 0;

    public static void main(String[] args) {
        int[][] grid = new int[3][4];
        fillMatrix(grid);
        getStartingPoint(grid);
        System.out.println(uniquePath(start, end, grid, noObstacles));
    }

    private static void getStartingPoint(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    start = i;
                    end = j;
                }
                if(grid[i][j] == 0){
                    noObstacles++;
                }
            }
        }
    }

    /**
     * Time: 0(m * n)
     * Space: 0(m * n)
     */
    private static int uniquePath(int m, int n, int[][] grid, int noneObstacles){
        if(grid[m][n] == 2){
            System.out.println("Obstacles :: "+noneObstacles);
            if(noneObstacles <= 0){
                return 1;
            }
            return 0;
        }
        grid[m][n] = 3;
        int top = 0, bottom = 0, right = 0, left = 0;
        if(m-1 >= 0 && grid[m-1][n] != 3 && grid[m-1][n] != -1){ // top
            top =  uniquePath(m - 1,n,grid, noneObstacles-1);
        }
        if(n-1 >= 0 && grid[m][n-1] != 3 && grid[m][n-1] != -1){ // left
            left =  uniquePath(m,n - 1,grid, noneObstacles-1);
        }
        if(m+1 < grid.length && grid[m + 1][n] != 3 && grid[m + 1][n] != -1){ // bottom
            bottom =  uniquePath(m + 1,n,grid, noneObstacles-1);
        }
        if(n+1 < grid[0].length && grid[m][n + 1] != 3 && grid[m][n + 1] != -1){ // right
            right =  uniquePath(m,n + 1,grid, noneObstacles-1);
        }

        grid[m][n] = 0;

        return top + bottom + right + left;
    }

    private static void fillMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                matrix[i][j] = 0;
            }
        }
        // starting point
        matrix[0][0] = 1;
        // obstacle paths
        matrix[2][3] = -1;
        // target
        matrix[2][2] = 2;
    }
}
