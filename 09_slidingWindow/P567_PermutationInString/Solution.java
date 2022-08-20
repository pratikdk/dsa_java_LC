class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1Count = new int[26], s2Count = new int[26]; // hashmaps for s1 and s2
        
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i)-'a'] += 1;
            s2Count[s2.charAt(i)-'a'] += 1;
        }
        
        int matches = 0; // counter
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) matches += 1;
        }
        
        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) return true;
            
            int newChar = s2.charAt(right)-'a';
            s2Count[newChar] += 1;
            if (s1Count[newChar] == s2Count[newChar]) matches += 1;
            else if (s1Count[newChar]+1 == s2Count[newChar]) matches -= 1;
            
            int oldChar = s2.charAt(left)-'a';
            s2Count[oldChar] -= 1;
            if (s1Count[oldChar] == s2Count[oldChar]) matches += 1;
            else if (s1Count[oldChar]-1 == s2Count[oldChar]) matches -= 1;
            
            left += 1;
        }
        
        return matches == 26;
    }
}
