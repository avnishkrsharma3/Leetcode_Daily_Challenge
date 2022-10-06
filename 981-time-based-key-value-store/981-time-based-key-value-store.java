class TimeMap {
    HashMap<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        if (timeMap.containsKey(key)) {
            TreeMap<Integer, String> map = timeMap.get(key);
            map.put(timestamp, value);
            timeMap.put(key, map);
        } else {
            TreeMap<Integer, String> map = new TreeMap<Integer, String>();
            map.put(timestamp, value);
            timeMap.put(key, map);
        }
    }

    public String get(String key, int timestamp) {
        if (timeMap.containsKey(key)) {
            TreeMap<Integer, String> map = timeMap.get(key);
            Integer floorKey = map.floorKey(timestamp);
            if (floorKey == null) return "";
            return map.get(floorKey);
        } else {
            return "";
        }
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
