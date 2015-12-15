public class Solution {
    public int strStr(String haystack, String needle) {
        int hlength = haystack.length();
        int nlength = needle.length();
        if(nlength == 0)
            return 0;
        for(int i = 0; i <= hlength-nlength; i++ ){
            if(haystack.charAt(i) == needle.charAt(0)){
                int k = i+1;
                int j = 1;
                for(; j < nlength; j++){
                    if(haystack.charAt(k) != needle.charAt(j))
                        break;
                    k++;
                    //System.out.println("i = "+ i+" j = "+j);
                }
                if(j == nlength)
                    return i;
                
            }
        }
        return -1;
    }
}