class Solution {
//     public boolean checkValidString(String s) {
//        return backtrack(s, 0, 0);
//     }
    
//     private boolean backtrack(String s, int i, int openCount) {
//         if (i == s.length()) {
//             if (openCount > 0) return false;
//             else if (openCount < 0) return false;
//             else return true;
//         }
//         if (openCount < 0) return false;
        
//         if (s.charAt(i) == '*') {
//             if (backtrack(s, i+1, openCount) || backtrack(s, i+1, openCount+1) || backtrack(s, i+1, openCount-1)) {
//                 return true;
//             }
//         } else {
//             if (s.charAt(i) == '(') {
//                 if (backtrack(s, i+1, openCount+1)) return true;
//             } else {
//                 if (backtrack(s, i+1, openCount-1)) return true;
//             }
//         }
//         return false;
//     }
    
    
//     public boolean checkValidString(String s) {
//         Map<int[], Boolean> cache = new HashMap<>();
//         return backtrack(s, 0, 0, cache);
//     }
    
//     private boolean backtrack(String s, int i, int openCount, Map<int[], Boolean> cache) {
//         if (i == s.length()) {
//             if (openCount > 0) return false;
//             else if (openCount < 0) return false;
//             else return true;
//         }
//         if (openCount < 0) return false;
//         int[] key = {i, openCount};
//         if (cache.containsKey(key)) return cache.get(key);
        
//         if (s.charAt(i) == '*') {
//             if (backtrack(s, i+1, openCount, cache) || backtrack(s, i+1, openCount+1, cache) || backtrack(s, i+1, openCount-1, cache)) {
//                 return true;
//             }
//         } else {
//             if (s.charAt(i) == '(') {
//                 if (backtrack(s, i+1, openCount+1, cache)) return true;
//             } else {
//                 if (backtrack(s, i+1, openCount-1, cache)) return true;
//             }
//         }
//         cache.put(key, false);
//         return false;
//     }
    
    public boolean checkValidString(String s) {
        int minLeft = 0, maxLeft = 0; // '('
        
        for (char c: s.toCharArray()) {
            if (c == '(') {
                minLeft += 1;
                maxLeft += 1;
            } else if ( c == ')') {
                minLeft -= 1;
                maxLeft -= 1;
            } else {
                minLeft -= 1; // )
                maxLeft += 1; // (
            }
            
            if (maxLeft < 0) return false;
            if (minLeft < 0) minLeft = 0;
        }
        
        return minLeft == 0;
    }
    
}
