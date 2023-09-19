import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuesserGame {

    private int randomNumber;
    private int attempts;
    private int score;

    public GuesserGame() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1; // Generate a random number between 1 and 100
        attempts = 0;
        score = 0;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guesser Game!");
        System.out.println("Guess the number between 1 and 100.");

        do {
            System.out.print("Enter your guess (or 0 to quit): ");
            int userGuess = getUserInput(scanner);

            if (userGuess == 0) {
                System.out.println("Game over. You quit!");
                break;
            }

            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number!");
                score += (100 - attempts); // Calculate score based on attempts
                System.out.println("Score for this game: " + (100 - attempts));
                System.out.println("Total score: " + score);
                resetGame();
            } else if (userGuess < randomNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }

        } while (true);

        scanner.close();
    }

    private int getUserInput(Scanner scanner) {
        int userGuess = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                userGuess = scanner.nextInt();
                if (userGuess >= 0 && userGuess <= 100) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number between 0 and 100.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the buffer
            }
        }

        return userGuess;
    }


    private void resetGame() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
        attempts = 0;
    }

    public static void main(String[] args) {
        GuesserGame game = new GuesserGame();
        game.play();
    }
}
