class Solution {
    public int lengthOfLongestSubstring(String str) {
        if (str.length() == 0) return 0;

        int[] charSeen = new int[128]; 
        int maxLen = 0;
        int leftPtr = 0;

        for (int rightPtr = 0; rightPtr < str.length(); rightPtr++) {

            char currentChar = str.charAt(rightPtr);
            while (charSeen[currentChar] > 0) {
                charSeen[str.charAt(leftPtr)]--;
                leftPtr++;
            }
            charSeen[currentChar]++;
            maxLen = Math.max(maxLen, rightPtr - leftPtr + 1);
        }

        return maxLen;
    }
}