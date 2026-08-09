class Solution {

    private List<String> generate(int n, Map<Integer, List<String>> dp) {
        Set<String> ans = new HashSet<>();
        if(dp.containsKey(n)) {
            return dp.get(n);
        }
        for(int i=1;i<n;i++) {
            List<String> left = generate(i, dp);
            List<String> right = generate(n-i, dp);
            for(String l: left) {
                for(String r: right) {
                    ans.add(l+r);
                }
            }
        }
        List<String> prev = generate(n-1, dp);
        for(String p: prev) {
            ans.add("(" + p + ")");
        }
        dp.put(n, new ArrayList(ans));
        return dp.get(n);
    }

    public List<String> generateParenthesis(int n) {
        Map<Integer, List<String>> dp = new HashMap();
        dp.put(1, List.of("()"));
        return generate(n, dp);
    }
}