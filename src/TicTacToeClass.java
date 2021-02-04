public class TicTacToeClass
{
    // Instance Variables
    private char[][] board;
    private int turns;

    // Constructors
    public TicTacToeClass()
    {
        board = new char[3][3];
        turns = 0;

        for ( int r=0; r<3; r++ )
            for ( int c=0; c<3; c++ )
                board[r][c] = ' ';
    }

    // Accessor Methods

    public boolean isWinner( char p )
    {
        // rows
        for(int r = 0; r < 3; r++){
                if(board[r][0] == p
                && board[r][1] == p
                && board[r][2] == p){
                    return true;
                }
            }

        // columns
        for(int c = 0; c < 3; c++){
            if(board[0][c] == p
                    && board[1][c] == p
                    && board[2][c] == p){
                return true;
            }
        }

        // diagonals
        if(board[1][1] == p){
            if(board[0][0] == p && board[2][2] == p){
                return true;
            } else if(board[0][2] == p && board[2][0] == p){
                return true;
            }
        }

        return false;
    }

    public boolean isFull() {
        /* If any of the values on the board (after looping through them) is not full,
           then isFull returns false */
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCat() {
        // If the board is full and there was no winner
        if (isFull() && !isWinner('X') && !isWinner('O')){
            return true;
        }
        return false;
    }

    public boolean isValid( int r, int c )
    {
        if ( 0 <= r && r <= 2 && 0 <= c && c <= 2 )
            return true;
        else
            return false;
    }

    public int numTurns()
    {
        return turns;
    }

    public char playerAt( int r, int c )
    {
        if ( isValid(r,c) )
            return board[r][c];
        else
            return '@';
    }

    public void displayBoard()
    {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    public void playMove( char p, int r, int c )
    {
        board[r][c] = p;
    }

}