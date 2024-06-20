// Same as Agressive cows
public class Solution {
    
    public static int maxDistance(int[] positions, int m) {
        int n = positions.length; // size of array
        Arrays.sort(positions); // sort the positions array

        int low = 1, high = positions[n - 1] - positions[0];
        int answer = 0;

        // apply binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(positions, mid, m)) {
                answer = mid; // update answer
                low = mid + 1; // try for a larger distance
            } else {
                high = mid - 1; // try for a smaller distance
            }
        }
        return answer;
    }
    public static boolean canWePlace(int[] positions, int dist, int m) {
        int n = positions.length; // size of array
        int countBalls = 1; // count of balls placed
        int lastPosition = positions[0]; // position of last placed ball

        for (int i = 1; i < n; i++) {
            if (positions[i] - lastPosition >= dist) {
                countBalls++; // place next ball
                lastPosition = positions[i]; // update the last location
            }
            if (countBalls >= m) return true; // if all balls are placed, return true
        }
        return false; // if not all balls are placed, return false
    }

}