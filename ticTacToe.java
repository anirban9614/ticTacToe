import java.util.*;

public class ticTacToe {

    private static void printBord(char[][] gameBord) {
        /*
         * 1 | 2 | 3
         * - + - + -
         * 4 | 5 | 6
         * - + - + -
         * 7 | 8 | 9
         */

        for (char[] row : gameBord) {
            for (char column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }

    private static void playerTurn(char[][] gameBord, Scanner scanner) {
        String userInput;
        while (true) {
            System.out.print("where you wamt to play (1-9) ?  ---  ");
            userInput = scanner.nextLine();
            if (isValidMove(gameBord, userInput)) {
                break;
            } else {
                System.out.println(userInput + "  NOT A VALID MOVE! PLIEASE TRY AGAIN ");
            }
        }
        placeItems(gameBord, userInput, 'x');
    }

    private static void placeItems(char[][] gameBord, String position, char symbol) {
        switch (position) {
            case "1":
                gameBord[0][0] = symbol;
                break;

            case "2":
                gameBord[0][2] = symbol;
                break;

            case "3":
                gameBord[0][4] = symbol;
                break;

            case "4":
                gameBord[2][0] = symbol;
                break;

            case "5":
                gameBord[2][2] = symbol;
                break;

            case "6":
                gameBord[2][4] = symbol;
                break;

            case "7":
                gameBord[4][0] = symbol;
                break;

            case "8":
                gameBord[4][2] = symbol;
                break;

            case "9":
                gameBord[4][4] = symbol;
                break;

            default:
                System.out.println("wrong entry :( ");
        }
    }

    private static boolean isValidMove(char[][] gameBord, String position) {
        switch (position) {
            case "1":
                return (gameBord[0][0] == ' ');

            case "2":
                return (gameBord[0][2] == ' ');

            case "3":
                return (gameBord[0][4] == ' ');

            case "4":
                return (gameBord[2][0] == ' ');

            case "5":
                return (gameBord[2][2] == ' ');

            case "6":
                return (gameBord[2][4] == ' ');

            case "7":
                return (gameBord[4][0] == ' ');

            case "8":
                return (gameBord[4][2] == ' ');

            case "9":
                return (gameBord[4][4] == ' ');

            default:
                return false;
        }
    }

    private static void computerTurn(char[][] gameBord) {
        Random rand = new Random();
        int computerTurn;
        while (true) {
            computerTurn = rand.nextInt(9) + 1;
            if (isValidMove(gameBord, Integer.toString(computerTurn))) {
                break;
            }
        }
        System.out.println("computer chose -- " + computerTurn);
        placeItems(gameBord, Integer.toString(computerTurn), 'o');
    }

    private static boolean isGameFinished(char[][] gameBord) {

        if (chackWin(gameBord, 'x')) {
            printBord(gameBord);
            System.out.println("player win...");
            return true;
        }

        if (chackWin(gameBord, 'o')) {
            printBord(gameBord);
            System.out.println("computer win...");
            return true;
        }

        for (int i = 0; i < gameBord.length; i++) {
            for (int j = 0; j < gameBord[i].length; j++) {
                if (gameBord[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBord(gameBord);
        System.out.println("the game is tie...");
        return true;
    }

    private static boolean chackWin(char[][] gameBord, char symbol) {
        if ((gameBord[0][0] == symbol && gameBord[0][2] == symbol && gameBord[0][4] == symbol) ||
                (gameBord[2][0] == symbol && gameBord[2][2] == symbol && gameBord[2][4] == symbol) ||
                (gameBord[4][0] == symbol && gameBord[4][2] == symbol && gameBord[4][4] == symbol) ||

                (gameBord[0][0] == symbol && gameBord[2][0] == symbol && gameBord[4][0] == symbol) ||
                (gameBord[0][2] == symbol && gameBord[2][2] == symbol && gameBord[4][2] == symbol) ||
                (gameBord[0][4] == symbol && gameBord[2][4] == symbol && gameBord[4][4] == symbol) ||

                (gameBord[0][0] == symbol && gameBord[2][2] == symbol && gameBord[4][4] == symbol) ||
                (gameBord[0][4] == symbol && gameBord[2][2] == symbol && gameBord[4][0] == symbol)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] gameBord = { { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' } };

        printBord(gameBord);
        while (true) {

            playerTurn(gameBord, scanner);
            if (isGameFinished(gameBord)) {
                break;
            }
            printBord(gameBord);
            computerTurn(gameBord);
            if (isGameFinished(gameBord)) {
                break;
            }
            printBord(gameBord);
        }
        scanner.close();
    }
}