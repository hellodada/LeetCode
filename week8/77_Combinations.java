public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (k == 0)
            return ans;
        //boolean[] visited = new boolean[n];
        List<Integer> row = new ArrayList<Integer>();
        dfs(n,k,1, ans, row);
        return ans;    
    }
    public void dfs(int n, int k, int start, List<List<Integer>> ans, List<Integer> row){
        if(row.size() == k){
            ans.add(new ArrayList<Integer>(row));
            return;
        }
        for(int i = start; i <= n; i++){
            row.add(i);
            dfs(n,k,i+1, ans,row);
            row.remove(row.size()-1);
        }
    }
}