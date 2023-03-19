package Twopointers;

public class FindDuplicate {

    //question : https://leetcode.com/problems/find-the-duplicate-number/description/

    /*
    Learning concept :
     Flyod's cycle detection method

     refernces :
     https://www.youtube.com/watch?v=wjYnzkAhcNk&t=185s
º
     Solution credits :
     https://leetcode.com/problems/find-the-duplicate-number/solutions/3023792/slow-fast-method-time-o-n-space-o-1-full-explanation-with-diagram-4ms-only/?languageTags=java

     */


        public static int findDuplicate ( int[] nums){
            int slow = 0, fast = 0;

            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            slow = 0;
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return fast;
        }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 6, 4, 1, 7, 1, 5,1, 3, 10, 11, 8, 12, 9 };
        System.out.println(findDuplicate(arr));

    }
    }
