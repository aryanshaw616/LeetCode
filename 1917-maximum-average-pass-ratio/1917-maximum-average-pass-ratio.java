class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(
                ((b[0] + 1) / (b[1] + 1)) - ((b[0]) / (b[1])),
                ((a[0] + 1) / (a[1] + 1)) - ((a[0]) / (a[1])))
        );
        for (int i = 0; i < classes.length; i++) {
            pq.add(new double[] { classes[i][0], classes[i][1] });
        }
        double res = 0;
        for (int i = 0; i < extraStudents; i++) {
            double[] temp = pq.poll();
            pq.add(new double[] { (temp[0] + 1), (temp[1] + 1) });
        }
        for (double i[] : pq) {
            res += i[0] / i[1];
        }
        return res / classes.length;
    }
}