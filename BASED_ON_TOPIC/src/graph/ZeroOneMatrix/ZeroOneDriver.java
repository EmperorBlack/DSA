package graph.ZeroOneMatrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class ZeroOneDriver {

  public static void main(String[] args) {

  }
}
class Pair{
  int i;
  int j;
  int distance;
  public Pair(int i, int j, int distance) {
    this.i = i;
    this.j = j;
    this.distance = distance;
  }
}


class Solution {
  public int[][] updateMatrix(int[][] mat) {

    Queue<Pair> queue = new ArrayDeque<>();
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {

        if (mat[i][j] == 0) {
          queue.offer(new Pair(i, j, 1));
        }
      }
    }

    int deltaRow[] = {-1, 0, 1, 0};
    int delCol[] = {0, 1, 0, -1};
    while (!queue.isEmpty()) {

      Pair curr = queue.poll();
      for (int i = 0; i < 4; i++) {

        int delI = curr.i + deltaRow[i];
        int delJ = curr.j + delCol[i];

        if (delI >= 0 && delJ >= 0 && delI < mat.length && delJ < mat[0].length
            && mat[delI][delJ] == 1) {
          mat[delI][delJ] = curr.distance + 1;
          queue.offer(new Pair(delI, delJ, curr.distance + 1));
        }

      }
    }

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] > 1) {
          mat[i][j] = mat[i][j] - 1;
        }
      }
    }

    return mat;
  }
}
