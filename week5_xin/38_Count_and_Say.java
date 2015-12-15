public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        if(n == 0)
            return "";
        if(n == 1)
            return "1";
        return rec(res,n);
    }
    public String rec(String ans, int n){
        if(n == 1)
            return ans;
        String temp = "";
        int count = 1;
        int i = 0;
        for(; i < ans.length()-1;i++){
            if(ans.charAt(i) == ans.charAt(i+1))
                count++;
            else{    
                temp+= (char)(count+'0');
                temp+=ans.charAt(i);
                count = 1;
            }
        }
        temp+= (char)(count+'0');
        temp+=ans.charAt(i);
        return rec(temp, n-1);
    }
}