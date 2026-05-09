class Solution {
    Map<String, Map<String, Double>> map;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        init(equations, values);

        double[] output = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            String numerator = query.get(0);
            String denominator = query.get(1);

            double val = divide(numerator, denominator, new HashSet<>());
            output[i++] = val;
        }

        return output;
    }

    private void init(List<List<String>> equations, double[] values) {
        this.map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            map.computeIfAbsent(numerator, k -> new HashMap<>()).put(denominator, values[i]);
            map.computeIfAbsent(denominator, k -> new HashMap<>()).put(numerator, 1 / values[i]);
        }
    }

    private double divide(String current, String target, Set<String> visited) {
        if (!map.containsKey(current) || !map.containsKey(target)) {
            return -1.0;
        }
        if (current.equals(target)) {
            return 1.0;
        }

        visited.add(current);
        Map<String, Double> neighbors = map.get(current);
        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String next = entry.getKey();
            if (visited.contains(next)) continue;

            double res = divide(next, target, visited);
            if (res != -1.0) {
                return entry.getValue() * res;
            }
        }
        return -1.0;
    }
}