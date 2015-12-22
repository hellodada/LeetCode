class Solution {
    int findTarget(vector<int> &num, int start, int end, int target) {
        if (start==end) {
            return start;
        }
        if (end-start==1) {
            return abs(num[end]-target) > abs(num[start]-target) ? start : end;
        }
        int mid = (start+end)/2;
        if (num[mid]==target)
            return mid;
        else if(num[mid]>target)
            return findTarget(num, start, mid, target);
        else
            return findTarget(num, mid, end, target);
    }
public:
    int threeSumClosest(vector<int> &num, int target) {
        if (num.size()==0) return 0;
        if (num.size()==1) return num[0];
        if (num.size()==2) return num[0]+num[1];
        if (num.size()==3) return num[0]+num[1]+num[2];

        sort(num.begin(), num.end());

        int start = 0;
        int end = int(num.size()-1);

        int mindiff = INT_MAX;
        while (start<end-1) {

            int newTarget = target - (num[start] + num[end]);
            int p = findTarget(num, start+1, end-1, newTarget);
            int curSum = num[start] + num[end] + num[p];
            if (curSum == target) {
                return target;
            } else if(curSum > target) {
                mindiff = abs(mindiff)>abs(target-curSum) ? target-curSum : mindiff;
                end--;
            } else {
                mindiff = abs(mindiff)>abs(target-curSum) ? target-curSum : mindiff;
                start++;
            }
        }

        return target-mindiff;
    }
};