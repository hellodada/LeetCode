public class Solution {
    public boolean isValid(String s) {
        int length = s.length();
       // if(length == 0)
         //   return true;
        if(length % 2 == 1) 
            return false;
        ArrayList<Character> temp = new ArrayList<Character>();
        int index = 0;
        for(int i = 0; i < length; i++){
            char a = s.charAt(i);
            if(a == '(' || a == '{' || a == '['){
                temp.add(a);
                index++;
            }else{
                if(index == 0)
                    return false;
                else if(a == ')'){
                    if(temp.get(index-1) == '('){
                        temp.remove(index-1);
                        index--; 
                    }else
                        return false;
                }else if(a == '}'){
                    if(temp.get(index-1) == '{'){
                        temp.remove(index-1);
                        index--; 
                    }else
                        return false;
                }if(a == ']'){
                    if(temp.get(index-1) == '['){
                        temp.remove(index-1);
                        index--; 
                    }else
                        return false;
                }
            }
        }

       if(index == 0)
            return true;
        else
            return false;
    }
}