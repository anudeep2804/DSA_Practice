package ArraysandHashing;

import java.util.Arrays;

public class Only_Way_Up {


    static int getMinValue(int size, int[] arr, int K){
        if(arr.length<=1){
            return 0;
        }

        int counter=0;

        int prev_val = arr[0];

        for(int i=1; i<size; i++){

            int current_val = arr[i];

            if(current_val - prev_val >= 1 ){
                prev_val = arr[i];
                continue;
            }
            else{
                while(((arr[i]- prev_val) <1)){
                    arr[i]=arr[i]+K;
                    counter++;
                }

                prev_val = arr[i];
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,3,2};
        int size =4;
        int k =2;

        int ans = getMinValue(size, arr , k);
        System.out.println(ans);
        System.out.println(Arrays.toString(arr));
    }

}
