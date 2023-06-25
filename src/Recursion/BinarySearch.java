package Recursion;

public class BinarySearch {
    public static int binarysearch(int[] arr , int k , int start , int end){

        if(arr.length==0){
            return -1;
        }
        if(arr.length==1){
            if(arr[0]==k){
                return 0;
            }
            else{
                return -1;
            }
        }


        int mid=(start+end)/2;

        if(arr[mid]==k){
            return mid;
        }

        if(start >= end){
            return -1;
        }

        if(k>arr[mid]){
            return binarysearch(arr,k,mid+1,end);
        }

        if(k<arr[mid]){
            return binarysearch(arr,k,start,mid-1);
        }
return -1;
    }

    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6};
        int k=4;
        System.out.println(binarysearch(arr,k,0,arr.length));
    }
}
