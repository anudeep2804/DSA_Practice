package SlidingWindow;

public class SlidingWindowConcept {

    /* Question : Find the Maximum sum of consecutive subarray of size k  */

    public static int MaxSum(int [] arr, int k){

        if(arr.length<k){
            return Integer.MIN_VALUE;
        }

        int maxsum=0;
        int currentsum=0;

        for(int i=0;i<k;i++){
            currentsum=currentsum+arr[i];
        }

        maxsum=currentsum;

        for(int i=k;i<arr.length;i++){
            // sliding the window , adding new element and removing the first each time
            currentsum=currentsum+arr[i]-arr[i-k];
            maxsum=Math.max(currentsum,maxsum);
        }

        return maxsum;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        int maxsum_consective= MaxSum(arr,3);
        System.out.println(maxsum_consective);
    }

}
