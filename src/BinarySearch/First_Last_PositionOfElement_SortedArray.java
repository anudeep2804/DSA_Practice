package BinarySearch;

import java.util.ArrayList;

public class First_Last_PositionOfElement_SortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if (nums.length == 0) {
            return result;
        }

        // Search for the left index of the target
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start < nums.length && nums[start] == target) {
            result[0] = start;
        }

        // Search for the right index of the target
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (end >= 0 && nums[end] == target) {
            result[1] = end;
        }

        return result;
    }

}
