class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    private boolean backtrack(char[][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char num='1';num<='9';num++){
                        if(isValid(board,row,col,num)){
                            board[row][col]=num;
                            if(backtrack(board)) return true;
                            board[row][col]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board,int row,int col,int num){
        for(int i=0;i<9;i++){
            if(board[row][i]==num || board[i][col]==num) return false;
        }
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for(int r=startRow;r<startRow+3;r++){
            for(int c=startCol;c<startCol+3;c++){
                if(board[r][c]==num) return false;
            }
        }
        return true;
    }
}