package ArraysandHashing;

public class SecondSmallestElement {


    public static int FindSecondSmallest(int[] arr) {
        if (arr.length <= 1) {
            return Integer.MIN_VALUE;
        }

        int first_smallest = Integer.MAX_VALUE;
        int second_smallest = Integer.MAX_VALUE;

        for (int val : arr) {
            if (val < first_smallest) {
                second_smallest = first_smallest; // Update second smallest to old first smallest
                first_smallest = val; // Update first smallest to new smallest value
            } else if (val >= first_smallest && val <= second_smallest) {
                // Update second smallest if val is between first and second smallest
                second_smallest = val;
            }
        }

        return second_smallest;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 2, 1, 1,0,-1,-1};
        int secondSmallest = FindSecondSmallest(arr);
       // System.out.println("First smallest : " + first_smallest);
        System.out.println("Second smallest: " + secondSmallest);
    }
}
