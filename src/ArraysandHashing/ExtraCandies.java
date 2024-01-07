package ArraysandHashing;
import java.util.*;

public class ExtraCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();

        int max = 0;

        for( int candie : candies){
            if(candie> max){
                max = candie;
            }
        }

        for(int candie : candies){
            if ( candie + extraCandies >= max) result.add(true);
            else result.add(false);
        }

        return result;


    }
}
