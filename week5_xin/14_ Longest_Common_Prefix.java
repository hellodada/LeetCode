public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if(strs == null || strs.length == 0)
            return ans;
        if (strs.length == 1)
            return strs[0];
        boolean isSame = true;
        int index = 0;
        while(isSame){
            for(int i = 0; i < strs.length-1; i++){
                if(index < strs[i].length() && index < strs[i+1].length()
                    && strs[i].charAt(index) == strs[i+1].charAt(index))
                    ;
                else{
                    isSame = false;
                    break;
                }
            }
            if(isSame)
                ans+=strs[0].charAt(index);
            index++;
        }
                   // System.out.println(index);
        return ans;
    }
}