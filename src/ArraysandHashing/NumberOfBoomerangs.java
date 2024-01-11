package ArraysandHashing;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {

        if(points.length<=2){
            return 0;
        }

        int result =0;

        for( int i=0; i< points.length ; i++){
            HashMap<Double, Integer> map = new HashMap<>();
            for ( int j=0; j< points.length; j++){
                if(i==j) continue;

                double current_dist = caluclatedist(points[i] , points[j]);

                map.put(current_dist , map.getOrDefault(current_dist,0)+1);

            }

            for(Map.Entry<Double, Integer> entry  : map.entrySet()){

                if(entry.getValue() >= 2) {
                    result= result+factorial(entry.getValue());
                }
            }


        }


        return  result;

    }

    double  caluclatedist(int[] input1 , int[] input2){

        double  dist =0;

        int squareofdist = (int) (Math.pow(input1[0] - input2[0] , 2 ) + Math.pow(input1[1] - input2[1] , 2 ));

        dist = Math.sqrt(squareofdist);
        return  dist;
    }

    static int factorial(int n)
    {
        int res = 1, i;
        for (i = 2; i <= n; i++)
            res *= i;
        return res;
    }
}
