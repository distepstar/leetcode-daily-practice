package AddTwoNumbers;

import Datatypes.ListNode;

public class AddTwoNumbers{
    public AddTwoNumbers(){ }

    int carry = 0;
    // Resursive approach
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        if(l1 == null && l2 == null && carry == 0){
            return null;
        }

        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;

        int sum = val1 + val2 + carry;

        carry = sum / 10;

        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;

        ListNode ans = new ListNode(sum % 10, addTwoNumbers(l1, l2));

        return ans;
    }

    // Iterative approach
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        
        ListNode temp1 = new ListNode(l1.val, l1.next);
        ListNode temp2 = new ListNode(l2.val, l2.next);

        int len1 = 1;
        int len2 = 1;

        // Record the length of both ListNode
        while(temp1.next != null){
            len1++;
            temp1 = temp1.next;
        }

        while(temp2.next != null){
            len2++;
            temp2 = temp2.next;
        }

        
        ListNode res, dummy = new ListNode(0);
        res = dummy;
        int i = 0, j = 0;

        while(i < len1 || j < len2 || carry != 0){
            if(i < len1 && l1 != null){
                carry += l1.val;
                l1  = l1.next;
            }

            if(j < len2 && l2 != null){
                carry += l2.val;
                l2  = l2.next;
            }

            res.next = new ListNode(carry % 10);
            carry /= 10;
            res = res.next;

            if(i < len1){
                i++;
            }
            if(j < len2){
                j++;
            }
        }

        System.out.println("res: " + dummy.next.printAll());

        return dummy.next;
    }

    // Iterative approach (Normal);
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
    
        ListNode p, dummy = new ListNode(0);
        p = dummy;

        while(l1 != null || l2 != null || carry != 0){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }

            p.next = new ListNode(carry % 10);
            carry /= 10;
            p = p.next;
        }

        return dummy.next;
    }
}
