// Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

// A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

// Example 1:

// Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
// Output: [15]
// Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
// Example 2:

// Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
// Output: [12]
// Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
// Example 3:

// Input: matrix = [[7,8],[1,2]]
// Output: [7]
// Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.


class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
         List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int minRowValue = Integer.MAX_VALUE;
            int minRowIndex = -1;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < minRowValue) {
                    minRowValue = matrix[i][j];
                    minRowIndex = j;
                }
            }

            boolean isLucky = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][minRowIndex] > minRowValue) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                result.add(minRowValue);
            }
        }

        return result;
    }
}