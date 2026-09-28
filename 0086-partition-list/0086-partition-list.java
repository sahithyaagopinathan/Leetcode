/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // Dummy nodes to maintain two separate lists: less than x and greater/equal to x
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        
        ListNode less = lessHead;
        ListNode greater = greaterHead;
        
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        
        // Terminate the greater list to avoid cycles
        greater.next = null;
        
        // Connect the 'less' list to the 'greater' list
        less.next = greaterHead.next;
        
        return lessHead.next;
    }
}