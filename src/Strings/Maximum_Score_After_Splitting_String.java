package Strings;

public class Maximum_Score_After_Splitting_String {

    public int maxScore(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        int totalones = 0;


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalones++;
            }
        }

        right = totalones;


        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                left++;
            } else {
                right--;
            }
            result = Math.max(result, left + right);
        }

        return result;
    }
}
