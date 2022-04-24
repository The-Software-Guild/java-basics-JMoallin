import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static int playerWin;
    public static int computerWin;
    public static int draw;
    public static boolean isGameOver;

    public static void main(String[] args){
        game();
    }

    public static void game(){
        isGameOver = false;
        while(!isGameOver) {
            try {
                playRounds();
                if (isGameOver == false) {
                    scoreboard();
                    restart();
                }
            } catch(NumberFormatException ex){
                System.out.println("Error! RPS 12394: That was not a number");
                isGameOver = true;
            }
        }
    }

    public static void playRounds(){
        System.out.println("Let's play rock, paper, scissors!");
        System.out.println("How many rounds do you wish to play?");
        int r = numberOfRounds();
        if (r != -1) {
            for (int i = 0; i < r; i++) {
                if(isGameOver == false) {
                    int pc = getPlayerChoice();
                    if (pc != -1) {
                        int cc = getComputerChoice();
                        String ww = getResult(cc, pc);
                        System.out.println("Round winner: " + ww);
                        System.out.println();
                    }else{
                        System.out.println("Error! RPS 17430: Incorrect number choice.");
                        isGameOver = true;
                    }
                }
            }
        } else {
            System.out.println("Error! RPS 13290: MAX 10 rounds.");
            isGameOver = true;
        }
    }

    public static int numberOfRounds(){
        Scanner ir = new Scanner(System.in);
        int x = Integer.parseInt(ir.nextLine());
        if(x > 0 && x < 11){
            return x;
        }
        return -1;
    }

    public static int getComputerChoice(){
        Random r = new Random();
        int i = r.nextInt(3)+1;
        int number = (i == 1) ? 1 : (i == 2) ? 2 : 3;
        String text = (i == 1) ? "Rock" : (i == 2) ? "Paper" : "Scissors";
        System.out.println("Computer play: " + text);
        return number;
    }

    public static int getPlayerChoice(){
        System.out.println("What is your play?");
        System.out.println("Rock: 1     Paper: 2     Scissors: 3");
        Scanner ir = new Scanner(System.in);
        int player = Integer.parseInt(ir.nextLine());
        if(player > 0 && player < 4){
            return player;
        }
        return -1;
    }

    public static String getResult(int computer, int player){
        boolean cWinner = false;
        boolean pWinner = false;
        if (computer == 1 && player == 3 || computer == 2 && player == 1 || computer == 3 && player == 2) {
            cWinner = true;
            computerWin = computerWin+1;
            return "Computer Wins!";
        } else if (player == 1 && computer == 3 || player == 2 && computer == 1 || player == 3 && computer == 2) {
            pWinner = true;
            playerWin = playerWin+1;
            return "Player Wins!";
        } else {
            draw = draw+1;
            return "Draw!";
        }
    }

    public static void scoreboard(){
        System.out.println("Scoreboard:");
        System.out.println("Player   |   Computer   |   Draw");
        System.out.println("   " + playerWin + "     |       " + computerWin + "      |     " + draw);
    }

    public static void restart(){
        System.out.println("Want to restart? [y/n]");
        Scanner ir = new Scanner(System.in);
        String x = ir.nextLine().toLowerCase();
        boolean exit = false;
        do {
            try {
                if (x.equals("y")) {
                    playerWin = 0;
                    computerWin = 0;
                    draw = 0;
                    game();
                } else if (x.equals("n")) {
                    System.out.println();
                    System.out.println("Thank you for playing!");
                    System.out.println();
                    exit = true;
                    isGameOver = true;
                }
            } catch (Exception e) {
                System.out.println("Error! RPS 13230: Incorrect input");
                isGameOver = true;
            }
        } while (!exit);
    }
}
