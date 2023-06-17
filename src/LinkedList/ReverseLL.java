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

    }
}

