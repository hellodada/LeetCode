public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        HashMap<String, Integer> toFind = new HashMap<String, Integer>();
        HashMap<String, Integer> dic = new HashMap<String, Integer>();
        int wordlength = words[0].length();
        int n = words.length;
        for(int i = 0; i < words.length; i++){
            if(!toFind.containsKey(words[i]))
                toFind.put(words[i],1);
            else
                toFind.put(words[i], toFind.get(words[i])+1);
        }
        for(int i = 0; i <= s.length()-wordlength*n;i++){
            int j;
            dic.clear();
            for(j = 0; j < n; j++){
                String temp = s.substring(i+j*wordlength,i+(j+1)*wordlength);
                //System.out.println(temp);
                if(!toFind.containsKey(temp))
                    break;
                //System.out.println("dic.get(temp)" + dic.get(temp));
                else{
                    if(!dic.containsKey(temp))
                        dic.put(temp,1);
                    else
                        dic.put(temp, dic.get(temp)+1);
                }
                //System.out.println("temp: "+temp+" dic.get = " + dic.get(temp) +" toFind.get = "+ toFind.get(temp));
                if(dic.get(temp) > toFind.get(temp))
                    break;
            }
           // System.out.println("j ="+j);
            if(j == n)
                ans.add(i); 
        }
        return ans;
    }
}