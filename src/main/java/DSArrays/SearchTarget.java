package DSArrays;

/**
 * Input:
 *   array - sorted array
 *   target - value being searched
 *
 *  Output:
 *    int - index of the value
 */
public class SearchTarget {

    public static void main(String[] args){
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73 };
        int index = linearSearch(array, 12);
        int index1 =  binarySearch(array, 12, 0, 10);
        System.out.print(index +" - "+index1);
    }

    /**
     * Time: 0(n)
     * Space: 0(1)
     */
    private static int linearSearch(int[] array, int target){
        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }

    /**
     *  Time: 0(log n)
     *  Space: 0(1)
     */
    private static int binarySearch(int[] array, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        if(array[mid] == target){
            return mid;
        }
        if(array[mid] > target){
            return binarySearch(array, target, start, mid - 1);
        } else {
            return binarySearch(array, target, mid + 1, end);
        }
    }
}
