class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile: piles) maxPile = Math.max(maxPile, pile);
        int left = 1, right = maxPile;
        int res = maxPile;
        
        while (left <= right) { // binary search from 0 -> k
            int k = (left + right) / 2;
            
            int hours = 0;
            for (int pile: piles) {
                hours += Math.ceil((double) pile / k);
            }
            
            if (hours <= h) { // valid candidate, now try lessedrk's
                res = Math.min(res, k);
                right = k - 1;
            } else { // invalid hourse(more than h), try bigger k's
                left = k + 1;
            }
                
        }
        
        return res;
    }
}
