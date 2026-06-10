class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int length = 0, i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(length)) {
                lps[i++] = ++length;
            } else {
                if (length != 0) length = lps[length - 1];
                else lps[i++] = 0;
            }
        }

        int last = lps[n - 1];
        return last > 0 && n % (n - last) == 0;
    }
}