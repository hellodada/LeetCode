public class Solution {
    public int calculate(String s) {
        int ans = 0;
        int sign = 1;
        int num = 0;
        //Stack<Character> stack = new Stack<Character>();
        Stack<Integer> stack = new Stack<Integer>();
        //int i = 0
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ')
                continue;  
            else if(s.charAt(i) == '-')
                sign = -1;
            else if(s.charAt(i) == '+')
                sign = 1;
            else if(s.charAt(i) == '('){
                stack.push(ans);
                stack.push(sign);
                //System.out.println("ans = " + ans+ " sign = "+sign);
                sign = 1;
                ans = 0;
            }else if(s.charAt(i) == ')'){
                ans = ans*stack.pop() +stack.pop();
            }
            else{
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num = num*10 +(s.charAt(i) - '0');
                   // System.out.println("num = "+num + " i= " + i + " s.char = " + s.charAt(i) );
                    i++;
                }
                ans += sign * num;
                //System.out.println(ans);
                sign = 1;
                num = 0;
                i--;
            }
        }
        return ans;
    }
    
}