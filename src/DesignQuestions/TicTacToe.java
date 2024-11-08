package DesignQuestions;

class TicTacToe {

    int[] rows;
    int[] cols;
    int diagonalSum;
    int antiDiagonalSum;
    int n;

    public TicTacToe(int n) {

        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonalSum=0;
        antiDiagonalSum=0;
        this.n = n;
    }

    public int move(int row, int col, int player) {

        int currentValue;

        currentValue = player == 1 ? 1 : -1;

        rows[row] += currentValue;
        cols[col] += currentValue;

        if(row == col){
            diagonalSum += currentValue;
        }

        if(row + col == n-1){
            antiDiagonalSum += currentValue;
        }

        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n
                || Math.abs(diagonalSum) == n || Math.abs(antiDiagonalSum) == n){
            return  player;
        }

        return 0;

    }
}