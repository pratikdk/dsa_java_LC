class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int val: hand) {
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(countMap.keySet());
        
        while (!minHeap.isEmpty()) {
            int first = minHeap.peek();
            
            for (int i = first; i < first+groupSize; i++) {
                if (!countMap.containsKey(i)) return false;
                
                countMap.put(i, countMap.get(i)-1);
                if (countMap.get(i) == 0) {
                    if (minHeap.peek() != i) {
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }
        
        return true; // minHeap is empty and hashmap values are all 0
    }
}
