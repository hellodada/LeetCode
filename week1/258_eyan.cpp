public class Solution {
public int addDigits(int num) {
   return (num<10)?num:((num-10)%9)+1;
}
}