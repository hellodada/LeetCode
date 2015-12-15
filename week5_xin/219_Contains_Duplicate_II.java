public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0 || nums == null)
            return false;
        HashSet< Integer> set = new HashSet<Integer>();
        int i = 0;
        for(; i <k && i < nums.length;i++){
            if(!set.add(nums[i]))
                return true;
        }
        int m = 0;
        for(;i < nums.length;i++){
            if(!set.add(nums[i]))
                return true;
            set.remove(nums[m]);
            m++;
        }
        return false;
        
    }
}