package LeetCode;

/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

notice: 注意会出现overflow的问题，即两个单位数会相加大于十
*/
 // Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 /*时间复杂度是n， 因为只用一个while
  * 空间复杂度是n, 因为不停的见一个新的节点
  * */
class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	//初始化一个新的ListNode 用来表示新ListNode的头节点
    	ListNode sumNode = new ListNode(0);
    	//用一个新的node 来代指 sumNode， 防止改变他的内容
    	ListNode cur = sumNode;
    	//sum 用来表示 l1, l2的node之和
    	int sum = 0;
    	//用心的ListNode表示l1, l2， 防止他们发生变化
    	ListNode p1 = l1 , p2 = l2;
    	//while the p1 and p2 are not null
    	while (p1 != null || p2 != null) {
    		if (p1 != null) {
    			sum += p1.val;
    			p1 = p1.next;
    		}
    		if (p2 != null) {
    			sum += p2.val;
    			p2 = p2.next;
    		}
    		//注意sum的值，当值超过10需要进位，用mod
    		cur.next = new ListNode(sum%10);
    		//如果需要进位
    		sum = sum /10;
    		//别忘记 继续向后移
    		cur = cur.next;
    	}
    	//如果到最后一个node时，sum的值是1，则向后加一个节点
    	if (sum == 1) {
    		cur.next = new ListNode(1);
    	}
    	//注意return的不是sumNode， 而是sumNode.next
    	return sumNode.next;
    }
}
