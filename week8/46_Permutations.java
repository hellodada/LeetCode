public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums.length == 0)
            return ans;
        List<Integer> inner = new ArrayList<Integer>();
        inner.add(nums[0]);
        ans.add(inner);
        for(int i = 1 ; i < nums.length; i++){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            while(!ans.isEmpty()){
                int count = 0;
                while(count <= i){
                   // System.out.println(count);
                    List<Integer> temprow = new ArrayList<Integer>(ans.get(0));
                    temprow.add(count, nums[i]);
                    temp.add(temprow);
                    count++;
                }
                ans.remove(0);
            }
            ans = temp;
        }
        return ans;
    }
}