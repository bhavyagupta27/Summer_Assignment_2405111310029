class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(reverse(words[i]));
            if (i < words.length - 1) result.append(" ");
        }

        return result.toString();
    }

    private String reverse(String word) {
        char[] chars = word.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }
}