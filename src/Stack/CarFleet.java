package Stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {

        if(position.length==0 || speed.length==0){
            return 0;
        }

        if (position.length==1 || speed .length==1){
            return 1;
        }

        double[] time = new double[position.length];

        for(int i=0;i< time.length;i++){
            double distance= (double)(target-position[i]);
            double speedvalue=(double)speed[i];
            time[i]= (double) (distance/speedvalue);
        }
        System.out.println(Arrays.toString(time));
        int result=1;

        for(int i=0;i< time.length-1;i++){
            if(time[i]>time[i+1]){
                result++;
            }

        }

        return result;

    }



    public static void main(String[] args) {

        System.out.println(carFleet(10,new int[]{0,4,2}, new int[]{2,1,3}));
    }
}
