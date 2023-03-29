import java.util.*;

public class TicTacToe {
    private static boolean hasWon(char[][] board, char player) {
        //check rows
        for(int row=0;row<board.length;row++)
        {
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player)
            {
                return true;
            }
        }
        //check column
        for(int col=0;col<board.length;col++)
        {
            if(board[0][col]==player && board[1][col]==player && board[1][col]==player)
            {
                return true;
            }
        }
        //diagonal check
        if(board[0][0] == player && board[1][1]== player && board[2][2]== player)
        {
            return true;
        }
        if(board[0][2] == player && board[1][1]== player && board[2][0]== player)
        {
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        for(int row=0;row<board.length;row++)
        {
            System.out.println();
            for(int col=0;col<board[row].length;col++)
            {
               System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board= new char[3][3];
        for(int row=0;row<board.length;row++)//initialising the board
        {
            for(int col=0;col<board[row].length;col++)
            {
                board[row][col]=' ';
            }
        }
        char player = 'X';
        boolean gameOver=false;
        Scanner ob=new Scanner(System.in);
        while(!gameOver)
        {
            printBoard(board);
            System.out.println("Player "+player+" enter :");
            int row=ob.nextInt();
            int col=ob.nextInt();

            if(board[row][col]==' ')
            {
                board[row][col]=player;//place the element
                gameOver= hasWon(board,player);
                if(gameOver)
                {
                    printBoard(board);
                    System.out.println("Player "+player+" has won.");
                }
                else{
                    if(player=='X')
                    {
                        player='O';
                    }
                    else{
                        player='X';
                    }
                    //player= (player=='X')? 'O':'X';
                }
            }
            else{
                System.out.println("Invalid move. Try again!!");
            }
        }
    }
}
