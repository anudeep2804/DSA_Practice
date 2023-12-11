package ArraysandHashing;

public class Element_Occur_MoreThan25Percent {

    public int findSpecialInteger(int[] arr) {

        int count=1;

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                count++;
                if(count>arr.length/4){
                    return arr[i];
                }
            }
            else{
                count=1;
            }
        }

        return 1;

    }
}
