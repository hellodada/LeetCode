public class Solution {
    public int totalNQueens(int n) {
        int[] temp = new int[n];
        int[] ans = {0};
        if(n <= 1)
            return 1;
        helper(ans,0,temp,n);
        return ans[0];
    }
    public void helper(int[] ans, int row, int[] temp, int n){
        //int temp = ans
        //System.out.println(ans[0]);
        if(row == n)
            ans[0] += 1;
        else{
            for( int i = 0; i < n; i++){
                temp[row] = i;
                if(isValid(temp, row))
                    helper(ans, row+1, temp, n);
            }
        }
    }
    public boolean isValid(int[] temp, int row){
        for(int i = 0; i < row; i++){
            if(temp[i] == temp[row] || 
                Math.abs(temp[i] - temp[row]) == row - i)
                return false;
        }
        return true;
    }
}