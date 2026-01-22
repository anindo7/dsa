class Solution {
    public String longestPalindrome(String s) {
        int palinSize = 0;
        String result = "";
        for(int i=0;i<s.length();i++) {
            String odd = findPalindrome(s, String.valueOf(s.charAt(i)), i-1, i+1);
            String even = findPalindrome(s, "", i, i+1);
            String tempResult = (odd.length() > even.length())? odd : even;
            if(palinSize < tempResult.length()) {
                palinSize = tempResult.length();
                result = tempResult;
            }
        }
        return result;
    }

    public String findPalindrome(String input, String startChar, int start, int end) {
        while(start >= 0 && end < input.length()) {
            if(input.charAt(start) == input.charAt(end)) {
                startChar = input.charAt(start) + startChar + input.charAt(start);
                start--;end++;
            } else {
                break;
            }
        }
        return startChar;
    }
}