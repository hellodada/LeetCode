public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n <= 0)
            return result;
        int[] template = new int[n];
        dfs(n, result, 0, template);
        
        return result;
    }
    public void dfs(int n, List<List<String>> result, int row, int[] temp){
        if(row == n)
            result.add(printOut(temp));/* add the string to result*/
        else{
            for(int i = 0; i < n; i++){
                temp[row] = i;
                if(isValid(row, temp))
                    dfs(n, result, row+1, temp);
            }
        }
        
    }
    public boolean isValid(int n, int[] temp){
        for(int i = 0; i < n; i++){
            if((Math.abs(temp[i]-temp[n]) == n - i) ||
               (temp[i] == temp[n]))
                return false;
        }
        return true;
    }
    public List<String> printOut(int[] temp){
        List<String> help = new ArrayList<String>();
        for(int i = 0; i < temp.length; i++){
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < temp.length; j++){
                if( j == temp[i])
                    row.append('Q');
                else
                    row.append('.');
            }
            help.add(row.toString());
        }
        return help;
    }
}
