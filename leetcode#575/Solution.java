class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> st = new HashSet();
        for(int c: candyType) {
            st.add(c);
        }
        int n = candyType.length/2;
        return Math.min(st.size(), n);
    }
}