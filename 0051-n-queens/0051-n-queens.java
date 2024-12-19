class Solution {

    private boolean isSafe(int i,int j,int n,char Board[][]){
            //horizontal
            for(int k=0;k<n;k++){
                if(Board[i][k]=='Q'){
                    return false;
                }
            }
            //upper-left
            for(int row=i,col=j;row>=0 && col>=0;row--,col--){
                if(Board[row][col]=='Q'){
                    return false;
                }
            }
            //upper-right
            for(int row=i,col=j;row>=0 && col<n;row--,col++){
                if(Board[row][col]=='Q'){
                    return false;
                }
            }

            //lower-left
            for(int row=i,col=j;row<n && col>=0;row++,col--){
                if(Board[row][col]=='Q'){
                    return false;
                }
            }
            //lower-right
    for(int row=i,col=j;row<n && col<n;row++,col++)   {
                if(Board[row][col]=='Q'){
                    return false;
                }
            }

            return true;
        }
    private void solveNQueens(int n,char Boards[][],List<List<String>> result,int col){
        List<String> line=new ArrayList<>();
        if(col == n){
            for(char[] each:Boards){
                line.add(new String(each));
            }
            result.add(line);
            return;
        }

        for(int i=0;i<n;i++){
            if(isSafe(i,col,n,Boards)){
                Boards[i][col]='Q';
                solveNQueens(n,Boards,result,col+1);
                Boards[i][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        char Boards[][]=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(Boards[i],'.');
        }
        solveNQueens(n,Boards,result,0);
        return result;
    }
}