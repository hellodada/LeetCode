public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> toFind = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tempstr = new HashMap<Character, Integer>();
        if(t.length() == 0 || s.length() == 0 || t.length() > s.length())
            return new String();
        for(int i = 0; i < t.length(); i++){
            if(!toFind.containsKey(t.charAt(i))){
                toFind.put(t.charAt(i),1);
                tempstr.put(t.charAt(i),0);
            }
            else
                toFind.put(t.charAt(i), toFind.get(t.charAt(i))+1);
                
        }
        int res = Integer.MAX_VALUE;
        int i = 0;
        //int[] ans = new int[2];
        String ans = "";
        int count = t.length();
        for(int j = 0 ; j < s.length();j++){
            if(toFind.containsKey(s.charAt(j))){
                tempstr.put(s.charAt(j), tempstr.get(s.charAt(j))+1);
                if (toFind.get(s.charAt(j)) >= tempstr.get(s.charAt(j))){
                    count--;
                }
            }
            //System.out.println( "j =" + j);
            while(count == 0){
                int min = j - i+1;
                //System.out.println("min = " + min+ " j =" + j +" i = "+i);
                if(res > min){
                    res = min;
                    ans = s.substring(i, j+1);
                }
                if(toFind.containsKey(s.charAt(i))){
                    tempstr.put(s.charAt(i), tempstr.get(s.charAt(i))-1);
                    if(tempstr.get(s.charAt(i)) < toFind.get(s.charAt(i)))
                        count++;
                }
                i++;
            }
        }
        
        return ans;
        
    }
}