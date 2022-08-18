import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> (p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1]));
        for (int[] p: points) minHeap.add(p);

        int[][] res = new int[k][2];
        while (--k >= 0) {
            res[k] = minHeap.poll();
        }
        return res;
    }
    // can also be implemented by limiting heap to size of k while using a maxHeap
}
