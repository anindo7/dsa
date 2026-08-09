class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        Set<Integer> st = new HashSet();
        int ans=0;
        for(int i=n-k; i<= n+k; i++) {
            if(i==n) {
                continue;
            }
            int abi=Math.abs(i);
            if((n&abi) == 0) {
                st.add(abi);
            }
        }
        for(int i: st) {
            ans = ans + i;
        }
        return ans;
    }
}