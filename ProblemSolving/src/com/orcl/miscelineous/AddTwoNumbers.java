package com.orcl.miscelineous;


import com.orcl.sort.MergeTwoSortedList;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sum(l1, l2, 0);
    }

    static ListNode sum(ListNode l1, ListNode l2, int carry) {
        ListNode current = new ListNode();
        if (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            current.val = (sum % 10);
            carry = sum / 10;
            current.next = sum(l1.next, l2.next, carry);
        } else if (l1 != null) {
            int sum = l1.val + carry;
            current.val = (sum % 10);
            carry = sum / 10;
            current.next = sum(l1.next, null, carry);
        } else if (l2 != null) {
            int sum = l2.val + carry;
            current.val = (sum % 10);
            carry = sum / 10;
            current.next = sum(null, l2.next, carry);
        } else {
            if (carry > 0) {
                current.val = carry;
                current.next = null;
            } else {
                return null;
            }
        }
        return current;

    }

    // alternate Solution

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int sum=0;
        int carry=0;
        while(l1!=null || l2!=null || carry==1){
            sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            sum+=carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
