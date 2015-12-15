public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] ref = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<String>();
        int index = 0;
        for(int i = 0; i < digits.length(); i++){
            int ind = digits.charAt(i)-'0';
            int ans_length = ans.size();
            if(ans_length == 0 && i == 0)
                for(int j = 0; j < ref[ind].length(); j++){
                    ans.add(Character.toString(ref[ind].charAt(j)));
                   // System.out.println("char= " + ref[ind].charAt(j));
                }
            else{
                int count = 0;
                while(count < ans_length ){
                    String pre = ans.remove(0);
                        String temp = pre;
                        temp+=ref[ind].charAt(j);
                        //System.out.println(" pre = "+pre);
                        ans.add(temp);
                    }
                    count++;
                }    
            }
        }
        
        return ans;
        
    }
}