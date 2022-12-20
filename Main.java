import java.util.Scanner;
import java.util.Arrays;

public class Main {
    // Method to check if X wins
    public static boolean checkX (char[][] arr) {
        return (arr[0][0] == 'X' && arr[0][1] == 'X' && arr[0][2] == 'X'||
                arr[1][0] == 'X' && arr[1][1] == 'X' && arr[1][2] == 'X'||
                arr[2][0] == 'X' && arr[2][1] == 'X' && arr[2][2] == 'X'||
                arr[0][0] == 'X' && arr[1][0] == 'X' && arr[2][0] == 'X'||
                arr[0][1] == 'X' && arr[1][1] == 'X' && arr[2][1] == 'X'||
                arr[0][2] == 'X' && arr[1][2] == 'X' && arr[2][2] == 'X'||
                arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X'||
                arr[2][0] == 'X' && arr[1][1] == 'X' && arr[0][2] == 'X');
    }
    // Method to check if O wins
    public static boolean checkO (char[][] arr) {
        return (arr[0][0] == 'O' && arr[0][1] == 'O' && arr[0][2] == 'O'||
                arr[1][0] == 'O' && arr[1][1] == 'O' && arr[1][2] == 'O'||
                arr[2][0] == 'O' && arr[2][1] == 'O' && arr[2][2] == 'O'||
                arr[0][0] == 'O' && arr[1][0] == 'O' && arr[2][0] == 'O'||
                arr[0][1] == 'O' && arr[1][1] == 'O' && arr[2][1] == 'O'||
                arr[0][2] == 'O' && arr[1][2] == 'O' && arr[2][2] == 'O'||
                arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O'||
                arr[2][0] == 'O' && arr[1][1] == 'O' && arr[0][2] == 'O');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Creates empty 2d array
        char[][] arr = new char[3][3];
        // Fills empty arrray with whitespaces
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = ' ';
            }
        }

        System.out.println("---------\n"
                + "| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |\n"
                + "| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |\n"
                + "| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |\n"
                + "---------\n");
        // Counts how many moves is already done
        int counter = 0;
        // Loop terminates if there is no next input, the 9th move is executed or if there is a winner
        while (sc.hasNextLine() && counter < 9 && !checkX(arr) && !checkO(arr)) {
            String symbols = sc.nextLine();
            boolean result = symbols.matches("[0-9 ]+");
            //if input is not a number or whitespace, then print
            if (!result) {
                System.out.println("You should enter numbers!");
                continue;
            }
            //create an array form string and then coverts it to int
            String [] pieces = symbols.split(" ");
            int co1 = Integer.parseInt(pieces[0]);
            int co2 = Integer.parseInt(pieces[1]);
            if (co1 > 3 || co2 > 3){
                System.out.println("Coordinates should be from 1 to 3!");
            }else if (arr[co1-1][co2-1] == 'X' || arr[co1-1][co2-1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            }else {
                counter++;
                //X go first, then O, it depends on number of moves
                arr[co1-1][co2-1] = (counter % 2) == 0 ? 'O' : 'X';
                System.out.println("---------\n"
                        + "| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |\n"
                        + "| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |\n"
                        + "| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |\n"
                        + "---------\n");
            }
        }
        // Casts 2d array to string
        String arrToStr = Arrays.deepToString(arr);
        int countX = arrToStr.length() - arrToStr.replace("X", "").length();
        int countO = arrToStr.length() - arrToStr.replace("O", "").length();
        // Checks conditions for certain outcome
        if(Math.abs(countX - countO) > 1 || (checkX(arr) && checkO(arr))) {
            System.out.println("Impossible");
        } else if (checkX(arr)) {
            System.out.println("X wins");
        } else if (checkO(arr)) {
            System.out.println("O wins");
        } else if (countX + countO == 9) {
            System.out.println("Draw");
        }else {
            System.out.println("Game not finished");
        }
    }
}

