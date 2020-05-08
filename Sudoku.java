public class Sudoku {
    
    public static int[][] board = 
    {{9,0,0,1,0,0,0,0,5},
    {0,0,5,0,9,0,2,0,1},
    {8,0,0,0,4,0,0,0,0},
    {0,0,0,0,8,0,0,0,0},
    {0,0,0,7,0,0,0,0,0},
    {0,0,0,0,2,6,0,0,9},
    {2,0,0,3,0,0,0,0,6},
    {0,0,0,2,0,0,9,0,0},
    {0,0,1,9,0,4,5,7,0}};

    public static int numRows = 9;
    public static int numCols = 9;


    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        
        System.out.println("Board to be solved:");
        sudoku.display();

        sudoku.solve(board);

        System.out.println("\n\nSolved board:");
        sudoku.display();
    }

    private boolean solve(int[][] board) {
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                if (board[row][col] == 0) {
                    for(int entry = 1; entry <= 9; entry++) {
                        
                        //Check entry validity 
                        if(isValid(row, col, entry)) {
                            board[row][col] = entry;

                            // begin recursion with backtracking
                            if (solve(board)) {
                                return true;
                            }
                        }
                        board[row][col] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, int entry) {
        //check rows
        for (int currCol = 0; currCol < numCols; currCol++) {
            if (board[row][currCol] == entry) {
                return false;
            }
        }

        //check columns
        for (int currRow = 0; currRow < numRows; currRow++) {
            if (board[currRow][col] == entry) {
                return false;
            }
        }

        //check 3x3 square
        int r = row - row % 3;
        int c = col - col % 3;

        for (int currRow = r; currRow < r +3; currRow++) {
            for (int currCol = c; currCol < c + 3; currCol++) {
                if (board[currRow][currCol] == entry) {
                    return false;
                }
            }
        }

        return true;
    }

    private void display() {
        for(int row = 0; row < numRows; row++) {

            
            if (row > 1 && (row % 3)== 0) {
                System.out.println("");
                for (int i = 0; i < 11; i ++) {
                    System.out.print("-" + " ");
                } 
            }

            System.out.println("");
            
            for(int col = 0; col < numCols; col++) {
                
                if (col > 0 && col % 3 == 0) {
                    System.out.print("| " + board[row][col] + " ");
                }
                else {
                    System.out.print(board[row][col] + " ");
                }
            }

        }
    }
}