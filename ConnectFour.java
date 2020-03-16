import java.util.Scanner;

public class ConnectFour {

    public static void printBoard(char[][] array) { //This method prints the board, using the inputted length and height
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initializeBoard(char[][] array) { //This method sets every value in the array to '-'
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = '-';
            }
        }
    }
    public static int insertChip(char[][] array, int col, char chipType) {
        //This method adds a chip to the array, of the type that the player has
        int output = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][col] == '-') {
                array[i][col] = chipType;
                output = i;
                break;
            }
        }
        return output; /* This output is used in the checkIfWinner method, as it specifies what row the chip was
        inserted into. */
    }
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        //This method checks if either player has won, using the array, column & row number, and chip type
        boolean victory = false; //This is initialized as false, since the program checks every chip that's inputted.
        int vertRunCount = 1;
        int horRunCount = 1;
        for (int i = row; i > 0; i--) {
            //This for loop analyzes if there is a vertical victory, counting to see if there's 4 in a row.
            if (array[i][col] == array[i-1][col]) {
                vertRunCount += 1;
            }
            if (vertRunCount == 4) {
                victory = true;
                break; /*Since vertical and horizontal victory can coincide, and victory is never labeled as false past
                the initialization of the variable, if the horizontal victory is not achieved, it does not change
                victory = true.*/
            }
            if (array[i-1][col] != chipType) {
                break; //This stops the loop if the chip type doesn't match to what's in the next position.
            }
        }
        for (int j = col; j > 0; j--) {
            //This for loop analyzes if there is a horizontal victory, counting to see if there's 4 in a row.
            if (array[row][j] == array[row][j-1]) {
                horRunCount += 1;
            }
            if (horRunCount == 4) {
                victory = true;
                break;
            }
            if (array[row][j-1] != chipType) {
                break;
            }
        }
        return victory;
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); //Set the variable scnr to Scanner, to be used for user input
	    int rows;
	    int columns;
	    char player1 = 'x';
	    char player2 = 'o';
        char chipType;
	    int turns = 1;
        boolean victory;
        int playerNum; //These are all the variables that are used in the program.

        System.out.println("What would you like the height of the board to be? ");
        rows = scnr.nextInt();
        System.out.println("What would you like the length of the board to be? ");
        columns = scnr.nextInt(); //These two actions allow the user to input the height and length of the board.

        char[][] array = new char[rows][columns]; //The array, made in the dimensions that were inputted
        int spaces = (columns * rows); /*This variable is all of the spaces on the array, used for determining ties,
         and the for loop of the game so that it can alternate between Player 1 and 2*/
        initializeBoard(array);
        printBoard(array);

        System.out.println("Player 1:" + player1 + "\nPlayer 2:" + player2);
        for (int i = turns; i <= spaces; i++) { /*The for loop will run until all of the spaces are filled in the array.
         The '<=' operator allows the loop to run and fill the last space, and then call the game a tie.*/
            if ((i % 2) == 0) {
                //Since Player 2 always has an even turn, the program would follow this if statement.
                chipType = player2;
                playerNum = 2; //Sets the chip type to 'o', and the player number to 2
                System.out.print("Player 2: Which column would you like to choose? ");
            }
            else {
                //Since Player 1 always has an odd turn, the program would go to this statement by default.
                chipType = player1;
                playerNum = 1; //Sets the chip type to 'x', and the player number to 1
                System.out.print("Player 1: Which column would you like to choose? ");
            }
            int chooseColumn = scnr.nextInt();
            int row = insertChip(array, chooseColumn, chipType); /*This is the command that inserts the chip in the
            inputted column */
            printBoard(array); //This prints the board after every turn, evaluating victory afterward.
            victory = checkIfWinner(array, chooseColumn, row, chipType); /*This sets the variable 'victory' to the
             output of the method checkIfWinner. If either player won, it would be 'true', otherwise 'false' */
            if (victory == true && playerNum == 1) {
                System.out.println("Player 1 won the game!");
                break;
            }
            if (victory == true && playerNum == 2) {
                System.out.println("Player 2 won the game!"); /*These if statements include the '&&' operator so both
                 statements aren't printed if a Player wins.*/
                break;
            }
            if (i == spaces) {
                System.out.println("Draw. Nobody wins.");
                //If all the spaces are filled, then the program will print this before it exits the loop.
            }
        }
    }
}

