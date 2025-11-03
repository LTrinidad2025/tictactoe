package tictactoe;

public class ticTacToe {
    private char[][] board;
    public ticTacToe(){
        board = new char[3][3];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = Character.forDigit((j + 1) + (i * 3), 10);
            }
        }
    }

    public boolean playMove(int num, char tile){
        int record = num - 1;
        int row = record / 3;
        int col = record % 3;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        boolean returnVar;
        if(board[row][col] != 'X' || board[row][col] != 'O'){
            board[row][col] = tile;
            System.out.println("Player " + String.valueOf(tile) + " made a move at spot " + num + ".");
            returnVar = true;
        }else{
            System.out.println("This spot is filed. Choose another one.");
            returnVar = false;
        }
        displayBoard();
        return returnVar;
    }

    public void displayBoard(){
        for(int i = 0; i < board.length; i++){
            System.out.print(" +---+---+---+ \n");
            for(int j = 0; j < board[i].length; j++){
                System.out.print(" | " + String.valueOf(board[i][j]));
            }
            System.out.print(" | \n");
        }
        System.out.print(" +---+---+---+ \n");
    }

    public int checkWinner(int turn){
        if(board[0][0] == board[0][1] && board[0][0] == board[0][2] && (board[0][0] == 'X' || board[0][0] == 'O')){
            return turn;
        }else if(board[1][0] == board[1][1] && board[1][0] == board[1][2] && (board[1][0] == 'X' || board[1][0] == 'O')){
            return turn;
        }else if(board[2][0] == board[2][1] && board[2][0] == board[2][2] && (board[2][0] == 'X' || board[2][0] == 'O')){
            return turn;
        }else if(board[0][0] == board[1][0] && board[0][0] == board[2][0] && (board[0][0] == 'X' || board[0][0] == 'O')){
            return turn;
        }else if(board[0][1] == board[1][1] && board[0][1] == board[2][1] && (board[0][1] == 'X' || board[0][1] == 'O')){
            return turn;
        }else if(board[0][2] == board[1][2] && board[0][2] == board[2][2] && (board[0][2] == 'X' || board[0][2] == 'O')){
            return turn;
        }else if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && (board[1][1] == 'X' || board[1][1] == 'O')){
            return turn;
        }else if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && (board[1][1] == 'X' || board[1][1] == 'O')){
            return turn;
        }else{
            return -1;
        }
    }
}
