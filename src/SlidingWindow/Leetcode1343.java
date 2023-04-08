package SlidingWindow;

public class Leetcode1343 {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {

        int start=0;
        int end=0;
        int sum=0;
        int counter=0;

      for(;end<k;end++){
          sum=sum+arr[end];
      }

      if(sum/k >= threshold){
          counter++;
      }



      while(end< arr.length){
          sum=sum+arr[end]-arr[start];
          end++;
          start++;

          if(sum/(k)>=threshold){
              counter++;
          }
      }

      return counter;
    }

    public static void main(String[] args) {
        int[] arr={2,2,2,2,5,5,5,8};
        System.out.println(numOfSubarrays(arr,3,4));

    }
}
