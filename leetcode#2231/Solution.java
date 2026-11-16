class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b) -> b-a);
        int n1=num;
        List<Boolean> parity = new ArrayList<>();
        while(n1>0) {
            int d = n1%10;
            if(d%2==0) {
                pq2.add(d);
                parity.add(true);
            } else {
                pq1.add(d);
                parity.add(false);
            }
            n1 = n1/10;
        }
        int n = parity.size();
        int ans = 0;
        for(int i=0;i<n;i++) {
            int d;
            if(parity.get(n-1-i)) {
                d = pq2.remove();
            } else {
                d = pq1.remove();
            }
            ans = ans*10 + d;
        }
        return ans;
    }
}