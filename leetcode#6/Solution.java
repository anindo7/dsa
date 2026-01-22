class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        String[] zigZag = new String[numRows];
        Arrays.fill(zigZag, "");
        int cycle = (2 * numRows) - 2;
        for(int i=0;i<s.length();i++) {
            int index = i % cycle;
            if(index < numRows) {
                zigZag[index] = zigZag[index] + s.charAt(i);
            } else {
                zigZag[cycle - index] = zigZag[cycle - index] + s.charAt(i);
            }
        }
        String result = "";
        for(String t: zigZag) {
            result = result + t;
        }
        return result;
    }
}