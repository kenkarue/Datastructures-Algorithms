package LeetCode;

/**
 * Key with largest duration releaseTimes[i] - releaseTimes[i - 1]
 * in lexographical order if two keys share same releasetimes
 */
public class SlowestKey {

    public static void main(String[] args){
        int[] releaseTimes = {9,29,49,50};
        String keys = "cbcd";
        System.out.println(slowestKey(releaseTimes, keys));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char longest = keysPressed.charAt(0);
        int time = releaseTimes[0] - 0;
        for(int i = 1; i < releaseTimes.length; i++){
            int tempTime = releaseTimes[i] - releaseTimes[i - 1];
            if(tempTime > time){
                longest = keysPressed.charAt(i);
                time = tempTime;
            }
            if(tempTime == time && keysPressed.charAt(i) > longest){
                longest = keysPressed.charAt(i);
            }
        }
        return longest;
    }
}
