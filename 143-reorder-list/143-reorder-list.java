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
    public ListNode findMidNode(ListNode head){
        ListNode slow=head, fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode curr=head, prev=null,nxt=null;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    
    public void reorderList(ListNode head) {
        ListNode midNode=findMidNode(head);
        ListNode midNextNode=midNode.next;
        midNode.next=null;
        ListNode p2Head=reverseList(midNextNode);
        
        ListNode p1=head, p2=p2Head;
        ListNode p1next;
        
        while(p1!=null && p2!=null){
            p1next=p1.next;
            p1.next=p2;
            p1=p2;
            
            p2=p1next;
        }
        
    }
}