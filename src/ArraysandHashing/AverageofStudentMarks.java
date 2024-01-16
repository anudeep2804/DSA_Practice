package ArraysandHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageofStudentMarks {


// Goldmansachs Interview Question :

    //https://leetcode.com/discuss/interview-question/394477/goldman-sachs-phone-screen-highest-average-score-power-of-10
    public int highestavg (String[][] scores){

      if(scores==null || scores.length== 0){
          return -1;
      }

      int highestval = 0;

      Map<String , List<Integer>> map = new HashMap<>();

      for(int i=0; i<scores.length ; i++){
          List<Integer> scoreslist = map.get(scores[i][0]);

          if(scoreslist == null){
              List<Integer> currentscore = new ArrayList<>();
              currentscore.add(StringToINt(scores[i][0]));
              map.put(scores[i][0], scoreslist);
          }
          else {
              scoreslist.add(StringToINt(scores[i][1]));
              map.put(scores[i][0] , scoreslist);
          }
      }

      for(Map.Entry<String , List<Integer>> entry : map.entrySet()){
          int currentAvescoe = aveCal(entry.getValue());
          highestval = Math.max(highestval, currentAvescoe);
      }


return highestval;

    }

    private int aveCal(List<Integer> scores) {

        int len = scores.size();
        int sum = 0;
        for(int score : scores) {
            sum += score;
        }

        float ave = sum / len;
        return (int) ave;
    }

    int StringToINt(String str){
        return Integer.parseInt(str);
    }
}
