class Solution {
 public:
 vector<int> twoSum(vector<int>& nums, int target) {
    vector<int>ans;
    int tmp[80000]={0};
    for(int i=0;i<nums.size();i++)
           tmp[40000+nums[i]]=i+1;
    for(int i=0;i<nums.size();i++)
           if(tmp[40000+target-nums[i]]&&tmp[40000+target-nums[i]]!=i+1)
           {
               ans.push_back(i+1);
               ans.push_back(tmp[40000+target-nums[i]]);
               return ans;
           }

}