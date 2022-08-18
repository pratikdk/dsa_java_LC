
class Solution {

/** more intuitive **/
//     public int leastInterval(char[] tasks, int n) {
//         Map<Character, Integer> map = new HashMap<>(); // map
//         for (char c: tasks) {
//             map.put(c, map.getOrDefault(c, 0)+1);
//         }
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a); // maxHeap
//         for (Map.Entry<Character, Integer> entry: map.entrySet()) {
//             maxHeap.add(entry.getValue());
//         }
//         Deque<int[]> queue = new LinkedList<>(); // queue

//         int time = 0;
//         while (!maxHeap.isEmpty() || !queue.isEmpty()) {
//             time += 1;

//             if (!maxHeap.isEmpty()) {
//                 int count = maxHeap.poll() - 1;

//                 if (count > 0) {
//                     queue.add(new int[]{count, time+n});
//                 }
//             }

//             if (!queue.isEmpty() && queue.peek()[1] == time) {
//                 maxHeap.add(queue.poll()[0]);
//             }
//         }
//         return time;
//     }


    public int leastInterval(char[] tasks, int n) {
        int[] charCounts = new int[26];
        int max = 0; // max in charCounts
        int maxCount = 0; // count of chars with max
        for (char task: tasks) {
            charCounts[task - 'A']++;
            if (max == charCounts[task - 'A']) {
                maxCount++;
            } else if (max < charCounts[task - 'A']) {
                max = charCounts[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount-1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - (max * maxCount); // remaining tasks
        int idleSlots = Math.max(0, emptySlots - availableTasks); // < 0 means no extra idle slots are required

        return tasks.length + idleSlots;
    }
}
