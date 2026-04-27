class Solution {

    private class Distance {
        public double distance;
        public int pointsIndex;

        public Distance(double distance, int pointsIndex) {
            this.distance = distance;
            this.pointsIndex = pointsIndex;
        }

        public static void sort(Distance[] list) {
            for (int i = 1; i < list.length; i++) {
                Distance current = list[i];
                int j = i - 1;

                while (j >= 0 && current.distance < list[j].distance) {
                    list[j + 1] = list[j];
                    j--;
                }

                list[j + 1] = current;
            }
        }

        @Override
        public String toString() {
            return "Index: " + pointsIndex + " Distance: " + distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        Distance[] kClosest = new Distance[points.length];
        int index = 0;
        int [][] newPoints = new int[k][2];

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double distance = Math.sqrt((x*x) + (y*y));
            
            Distance dist = new Distance(distance, i);
            kClosest[index++] = dist;
        }

        Distance.sort(kClosest);

        for (int i = 0; i < points.length; i++) {
            System.out.println("DEBUG: " + kClosest[i]);
        }

        for (int i = 0; i < k; i++) {
            
            newPoints[i] = points[kClosest[i].pointsIndex];
        }

        // TODO:
        return newPoints; 
    }
}
