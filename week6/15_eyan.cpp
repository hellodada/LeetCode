class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        sort(num.begin(),num.end());
        vector<vector<int> > ans;
        if(num.size()<3) return ans;
        for(int i = 0;i<num.size()-2;i++)
    {
        if(((i-1)>=0) && num[i]==num[i-1]) continue;

        int start = i + 1;
        int end = num.size()-1;
        int target = -num[i];
        int last[3] = {0,0,0};
        while(start < end)
        {
            if(num[start] + num[end] < target)
            {
                start++;
            }
            else if(num[start] + num[end] > target)
            {
                end--;
            }
            else
            {
                vector<int> tmp(3,0);
                tmp[0] = num[i];
                tmp[1] = num[start];
                tmp[2] = num[end];
                ans.push_back(tmp);
                while(start<end && num[start]==tmp[1]) start++;
                if(start>=end) break;
            }
        }

    }
    return ans;   
}
};