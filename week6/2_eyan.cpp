class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry  = 0; int value = 0;
        ListNode *current = l1;
        ListNode *current2 = l2;
        ListNode *prev = new ListNode(0);
        prev->next = l1;

        if(current == NULL)
        {
            return l2;
        }
        else if (current2 == NULL)
        {
            return l1;
        }

        while(current != NULL || current2 != NULL)
        {
            if(current == NULL)
            {

                prev->next = current2;
                value  = current2->val + carry;
                current2->val = value % 10;
                carry = value/10;
                current2 = current2->next;
                prev = prev -> next;

            }
            else if (current2 == NULL)
            {
                value =  current->val + carry;
                current->val = value%10;
                carry =  value/10;
                current  = current->next;
                prev = prev -> next;
            }
            else
            {
                value = current->val + current2->val + carry;
                current -> val = value%10;
                carry = value/10;
                current = current ->next;
                current2 =  current2 -> next;
                prev = prev -> next;
            }
        }

        if(carry)
        {
            ListNode *temp =  new ListNode(carry);
            prev->next = temp;
            prev->next->next = NULL;
        }

        return l1;

    }
};