package Strings;

public class Minimum_time_toMake_Rope_Colorful {


        public int minCost(String colors, int[] neededTime) {

            if(colors.length() <= 1){
                return 0;
            }

            int result = 0;
            int i = 0;

            for (int j = 1; j < colors.length(); j++) {
                if (colors.charAt(i) == colors.charAt(j)) {
                    if (neededTime[i] <= neededTime[j]) {
                        result += neededTime[i];
                        i = j; // Move i to point to the next character to start comparison again
                    } else {
                        result += neededTime[j];
                    }
                } else {
                    i = j; // Move i to the new character as they are not the same
                }
            }

            return result;
        }
}
