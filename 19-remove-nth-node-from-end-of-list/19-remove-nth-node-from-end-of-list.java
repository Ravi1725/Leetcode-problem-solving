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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        ListNode prev=null, nxt=head;
        List<ListNode> lst = new ArrayList<>();
        int count=0;
        while(temp!=null){
            lst.add(temp);
            temp=temp.next;
            count++;
        }
        int nodeNumberToDelete=count-n+1;
        if(nodeNumberToDelete==1){
            return nxt.next;
        }
        else{
            if(nodeNumberToDelete==count){
                prev=lst.get(nodeNumberToDelete-2);
                prev.next=null;
                return head;
            }
            prev=lst.get(nodeNumberToDelete-2);
            nxt=lst.get(nodeNumberToDelete);
            prev.next=nxt;
            return head;
        }
    }
}