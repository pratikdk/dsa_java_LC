class Data {
    String value;
    int timestamp;
    Data(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    private Map<String, List<Data>> map; // int[] : (value, timestamp)
    
    public TimeMap() {
        this.map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        List<Data> list = map.getOrDefault(key, new ArrayList<>());
        
        int left = 0, right = list.size()-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                res = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return res;
    }
}

