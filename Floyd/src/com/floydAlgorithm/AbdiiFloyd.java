package com.floydAlgorithm;

public class AbdiiFloyd {
    public static void floydWarShall(int n){
            int[][] aziMatrix = new int[n][n];// will represent the weight of the shortest path from vertex i to vertex j
            int i, j, k;
            // Floyd-Warshall Algorithm O(n^3)
            for (k = 0; k < n; k++) {
                for (j = 0; j < n; j++) {
                    for (i = 0; i < n; i++) {
                        // If vertex k is on the shortest path from
                        // i to j, then update the value of dist[i][j]
                        if (aziMatrix[i][k] + aziMatrix[k][j] < aziMatrix[i][j]) {
                            aziMatrix[i][j] = aziMatrix[i][k] + aziMatrix[k][j];
                        }
                    }
                }
                System.out.println("\n\n");
                System.out.println("===============The "+k+" iteration  for D matrix ==================");
                AbdiiWeightGraphMatrix.printFormattedMatrix(aziMatrix);
            }

    }
}
