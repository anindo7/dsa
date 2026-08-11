class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sl = s.split(" ");
        Map<Character, String> ht = new HashMap();
        Map<String, Character> ht2 = new HashMap();
        if(sl.length != pattern.length()) {
            return false;
        }
        for(int i=0;i<pattern.length();i++) {
            char c = pattern.charAt(i);
            if(ht.containsKey(c)) {
                if(!ht.get(c).equals(sl[i])) {
                    return false;
                }
            } else {
                if(ht2.containsKey(sl[i])){
                    return false;
                }
            }
            ht.put(c, sl[i]);
            ht2.put(sl[i], c);
        }

        return true;
    }
}