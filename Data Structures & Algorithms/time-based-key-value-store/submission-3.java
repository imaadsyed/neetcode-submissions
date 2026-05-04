class TimeMap {
    private class Node {
        Integer timestamp;
        String value;

        Node(Integer timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(TS: " + timestamp.toString() + ", Value: " + value + ")";
        }
    }
    private Map<String, List<Node>> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.keySet().contains(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        Node toInsert = new Node(timestamp, value);
        timeMap.get(key).add(toInsert);
    }
    
    public String get(String key, int timestamp) {
        System.out.println("GET: " + key + ", ts:" + timestamp);
        if (!timeMap.keySet().contains(key)) {
            return "";
        }
        
        List<Node> sortedList = timeMap.get(key);
        return getTimestampValue(sortedList, timestamp);
    }

    private String getTimestampValue(List<Node> list, int ts) {
        int l = 0;
        int r = list.size() - 1;

        while(l < r) {
            int mid = (l + r) / 2;
            if (ts < list.get(mid).timestamp) {
                r = mid - 1;
            } else if (ts > list.get(mid).timestamp) {
                l = mid + 1;
            } else {
                return list.get(mid).value;
            }
        }
        if (!(list.get(l).timestamp <= ts)) {
            l--;
        }
        System.out.println("List: " + list.toString());
        System.out.println("l: " + l);
        System.out.println("r: " + r);
        return l >= 0 ? list.get(l).value : "";
    }
}
