class NQueen {
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> list = new ArrayList<List<String>>();
        this.nQueen(board, 0, list);
        return list;
       
    }
    
    public boolean nQueen(int[][] board, int row, List<List<String>> list){
        if(row == board.length) {
            String str = "";
            ArrayList<String> lst = new ArrayList<>();
            for(int i=0; i< board.length; i++){
                str = "";
                for(int j=0; j< board.length; j++){
                    if(board[i][j] == 1) str += "Q";
                    else str += ".";
                }
                lst.add(str);
            }
            list.add(lst);
            return true;
        }
        
        for(int i=0; i<board.length; i++){
            if(!this.validPosition(board, row, i)) continue;
            board[row][i] = 1;
            this.nQueen(board, row+1, list);
            board[row][i] = 0;
        }
        return false;
    }
    
    public boolean validPosition(int[][] board, int row, int column){
        for(int i=0; i<board.length; i++){
            if(board[row][i] == 1 && i!= column) return false;
            if(board[i][column] == 1 && i!= row) return false;
        }
        int r = row;
        int c = column;
        while(r >= 0 && c >= 0){
            if(r == row && c == column){
                r--;
                c--;
                continue;
            } 
            if(board[r][c] == 1) return false;
            r--;
            c--;
        }
        r = row;
        c = column;
        while(r < board.length && c < board.length){
            if(r == row && c == column) {
                r++;
                c++;
                continue;
            } 
            if(board[r][c] == 1) return false;
            r++;
            c++;
        }
        r = row;
        c = column;
        while(r >= 0 && c < board.length){
            if(r == row && c == column) {
                r--;
                c++;
                continue;
            } 
            if(board[r][c] == 1) return false;
            r--;
            c++;
        }
        r = row;
        c = column;
        while(r < board.length && c >=0){
            if(r == row && c == column) {
                r++;
                c--;
                continue;
            } 
            if(board[r][c] == 1) return false;
            r++;
            c--;
        }
        return true;
    }
}

// In the above program, backtracking is happening since incase we are unable to insert a queen in a row, means that the positions of the parent row at fault :). kind Cool