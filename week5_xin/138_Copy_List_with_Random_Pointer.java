/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode oldnode = head;
        while(oldnode != null){
             RandomListNode newnode = new RandomListNode(oldnode.label);
             map.put(oldnode, newnode);
             oldnode = oldnode.next;
        }
        oldnode = head;
        while (oldnode != null){
            RandomListNode newnode = map.get(oldnode);
            newnode.next = null;
            newnode.random = null;
            if(oldnode.next != null)
                newnode.next = map.get(oldnode.next);
            if(oldnode.random != null)
                newnode.random = map.get(oldnode.random);
            oldnode = oldnode.next;
        }
        
        return map.get(head);
    }
}