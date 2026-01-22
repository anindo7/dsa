class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> keypad = new HashMap();
        keypad.put('2',"abc");
        keypad.put('3',"def");
        keypad.put('4',"ghi");
        keypad.put('5',"jkl");
        keypad.put('6',"mno");
        keypad.put('7',"pqrs");
        keypad.put('8',"tuv");
        keypad.put('9',"wxyz");

        return convert(keypad, 0, digits);
    }

    public List<String> convert(Map<Character, String> keypad, int index, String digits) {
        List<String> result = new ArrayList();
        if(index == digits.length() - 1) {
            for(int i=0; i<keypad.get(digits.charAt(index)).length(); i++) {
                result.add(String.valueOf(keypad.get(digits.charAt(index)).charAt(i)));
            }
            return result;
        }
        List<String> suffix = convert(keypad, index + 1, digits);
        for(int i=0; i<keypad.get(digits.charAt(index)).length(); i++) {
            for(String s: suffix) {
                result.add(keypad.get(digits.charAt(index)).charAt(i) + s);
            }
        }
        return result;
    }
}