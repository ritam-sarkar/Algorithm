package com.orcl.linkedlist;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicate {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        /*ListNode head = new ListNode(1);
        head.next = new ListNode(1);*/
        ListNode result = deleteDuplicates(head);
        System.out.println(result);

    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode  curr = head;
        ListNode prev = null;
        while(curr !=null && curr.next != null){
            if(curr.val == curr.next.val){
                ListNode unique = getUniqueNode(curr);
                if(prev != null){
                    prev.next = unique;
                    curr = unique;
                } else {
                    curr = unique;
                    head = curr;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
    private static ListNode getUniqueNode(ListNode node){
       while(node.val == node.next.val){
           node = node.next;
           if(node == null || node.next == null){
               return null;
           }
       }
       node = node.next;
       return node;
    }


    public static class ListNode {
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
