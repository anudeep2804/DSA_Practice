package ArraysandHashing;

public class Median_Of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;;

        int result[] = new int[m+n];

        int i=0; int j=0; int k=0;

        while (i<m && j<n){
            if(nums1[i]<=nums2[j]){
                result[k++] = nums1[i++];
            }
            else{
                result[k++] = nums2[j++];
            }
        }

        while (i<m){
            result[k++]= nums1[i++];
        }

        while (j<n){
            result[k++]=nums2[j++];
        }

        int len = m+n;

        if(len % 2 !=0){
            return (double) result[len /2];
        }

        return ((double) result[len / 2] + (double) result[len/2]) / 2.0;

    }
}
