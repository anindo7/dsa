class Solution {
    public String longestPalindrome(String s) {
        int len = 0;
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            String tempResult = "";
            String tempResultEven = "";

            tempResult = findPalindrome(s, i - 1, i + 1, String.valueOf(s.charAt(i)));
            if(tempResult.length() > len) {
                len = tempResult.length();
                result = tempResult;
            }

            tempResultEven = findPalindrome(s, i - 1, i, "");
            if(tempResultEven.length() > len) {
                len = tempResultEven.length();
                result = tempResultEven;
            }
        }
        return result;
    }

    public String findPalindrome(String s, int j, int k, String tempResult) {
        while(j >= 0 && k < s.length()) {
            if(s.charAt(j) != s.charAt(k)) {
                break;
            }
            tempResult = s.charAt(j) + tempResult + s.charAt(k);
            j--; k++;
        }
        return tempResult;
    }

}