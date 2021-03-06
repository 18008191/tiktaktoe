package com.game.ttt.board;

public class Board {
    String [][] board = {{"","",""},{"","",""},{"","",""}};

    public Board(){
    }

    /**
     * places the char on given position, exception if a move was already placed there
     * @param ch
     * @param row
     * @param col
     * @throws Exception
     */
    public void move(String ch, int row, int col)throws Exception{
        if(board[row][col] == "") {
            board[row][col] = ch;
        }else{
            throw new Exception("Can't place move here!");
        }
    }

    /**
     * if the same chara+cter is on one of the diagonals, on the same row or column then true
     * @param ch
     * @param col
     * @param row
     * @return
     */
    public boolean isWinner(String ch,int col,int row){
        return isWinnerOnColumn(ch,col) || isWinnerOnPrimaryDiagonal(ch) || isWinnerOnAtiDiagonal(ch) || isWinnerOnRow(ch,row);
    }

    /**
     * Formula of diagonal elements row==column
     *  x 0 0
     *  0 x 0
     *  0 0 x
     * @return
     */
    private boolean isWinnerOnPrimaryDiagonal(String ch){
        return board[0][0] == ch && board[1][1] ==ch && board[2][2] == ch;
    }

    /**
     * Formula antidiagonal elements row + column == length + 1
     *  0 0 x
     *  0 x 0
     *  x 0 0
     * @return
     */
    private boolean isWinnerOnAtiDiagonal(String ch){
        int numberOfOccurance = 0 ;
       for(int i = 0; i < board.length; i++ ){
           for(int j = 0; j < board.length; j++){
               if((i+j) == (board.length + 1) && board[i][j] == ch){
                   numberOfOccurance++;
               }
           }
       }
       return  numberOfOccurance == 3 ;
    }

    /**
     * if on given column there are three chars the same, then true
     * x 0 0
     * x 0 0
     * x 0 0
     * @param ch
     * @param col
     * @return
     */
    private boolean isWinnerOnColumn(String ch, int col){
        return (board[0][col] == ch) && (board[1][col] == ch) && (board[2][col] == ch);
    }

    /**
     * If on given row, there are three chars the same then true
     * @param ch
     * @param row
     * @return
     */
    private boolean isWinnerOnRow(String ch, int row){
        return (board[row][0] == ch) && (board[row][1]==ch) && (board[row][2] == ch);
    }
    
    public void printBoard(){
        System.out.println("Board");
        for(int i = 0 ; i < 3; i++){
            for( int j = 0 ; j < 3 ; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

