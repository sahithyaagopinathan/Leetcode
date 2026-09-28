class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases like head removal
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        
        while (head != null) {
            // Check if there are duplicate nodes ahead
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes that have the same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect prev to the node after duplicates
                prev.next = head.next;
            } else {
                // No duplicate found, advance prev
                prev = prev.next;
            }
            // Move head forward
            head = head.next;
        }
        
        return dummy.next;
    }
}