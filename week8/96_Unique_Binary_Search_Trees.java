public class Solution {
    public int numTrees(int n) {
        int count[] = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        for(int i = 2; i <= n; i++){
            int j = 0;
            while(j < i){
                count[i] += count[i-1-j]*count[j];
                j++;
            }
        }
        return count[n];
        
    }
}