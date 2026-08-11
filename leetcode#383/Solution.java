class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for(int i=0;i<magazine.length();i++) {
            int c = magazine.charAt(i) - 'a';
            count[c]++;
        }
        for(int i=0;i<ransomNote.length();i++) {
            int c = ransomNote.charAt(i) - 'a';
            count[c]--;
            if(count[c]<0) {
                return false;
            }
        }
        return true;
    }
}