package google.areaRectangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaRectangleDriver {

}


 class Solution {
  public double minAreaFreeRect(int[][] points) {
    int n = points.length;
    double minArea = Double.MAX_VALUE;

    // Map key = midpoint_x + midpoint_y + diagonal length squared
    Map<String, List<int[]>> map = new HashMap<>();

    // Step 1: Iterate over all pairs of points and group them by midpoint and diagonal length
    for (int i = 0; i < n; i++) {
      int[] p1 = points[i];
      for (int j = i + 1; j < n; j++) {
        int[] p2 = points[j];

        int midX = p1[0] + p2[0]; // Store 2 * actual midpoint to avoid floating point
        int midY = p1[1] + p2[1];

        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        int distSquared = dx * dx + dy * dy;

        String key = midX + "," + midY + "," + distSquared;
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{i, j});
      }
    }

    // Step 2: For each group of diagonals with same midpoint and length
    for (List<int[]> diagonals : map.values()) {
      for (int i = 0; i < diagonals.size(); i++) {
        for (int j = i + 1; j < diagonals.size(); j++) {
          int[] d1 = diagonals.get(i);
          int[] d2 = diagonals.get(j);

          // Pick 3 unique corners: A from first diagonal, C and D from second
          int[] A = points[d1[0]];
          int[] C = points[d2[0]];
          int[] D = points[d2[1]];

          // Use A–C and A–D as adjacent sides of the rectangle
          double side1 = distance(A, C);
          double side2 = distance(A, D);
          double area = side1 * side2;

          if (area > 0) {
            minArea = Math.min(minArea, area);
          }
        }
      }
    }

    return minArea == Double.MAX_VALUE ? 0.0 : minArea;
  }

  // Helper method to calculate Euclidean distance between two points
  private double distance(int[] p1, int[] p2) {
    double dx = p1[0] - p2[0];
    double dy = p1[1] - p2[1];
    return Math.sqrt(dx * dx + dy * dy);
  }
}
