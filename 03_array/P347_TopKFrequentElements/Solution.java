class Solution {
    public int[] topKFrequent(int[] nums, int k) { // can also be solved using priority queue
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num: nums) counter.put(num, counter.getOrDefault(num, 0)+1);
        
        List<List<Integer>> freqBuckets = new ArrayList<>();
        for (int i = 0; i < nums.length+1; i++) freqBuckets.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry: counter.entrySet()) {
            freqBuckets.get(entry.getValue()).add(entry.getKey());
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = freqBuckets.size()-1; i > 0 && res.size() < k; i--) {
            for (Integer n: freqBuckets.get(i)) {
                res.add(n);
                if (res.size() == k) {
                    break;
                }
            }
        }    
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
