package DSString;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Input:
 *   String: 192168018
 *  Output:
 *   List: of all available IPs [19.216.80.18, 192.16.80.18, 192.168.0.18]
 *
 *   Time: 0(1)
 *   Space: 0(1)
 */
public class ValidIPAddress {

    public static void main(String[] args){
        String str = "192168018";
        System.out.println(validIPAddresses(str));
    }

    public static ArrayList<String> validIPAddresses(String string) {
        // Write your code here.
        ArrayList<String> ips = new ArrayList<>();
        for(int i = 1; i < Math.min((int)string.length(), 4); i++){    // 0(1)
            String[] ipAddressParts = new String[]{"","","",""};

            ipAddressParts[0] = string.substring(0, i);
            if(!isValidPart(ipAddressParts[0])) { //  1  --> 12
                continue;
            }

            for(int j = i + 1; j < i + Math.min((int)string.length() - i, 4); j++){  // 0(1)
                ipAddressParts[1] = string.substring(i, j);
                if(!isValidPart(ipAddressParts[1])) {  // 2 --> 3
                    continue;
                }

                for(int k = j + 1; k < j + Math.min((int)string.length() - j, 4); k++){  // 0(1)
                    ipAddressParts[2] = string.substring(j, k); // 3
                    ipAddressParts[3] = string.substring(k);    // 4
                    if(isValidPart(ipAddressParts[2]) && isValidPart(ipAddressParts[3])){
                        ips.add(formIPAddress(ipAddressParts));
                    }
                }
            }
        }
        return ips;
    }

    private static boolean isValidPart(String strIP){
        // check if its under the boundary
        int ipInt = Integer.parseInt(strIP);
        if(ipInt > 255){
            return false;
        }
        // check for leading zero/s
        return strIP.length() == (String.valueOf(ipInt)).length();
    }

    private static String formIPAddress(String[] ipAddressPart){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ipAddressPart.length; i++){ // 0(1)
            sb.append(ipAddressPart[i]);
            if(i < ipAddressPart.length - 1){
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
