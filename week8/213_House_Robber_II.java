public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int ans0[] = new int[n];
        int ans1[] = new int[n];
        if(n == 0)
            return 0;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0], nums[1]);
        ans0[0] = nums[0];
        ans0[1] = Math.max(nums[1],nums[0]);
        ans1[0] = 0;
        ans1[1] = nums[1];
        int i = 2;
        for(; i < n-1; i++){
            ans0[i] = Math.max(nums[i]+ans0[i-2], ans0[i-1]);
            ans1[i] = Math.max(nums[i]+ans1[i-2], ans1[i-1]);
            //System.out.println("ans0 = " + ans0[i] + " ans1 = " + ans1[i]);
        }

        return Math.max(ans0[n-2], Math.max(ans1[n-2], ans1[n-3]+nums[n-1]));
        
    }
}