package BinarySearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null || matrix.length<1){
            return false;
        }

        if(matrix.length==1){
            return binarysearch(matrix[0], target);
        }

        boolean result=false;

        for(int i=0;i<matrix.length-1;i++){
            if(result==true){
                break;
            }
            if(matrix[i][matrix[i].length-1] >=target){
                result=binarysearch(matrix[i], target);
            }
            else{
                result=binarysearch(matrix[i+1],target);
            }
        }

        return  result;
    }

    public boolean binarysearch (int[] arr , int k){

        int start=0;
       int  end = arr.length-1;

        while(start <end ){

            int mid= (start+end)/2;

            if(arr[mid]== k ){
                return true;
            }

            if(arr[mid]>k){
                end=mid-1;
            }

            if(arr[mid]<k){
                start=mid+1;
            }
        }

        return  false;


    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        boolean ans = search2DMatrix.searchMatrix(matrix, 1);
        System.out.println(ans);
    }
}
