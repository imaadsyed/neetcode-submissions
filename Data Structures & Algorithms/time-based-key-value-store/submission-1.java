class TimeMap {
    class Entry {
        private Map<Integer, String> value;

        Entry(Integer timestamp, String value) {
            this.value = new HashMap<>();
            this.value.put(timestamp, value);
        }

        public void add(Integer timestamp, String value) {
            this.value.put(timestamp, value);
        }

        public String getValue(Integer timestamp) {
            Integer ts = getTimestamp(timestamp);
            if (ts == -1) {
                return "";
            }

            return this.value.get(ts);
        }

        private Integer getTimestamp(Integer timestamp) {
            if (value.keySet().contains(timestamp)) {
                return timestamp;
            }

            int current = -1;
            for (Integer ts : this.value.keySet()) {
                if (ts <= timestamp && ts > current) {
                    current = ts;
                }
            }

            return current;
        }
    }

    Map<String, Entry> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.keySet().contains(key)) {
            timeMap.put(key, new Entry(timestamp, value));
        }
        timeMap.get(key).add(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.keySet().contains(key)) {
            return "";
        }
        return timeMap.get(key).getValue(timestamp);
    }
}
