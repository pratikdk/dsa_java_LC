class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2]; // [position, time]
        for (int i = 0; i < n; i++) {
            cars[i] = new double[] {position[i], (double) (target - position[i]) / speed[i]};
        }
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        
        int res = 0;
        double curr = 0;
        for (int i = n-1; i >= 0; i--) {
            if (cars[i][1] > curr) {
                curr = cars[i][1];
                res += 1;
            }
        }
        return res;
    }
    
    public int carFleet2(int target, int[] position, int[] speed) {
        int n = position.length;
        Map<Integer, Double> maxMap = new TreeMap<>((a, b) -> (b - a));
        for (int i = 0; i < n; i++) {
            maxMap.put(position[i], (double) (target - position[i]) / speed[i]);
        }
        int res = 0;
        double curr = 0;
        for (double time: maxMap.values()) {
            if (time > curr) {
                curr = time;
                res += 1;
            }
        }
        return res;
    }
}
