// Boyer-Moore Voting Algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a = 1000000001;
        int c1 = 0;
        int b = 1000000001;
        int c2 = 0;
        for(int n: nums) {
            if(n==a) {
                c1++;
            } else if(n==b){
                c2++;
            } else if(c1==0) {
                a = n;
                c1++;
            } else if(c2 == 0) {
                b=n;
                c2++;
            } else {
                c1--;c2--;
            }
        }
        c1=0;c2=0;
        for(int n: nums) {
            if(n==a) {
                c1++;
            }
            if(n==b) {
                c2++;
            }
        }
        List<Integer> ans = new ArrayList();
        if(c1>nums.length/3) {
            ans.add(a);
        }
        if(c2>nums.length/3) {
            ans.add(b);
        }
        return ans;
    }
}