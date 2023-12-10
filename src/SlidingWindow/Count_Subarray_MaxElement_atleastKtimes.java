package SlidingWindow;

class Count_Subarray_MaxElement_atleastKtimes {
    public long countSubarrays(int[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return 0;
        }

        long count = 0;
        int maximum = Integer.MIN_VALUE;

        // Find the maximum element
        for (int num : nums) {
            maximum = Math.max(maximum, num);
        }

        int left = 0;
        int element_counter = 0;

        // Use a single loop to iterate over the array
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == maximum) {
                element_counter++;
            }

            // Once we have k occurrences, count the subarrays
            while (element_counter >= k) {
                // Count subarrays that start anywhere between left and right (inclusive)
                count += nums.length - right;

                // Move left pointer and adjust element_counter
                if (nums[left] == maximum) {
                    element_counter--;
                }
                left++;
            }
        }

        return count;
    }
}
