package ArraysandHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.sort;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        /* @@@@@@@@ Brute force @@@@@@@@@@

        List<List<String>> list = new ArrayList<>();

        if (strs.length <= 1) {
            list.add(Arrays.stream(strs).toList());
            return list;
        }

        HashMap<Integer, String> hashMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            hashMap.put(i, strs[i]);
        }

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            strs[i] = str;
        }

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                continue;
            }
            List<String> templist = new ArrayList<>();
            templist.add(hashMap.get(i));
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i].equals(strs[j])) {
                    templist.add(hashMap.get(j));
                    strs[j] = null;
                }
            }
            list.add(templist);
        }

        return list;

         */

    // @@@ otimpized approach @@@//
        // basic idea is to group the strings together and insert them in map like map<String,List<String>>
        if (strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<String> trailst = new ArrayList<>();
        trailst.add(strs[0]);

    }
}
