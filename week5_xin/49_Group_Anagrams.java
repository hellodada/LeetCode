public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> ans = new ArrayList<List<String>>();
        Arrays.sort(strs);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String tempstr = new String(temp);
            if(!map.containsKey(tempstr)){
                ArrayList<String> templist = new ArrayList<String>();
                templist.add(strs[i]);
                map.put(tempstr, templist);
            } else
                map.get(tempstr).add(strs[i]);
        }
        for(ArrayList<String> t : map.values()){
            //ArrayList<String> group = new ArrayList<String>();
            //group.add(t);
            ans.add(t);
        }
        return ans;
        
    }
}