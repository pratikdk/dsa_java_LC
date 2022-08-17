import java.util.*;

class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        // for (int num: nums) maxHeap.add(num);
        maxHeap.addAll(IntStream.of(nums).boxed().collect(Collectors.toList()));
        int i = k;
        while(!maxHeap.isEmpty() && --i >= 0) {
            minHeap.add(maxHeap.poll());
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
           maxHeap.add(minHeap.poll());
        }
        return minHeap.peek();
    }
}
