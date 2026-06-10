import java.util.*;

class Solution {
    public boolean isSubsequence(String s, String t) {
        // Preprocessing — done once, reused for all queries
        Map<Character, List<Integer>> charIndices = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charIndices.computeIfAbsent(t.charAt(i), k -> new ArrayList<>()).add(i);
        }

        int prev = -1; // last matched index in t
        for (char ch : s.toCharArray()) {
            List<Integer> indices = charIndices.get(ch);
            if (indices == null) return false;
            int pos = lowerBound(indices, prev + 1);
            if (pos == indices.size()) return false;
            prev = indices.get(pos);
        }

        return true;
    }

    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}