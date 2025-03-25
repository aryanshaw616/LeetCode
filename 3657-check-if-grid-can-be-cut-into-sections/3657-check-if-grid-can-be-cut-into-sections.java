class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] hori = new int[rectangles.length][2];
        int[][] vert = new int[rectangles.length][2];

        for(int i = 0;i<rectangles.length;i++){
            hori[i][0] = rectangles[i][0];
            hori[i][1] = rectangles[i][2];

            vert[i][0] = rectangles[i][1];
            vert[i][1] = rectangles[i][3];
        }

        return isCut(hori) || isCut(vert);
    }
    public boolean isCut(int[][] arr){
        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        int start = arr[0][0];
        int end = arr[0][1];
        int count = 0;

        for(int i=1;i<arr.length;i++){
            if(end<=arr[i][0]){
                count++;
            }
            end = Math.max(end,arr[i][1]);
        }
        return count>=2;
    }
}