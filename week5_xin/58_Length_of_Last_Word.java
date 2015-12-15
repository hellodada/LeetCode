public class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        while(n > 0 && s.charAt(n-1) == ' ')
            n--;
        int count = 0;
        for(int i = n-1; i>=0;i--){
            if(s.charAt(i) != ' ')
                count++;
            else
                break;
            
        }
        return count;
    }
}