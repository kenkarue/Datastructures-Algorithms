package DSDynamicProgramming;

/**
 * Find Path to X in N * M Matrix
 * Input:
 *     Array: N * M
 *     int: integer to find
 *  Output:
 *     Path to int
 */
public class NumberOfPathInMatrix {

    static int target = 5;
    static int validMatrixValuesPath = 1;
    static int inValidMatrixValuesPath = 0;

    public static void main(String[] args){
        int[][] matrix = new int[4][4];
        fillMatrix(matrix);

        System.out.println(numberOfPaths(matrix, 0, 0));
    }

    private static int numberOfPaths(int[][] matrix, int row, int column){
        if(!isValidSquare(matrix, row, column)){
            return 0;
        }
        if(matrix[row][column] == target){
            return 1;
        }
        return numberOfPaths(matrix, row + 1, column) + numberOfPaths(matrix, row, column + 1);
    }

    private static boolean isValidSquare(int[][] matrix, int row, int column){
        int r = matrix.length - 1;
        int c = matrix[0].length -1;
        if(row > r || column > c){
            return false;
        }
        return matrix[row][column] != inValidMatrixValuesPath;
    }

    private static void fillMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                matrix[i][j] = validMatrixValuesPath;
            }
        }
        // disable paths
        matrix[1][1] = inValidMatrixValuesPath;
        // matrix[2][2] = inValidMatrixValuesPath;
        // target
        matrix[3][3] = target;
    }
}
