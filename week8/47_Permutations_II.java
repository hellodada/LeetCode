public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return ans;
        List<Integer> row = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, row, ans, visited);
        return ans;
    }
    public void helper(int[] nums, List<Integer> row, List<List<Integer>> ans, boolean[] visited){
        //System.out.println(row);
        if(row.size() == nums.length){
            ans.add(new ArrayList<Integer>(row));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1])
                continue;
            if(!visited[i]){
                row.add(nums[i]);
                visited[i] = true;
                helper(nums, row, ans, visited);
                //System.out.println("row.size = "+ row.size() );
                row.remove(row.size()-1);
                visited[i] = false;
            }
        }
    }
}