public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length == 0)
            return "";
        int[] result = new int[2]; 
        int maxL = 1;
        int i = 1;
        for(; i < length-maxL/2; ){
            int left = i-1;
            int right = i+1;
            char center = s.charAt(i);
            while(left >= 0 && s.charAt(left) == center)
                left--;
            while(right < length && s.charAt(right) == center)
                right++;
            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1 > maxL){
                maxL = right-left-1;
                result[0] = left+1;
                result[1] = right-1;
            }
            i = Math.max(maxL/2, i+1); 
        }
        return s.substring(result[0],result[1]+1);
    }
}