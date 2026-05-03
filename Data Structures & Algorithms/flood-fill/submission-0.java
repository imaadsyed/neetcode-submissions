class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        int originalColor = image[sr][sc];
        image[sr][sc] = color;

        // left
        if (sc - 1 >= 0 && originalColor == image[sr][sc - 1]) {
            floodFill(image, sr, sc - 1, color);
        }
        // right
        if (sc + 1 < image[0].length && originalColor == image[sr][sc + 1]) {
            floodFill(image, sr, sc + 1, color);
        }
        // top
        if (sr - 1 >= 0 && originalColor == image[sr - 1][sc]) {
            floodFill(image, sr - 1, sc, color);
        }
        // bottom
        if (sr + 1 < image.length && originalColor == image[sr + 1][sc]) {
            floodFill(image, sr + 1, sc, color);
        }

        return image;
    }

}

/**
1 1 1       2 2 2
1 1 0  ->   2 2 0 
1 0 1       2 0 1
*/