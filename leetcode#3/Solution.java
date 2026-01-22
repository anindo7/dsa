class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap(128);
        int result = 0;
        int tempResult = 0;
        for(int i=0;i<s.length();i++) {
            if(indexMap.containsKey(s.charAt(i))) {
                result = Math.max(result, tempResult);
                i = indexMap.get(s.charAt(i)) + 1;
                indexMap.clear();
                tempResult = 1;
            } else {
                tempResult++;
            }
            indexMap.put(s.charAt(i), i);
        }
        return Math.max(result,tempResult);
    }
}