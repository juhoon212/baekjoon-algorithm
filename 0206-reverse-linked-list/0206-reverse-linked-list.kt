/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null;
        var curr: ListNode? = head;

        while (curr!=null) {
            val temp: ListNode? = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }

        return prev
    }
}