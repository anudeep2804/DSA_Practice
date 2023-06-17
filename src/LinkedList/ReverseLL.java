package LinkedList;

public class ReverseLL {


    public class ListNode {
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

        public ListNode reverseList(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            // if(head==null){
            //     return null;
            // }

            // ListNode prev=null;
            // ListNode cur=head;
            // ListNode n= head.next;

            // while(cur!=null){
            //     cur.next=prev;
            //     prev=cur;
            //     cur=n;
            //     if(n!=null){
            //         n=n.next;
            //     }

            // }

            // return prev;

            head = recursivereverse(head);

            return head;

        }

        // recursive approach

        public ListNode recursivereverse(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode newhead = recursivereverse(head.next);
            head.next.next = head;
            head.next = null;

            return newhead;


        }


        // */
    }
}

