public class Solution {
    public String convert(String s, int numRows) {
        int n;
        String res = "";
        if (numRows == 0)
            return res;
        if ( numRows == 1)
            return s;
        int block = numRows*2-2;
        //int index = 0;
        for(int i = 0; i < numRows ; i++){
            //System.out.println("i =" + i);
            for(int j = i; j < s.length(); j+= block){
                //System.out.println("    j = " + j +" index = "+ index);
                res+=s.charAt(j);
                if( i != 0 && i != numRows-1 && j+block- i*2 < s.length()){
                    res+=s.charAt(j+block- i*2);
                }
            }
        }

        return res;
    }
}