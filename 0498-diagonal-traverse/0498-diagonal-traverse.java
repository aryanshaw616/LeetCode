class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        List<Integer> list = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        int total = m + n - 2;
        int up = 1;
        for(int sum = 0;sum <= total; sum++){
            if(up == 1){
                int x = -1, y = -1;
                if(sum > (m-1)) x = m-1;
                else x = sum;
                y = sum - x;
                while(x >= 0 && y<n){
                    // System.out.println(x + " " + y);
                    list.add(mat[x][y]);
                    x--;
                    y++;
                }
            }
            else{
                int x = -1, y = -1;
                if(sum > (n-1)) y = n-1;
                else y = sum;
                x = sum - y;
                while(x < m && y >= 0){
                    // System.out.println(x + " " + y);
                    list.add(mat[x][y]);
                    x++;
                    y--;
                }
            }
            up = 1 - up;
        }

        int l = list.size();
        int arr[] = new int[l];
        int idx = 0;
        for(int num: list){
            arr[idx++] = num;
        }

        return arr;
    }
} 