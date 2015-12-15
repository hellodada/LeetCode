public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        int left = n; int right = n;
        String temp = new String();
        dfs(temp, ans, left, right);
        return ans;
    }
    public void dfs(String temp, List<String> ans, int left, int right){
        //System.out.println("left = " +left+ " right = " + right);
        if(left > right)
            return;
        if(left == 0 && right == 0){
            ans.add(new String(temp));
            return;
        }
        if(left > 0){
            dfs(temp+'(',ans,left-1,right);
        }
        if(right > 0){
            dfs(temp+')',ans,left,right-1);
        }
    }
}