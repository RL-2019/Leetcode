class Solution {
    public boolean canPermutePalindrome(String s) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            
        }
        for(char key:map.keySet()){
            count+= map.get(key)%2;
        }
        return count<=1;
        
    }
}
