public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
            String temp = new String();
            temp = tokens[i];
            //System.out.println(temp);
            if(temp.equals("*")){
                int right = s.pop();
                int left = s.pop();
                s.push(left * right);
            }else if(temp.equals("/")){
                int right = s.pop();
                int left = s.pop();
                s.push(left/ right);
            }else if(temp.equals("+")){
                int right = s.pop();
                int left = s.pop();
                s.push(left + right);
            }else if( temp.equals("-")){
                int right = s.pop();
                int left = s.pop();
                s.push(left - right);
            }else{
                s.push(Integer.parseInt(temp));
            }
            
        }
        return s.pop();
    }
}