class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList();
        int i=0;
        while(i<numRows) {
            List<Integer> row = new ArrayList();
            if(i>=0) {
                row.add(1);
            }
            for(int j = 1; j< i; j++) {
                row.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
            }
            if(i>=1) {
                row.add(1);
            }
            triangle.add(row);
            i++;
        }
        return triangle;
    }
}