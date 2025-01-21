package ArraysandHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstPaintedRowOrCol {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];

        Map<Integer, int[]> valueToIndex = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valueToIndex.put(mat[i][j], new int[]{i, j});
            }
        }


        for (int i = 0; i < arr.length; i++) {
            int[] position = valueToIndex.get(arr[i]);
            int row = position[0];
            int col = position[1];

            rows[row]++;
            cols[col]++;

            if (rows[row] == n || cols[col] == m) {
                return i;
            }
        }

        return -1;
    }
}
