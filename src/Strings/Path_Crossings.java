package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Path_Crossings {

    public boolean isPathCrossing(String path) {
        HashSet<List<Integer>> hashSet = new HashSet<>();

        int x = 0, y = 0;  // Starting point
        hashSet.add(new ArrayList<>(List.of(x, y)));

        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            if (direction == 'N') y++;
            else if (direction == 'S') y--;
            else if (direction == 'E') x++;
            else if (direction == 'W') x--;

            List<Integer> currentPoint = new ArrayList<>(List.of(x, y));
            if (hashSet.contains(currentPoint)) {
                return true;  // Path crosses here
            }
            hashSet.add(currentPoint);
        }

        return false;  // No crossing found
    }
}
