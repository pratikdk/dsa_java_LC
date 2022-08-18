
class MedianFinder {
    // max <-> min
    private PriorityQueue<Integer> minHeap; // second half
    private PriorityQueue<Integer> maxHeap; // first half

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        double median;
        if (maxHeap.size() == minHeap.size()) {
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            median = minHeap.peek();
        }
        return median;
    }
}
