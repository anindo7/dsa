class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int end = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++) {
            end = Math.min(end, strs[i].length());
        }
        for(int j=0;j<end;j++) {
            char check = strs[0].charAt(j);
            for(int i=1;i<strs.length;i++) {
                if(strs[i].charAt(j) != check) {
                    return result;
                }
            }
            result = result + check;
        }
        return result;
    }
}