package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) 
    {
    
    	while(head!=null&&head.val==val)
    	{
    		ListNode delNode=head;
    		head=head.next;
    		delNode=null;
    	}
    	while(head==null)
    	{
    		return null;
    	}
    	ListNode prev=head;
    	while(prev.next!=null)
    	{
    		if(prev.next.val==val)
    		{	
    			ListNode delNode=prev.next;
    			prev.next=delNode.next;
    			delNode=null;
    		}
    		else 
    		prev=prev.next;
    		
    	}
    	return head;
    }
}