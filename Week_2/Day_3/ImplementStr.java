class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) return 0;

        int[] lps = new int[m];
        int length = 0, i = 1;

        while (i < m) {
            if (needle.charAt(i) == needle.charAt(length)) {
                lps[i++] = ++length;
            } else {
                if (length != 0) length = lps[length - 1];
                else lps[i++] = 0;
            }
        }

        i = 0;
        int j = 0;

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                return i - j;
            } else if (i < n && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }

        return -1;
    }
}